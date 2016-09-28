package com.Link;

/**
 * 节点
 * @author Administrator
 *
 */
public class Node {

	protected Node next;//指针域，指向下一个节点
	protected Object data;//数据域，保存该节点的数据
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
