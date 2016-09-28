package c3p0.manage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;


public class dyConection implements InvocationHandler {

	//保存	
	/** 空闲的连接池 */
	LinkedList<Connection> idleList=new LinkedList<Connection>();
	/** 忙的连接池 */
	LinkedList<Connection> busyList=new LinkedList<Connection>();
	private Object  con=null;
	public dyConection(Object obj,LinkedList<Connection> idleList,LinkedList<Connection> busyList){
		this.con = obj;
		this.idleList=idleList;
		this.busyList=busyList;
	}
	public dyConection(Object obj){
		this.con = obj;
	}
	public Object getInt(){
		return Proxy.newProxyInstance(con.getClass().getClassLoader(), con.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//判断方法是否是关闭，是则处理，不是则执行
		if(method.getName()=="close"){
			System.out.println("关闭");
			System.out.println("代理空闲"+idleList.size()+"忙"+busyList.size());
			Connection closeCon=(Connection)con;
			/** 保存下标 */
			int index=0;
			for(Connection e: busyList){
				if(e.equals(closeCon)){
					System.out.println("成功"+index);
					//移动
					busyList.remove(index);
					idleList.add(e);
				}
				index++;
			}
			System.out.println("代理空闲"+idleList.size()+"忙"+busyList.size());
		}else{
			Object restul=method.invoke(con, args);
			return restul;
		}
		return null;
		
		
	}

	
}
