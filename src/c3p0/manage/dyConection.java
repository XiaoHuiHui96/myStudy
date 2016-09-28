package c3p0.manage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;


public class dyConection implements InvocationHandler {

	//����	
	/** ���е����ӳ� */
	LinkedList<Connection> idleList=new LinkedList<Connection>();
	/** æ�����ӳ� */
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
		//�жϷ����Ƿ��ǹرգ�������������ִ��
		if(method.getName()=="close"){
			System.out.println("�ر�");
			System.out.println("�������"+idleList.size()+"æ"+busyList.size());
			Connection closeCon=(Connection)con;
			/** �����±� */
			int index=0;
			for(Connection e: busyList){
				if(e.equals(closeCon)){
					System.out.println("�ɹ�"+index);
					//�ƶ�
					busyList.remove(index);
					idleList.add(e);
				}
				index++;
			}
			System.out.println("�������"+idleList.size()+"æ"+busyList.size());
		}else{
			Object restul=method.invoke(con, args);
			return restul;
		}
		return null;
		
		
	}

	
}
