package com.Link;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 链表集合
 * @author Administrator
 *
 * @param <T>
 */
public class LinkList<T> {

	
	private Node first;//头节点
	private  int sum=0;//总数
	public LinkList(){
		this.first=null;
	}
	/**
	 * 判断头节点是否为空
	 * @throws Exception
	 */
	private void checkNull() throws Exception{
		if(first==null){
			throw new Exception("内容为空");
		}
	}
	private void checkScope(int index) throws Exception{
		if(index>sum){
			throw new Exception("超出范围");
		}
	}
	/**
	 * 返回总数
	 * @return
	 */
	public int size(){
		return sum;
	}
	/**
	 * 添加一个头节点
	 * @param data
	 * @throws Exception 
	 */
	public void addFirstNode(T data) {
		Node node=new Node(data);
		node.next=first;//把该节点的地址域指向头节点
		first=node;//头节点的更改
		sum++;
	}
	public Node getFirstNode(){
		return first;
	}
	/**
	 * 删除头结点
	 * @return
	 * @throws Exception 
	 */
	public Node deleteFirstNode() throws Exception{
		checkNull();
		if(sum==0){
			return null;
		}
		Node tempNode=first;//保存当前头结点，用于返回
		first=tempNode.next;//把下个节点赋值给头节点
		sum--;
		return tempNode;
	}
	/**
	 * 添加节点
	 * @param data
	 * @throws Exception 
	 */
	public void add(T data) throws Exception{
		if(sum==0){
			addFirstNode(data);
			return;
		}
		add(sum,data);//默认最后
	}
	/**
	 * 添加节点
	 * @param index插入的位置
	 * @param data参数
	 * @throws Exception 
	 */
	public void add(int index,T data) throws Exception{
		checkScope(index);
		if(sum==0){
			addFirstNode(data);
			return;
		}
		Node node=new Node(data);
		Node current=first;
		Node previous=first;
		//循环到该位置的节点
		for(int i=0;i<index;i++){
			previous=current;//保存当前节点
			current=current.next;//保存下一个节点
		}
		node.next=current;
		previous.next=node;
		sum++;
	}
	/**
	 * 删除节点
	 * @param index删除的位置
	 * @throws Exception 
	 * @return返回一个被删除的节点
	 */
	public Node deleteByPos(int index) throws Exception{
		if(sum==0){
			return null;
		}
		checkScope(index);
		Node current=first;
		Node previous= first;
		//循环到该位置的节点
		for(int i=0;i<index;i++){
			previous=current;//保存当前节点
			System.out.println("循环"+i+":"+previous.data);
			current=current.next;//保存下一个节点
			System.out.println("当前节点"+current.data);
		}
		if(current==first){
			//位置是第一个，头结点
			first=first.next;
		}else{
			//其他位置
			previous.next=current.next;
			//current=null;
		}
		sum--;
		return current;
	}
	/**
	 * 删除节点
	 * @param data根据内容
	 * @return
	 */
	public Node deleteByData(T data){
		Node current=first;
		Node previous= first;
		for(int i=0;i<sum;i++){
			if(current.data==data){
				System.out.println("跳出循环");
				break;
			}
			previous=current;
			current=current.next;
			System.out.println(current.data);
		}
		if(current==first){
			first=first.next;
		}else{
			previous.next=current.next;
		}
		sum--;
		return current;
	}
	/**
	 * 测试输出
	 */
	public void displayAllNodes(){
		Node current = first;
		for(int i=0;i<sum;i++){
			current.view();
			current=current.next;
			
		}
	}
	/**
	 * 查找节点的信息
	 * @param index 位置
	 * @return 返回一个节点
	 * @throws Exception 
	 */
	public Node findByPos(int index) throws Exception{
		checkScope(index);
		Node current=first;
		
		for(int i=0;i<index;i++){
			System.out.println("节点信息"+current.data);
			current=current.next;
			
		}
		return current;
	}
	/**
	 * 查找节点
	 * @param data
	 * @return
	 */
	public Node findByData(T data){
		Node current=first;
		for(int i=0;i<sum;i++){
			if(current.data==data){
				break;
			}
			current=current.next;
		}
		return current;
	}
}
