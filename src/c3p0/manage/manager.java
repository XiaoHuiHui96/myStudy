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
 * c3p0���Ĺ�����
 * @author Administrator
 *
 */
public class manager  {
	/** �����ļ�ʵ���� */
	private configEntity config=null;
	/** ���е����ӳ� */
	LinkedList<Connection> idleList=new LinkedList<Connection>();
	/** æ�����ӳ� */
	LinkedList<Connection> busyList=new LinkedList<Connection>();
	public manager(String name) throws Exception{
		 Map<String,configEntity> map=ReadConfig.getReadConfig().getConfigMap();
		config=map.get(name);
		if(config==null){
			throw new c3p0Error("û�ж�ȡ�������ļ�");
		}
		if(initialise()){
			System.out.println("��ʼ���ɹ�");
		}else{
			throw new c3p0Error("��ʼ��ʧ��");
		}
		System.out.println(idleList.size());
	}
	private boolean initialise(){
		//ת������
		System.out.println("��ʼ��ʼ��");
		System.out.println("��������"+config.getDriverClass());
		System.out.println("��ʼ�����ӳ�"+config.getInitialPoolSize());
		System.out.println("url:"+config.getJdbcUrl());
		System.out.println("��ʱʱ��"+config.getMaxIdleTime());
		System.out.println("���������"+config.getMaxPoolSize());
		System.out.println("����"+config.getPassword());
		System.out.println("�û�"+config.getUser());
		System.out.println("��������"+config.getMaxStatements());
		System.out.println("��С����"+config.getMinPoolSize());
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
	 * ��ȡһ������
	 * @return
	 */
	private Connection getNewConnection(){
		//����������������򲻴���
		if(busyList.size()>=config.getMaxPoolSize()){
			System.out.println("���ӳ����˴���");
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
	 * ��ȡ����
	 * @return
	 * @throws c3p0Error
	 */
	public Connection getConnection() throws c3p0Error{
		System.out.println("��ǰ����"+idleList.size()+"æ"+busyList.size());
		Connection con=null;
		if(idleList.size()<=0){
			con = getNewConnection();
			if(con==null){
				throw new c3p0Error("���г�����");
			}
		}else{
			try {
				con=idleList.getFirst();//�õ�
				idleList.removeFirst();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new c3p0Error("��ȡ����ʧ��");
			}
		}
		try {
			busyList.add(con);//�����Ӽӵ�æ�����ӳ�
		} catch (Exception e) {
			throw new c3p0Error(e.getMessage());
		}
		return con;
	}
}
