package com.Link;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ������
 * @author Administrator
 *
 * @param <T>
 */
public class LinkList<T> {

	
	private Node first;//ͷ�ڵ�
	private  int sum=0;//����
	public LinkList(){
		this.first=null;
	}
	/**
	 * �ж�ͷ�ڵ��Ƿ�Ϊ��
	 * @throws Exception
	 */
	private void checkNull() throws Exception{
		if(first==null){
			throw new Exception("����Ϊ��");
		}
	}
	private void checkScope(int index) throws Exception{
		if(index>sum){
			throw new Exception("������Χ");
		}
	}
	/**
	 * ��������
	 * @return
	 */
	public int size(){
		return sum;
	}
	/**
	 * ���һ��ͷ�ڵ�
	 * @param data
	 * @throws Exception 
	 */
	public void addFirstNode(T data) {
		Node node=new Node(data);
		node.next=first;//�Ѹýڵ�ĵ�ַ��ָ��ͷ�ڵ�
		first=node;//ͷ�ڵ�ĸ���
		sum++;
	}
	public Node getFirstNode(){
		return first;
	}
	/**
	 * ɾ��ͷ���
	 * @return
	 * @throws Exception 
	 */
	public Node deleteFirstNode() throws Exception{
		checkNull();
		if(sum==0){
			return null;
		}
		Node tempNode=first;//���浱ǰͷ��㣬���ڷ���
		first=tempNode.next;//���¸��ڵ㸳ֵ��ͷ�ڵ�
		sum--;
		return tempNode;
	}
	/**
	 * ��ӽڵ�
	 * @param data
	 * @throws Exception 
	 */
	public void add(T data) throws Exception{
		if(sum==0){
			addFirstNode(data);
			return;
		}
		add(sum,data);//Ĭ�����
	}
	/**
	 * ��ӽڵ�
	 * @param index�����λ��
	 * @param data����
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
		//ѭ������λ�õĽڵ�
		for(int i=0;i<index;i++){
			previous=current;//���浱ǰ�ڵ�
			current=current.next;//������һ���ڵ�
		}
		node.next=current;
		previous.next=node;
		sum++;
	}
	/**
	 * ɾ���ڵ�
	 * @param indexɾ����λ��
	 * @throws Exception 
	 * @return����һ����ɾ���Ľڵ�
	 */
	public Node deleteByPos(int index) throws Exception{
		if(sum==0){
			return null;
		}
		checkScope(index);
		Node current=first;
		Node previous= first;
		//ѭ������λ�õĽڵ�
		for(int i=0;i<index;i++){
			previous=current;//���浱ǰ�ڵ�
			System.out.println("ѭ��"+i+":"+previous.data);
			current=current.next;//������һ���ڵ�
			System.out.println("��ǰ�ڵ�"+current.data);
		}
		if(current==first){
			//λ���ǵ�һ����ͷ���
			first=first.next;
		}else{
			//����λ��
			previous.next=current.next;
			//current=null;
		}
		sum--;
		return current;
	}
	/**
	 * ɾ���ڵ�
	 * @param data��������
	 * @return
	 */
	public Node deleteByData(T data){
		Node current=first;
		Node previous= first;
		for(int i=0;i<sum;i++){
			if(current.data==data){
				System.out.println("����ѭ��");
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
	 * �������
	 */
	public void displayAllNodes(){
		Node current = first;
		for(int i=0;i<sum;i++){
			current.view();
			current=current.next;
			
		}
	}
	/**
	 * ���ҽڵ����Ϣ
	 * @param index λ��
	 * @return ����һ���ڵ�
	 * @throws Exception 
	 */
	public Node findByPos(int index) throws Exception{
		checkScope(index);
		Node current=first;
		
		for(int i=0;i<index;i++){
			System.out.println("�ڵ���Ϣ"+current.data);
			current=current.next;
			
		}
		return current;
	}
	/**
	 * ���ҽڵ�
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
