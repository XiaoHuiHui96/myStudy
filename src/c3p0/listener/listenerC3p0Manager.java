package c3p0.listener;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import c3p0.manage.manager;

public class listenerC3p0Manager implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 监听
	 * 测试
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("启动");
		try {
			manager m=new manager("oracle");
			Connection c=m.getConnection();
			System.out.println(c==null);
			System.out.println("第二次");
			Connection c1=m.getConnection();
			System.out.println("第三次");
			Connection c2=m.getConnection();
			System.out.println("测试关闭连接");
			c2.close();
			System.out.println("测试最大连接数和已经满了");
			System.out.println("第四次");
			Connection c3=m.getConnection();
			System.out.println("第五次");
			Connection c4=m.getConnection();
			System.out.println("第六次");
			Connection c5=m.getConnection();
			System.out.println("第七次");
			Connection c6=m.getConnection();
			System.out.println("已经满了");
			Connection c7=m.getConnection();
			Connection c8=m.getConnection();
			Connection c9=m.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
