package c3p0.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;

import com.Link.LinkList;
import com.error.c3p0Error;

import c3p0.config.ReadConfig;
import c3p0.config.configEntity;
/**
 * c3p0核心管理类
 * @author Administrator
 *
 */
public class manager  {
	/** 配置文件实体类 */
	private configEntity config=null;
	/** 空闲的连接池 */
	LinkedList<Connection> idleList=new LinkedList<Connection>();
	/** 忙的连接池 */
	LinkedList<Connection> busyList=new LinkedList<Connection>();
	public manager(String name) throws Exception{
		 Map<String,configEntity> map=ReadConfig.getReadConfig().getConfigMap();
		config=map.get(name);
		if(config==null){
			throw new c3p0Error("没有读取到配置文件");
		}
		if(initialise()){
			System.out.println("初始化成功");
		}else{
			throw new c3p0Error("初始化失败");
		}
		System.out.println(idleList.size());
	}
	private boolean initialise(){
		//转载驱动
		System.out.println("开始初始化");
		System.out.println("驱动包："+config.getDriverClass());
		System.out.println("初始化连接池"+config.getInitialPoolSize());
		System.out.println("url:"+config.getJdbcUrl());
		System.out.println("超时时间"+config.getMaxIdleTime());
		System.out.println("最大连接数"+config.getMaxPoolSize());
		System.out.println("密码"+config.getPassword());
		System.out.println("用户"+config.getUser());
		System.out.println("最大语句数"+config.getMaxStatements());
		System.out.println("最小连接"+config.getMinPoolSize());
		for(int i=0;i<config.getMinPoolSize();i++){
			try {
				Connection con=getNewConnection();
				idleList.add(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	/**
	 * 获取一个连接
	 * @return
	 */
	private Connection getNewConnection(){
		//当大于最大连接数则不创建
		if(busyList.size()>=config.getMaxPoolSize()){
			System.out.println("连接池满了创建");
			return null;
		}
		Connection con=null;
		try {
			Class.forName(config.getDriverClass());
			con=DriverManager.getConnection(config.getJdbcUrl(),config.getUser(),config.getPassword());
		} catch (ClassNotFoundException e1) {
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dyConection dy=new dyConection(con,idleList,busyList);
		Connection dyCon=(Connection)dy.getInt();
		return dyCon;
	}
	/**
	 * 获取连接
	 * @return
	 * @throws c3p0Error
	 */
	public Connection getConnection() throws c3p0Error{
		System.out.println("当前空闲"+idleList.size()+"忙"+busyList.size());
		Connection con=null;
		if(idleList.size()<=0){
			con = getNewConnection();
			if(con==null){
				throw new c3p0Error("空闲池已满");
			}
		}else{
			try {
				con=idleList.getFirst();//拿到
				idleList.removeFirst();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new c3p0Error("获取连接失败");
			}
		}
		try {
			busyList.add(con);//把连接加到忙的连接池
		} catch (Exception e) {
			throw new c3p0Error(e.getMessage());
		}
		return con;
	}
}
