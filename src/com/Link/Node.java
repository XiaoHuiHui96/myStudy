package com.Link;

/**
 * �ڵ�
 * @author Administrator
 *
 */
public class Node {

	protected Node next;//ָ����ָ����һ���ڵ�
	protected Object data;//�����򣬱���ýڵ������
	public Node(Object data){
		this.data=data;
	}
	public void view(){
		System.out.println(data);
	}
	public Object getdata(){
		return data;
	}
}
