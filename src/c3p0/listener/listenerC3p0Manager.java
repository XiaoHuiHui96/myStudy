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
	 * ����
	 * ����
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("����");
		try {
			manager m=new manager("oracle");
			Connection c=m.getConnection();
			System.out.println(c==null);
			System.out.println("�ڶ���");
			Connection c1=m.getConnection();
			System.out.println("������");
			Connection c2=m.getConnection();
			System.out.println("���Թر�����");
			c2.close();
			System.out.println("����������������Ѿ�����");
			System.out.println("���Ĵ�");
			Connection c3=m.getConnection();
			System.out.println("�����");
			Connection c4=m.getConnection();
			System.out.println("������");
			Connection c5=m.getConnection();
			System.out.println("���ߴ�");
			Connection c6=m.getConnection();
			System.out.println("�Ѿ�����");
			Connection c7=m.getConnection();
			Connection c8=m.getConnection();
			Connection c9=m.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
