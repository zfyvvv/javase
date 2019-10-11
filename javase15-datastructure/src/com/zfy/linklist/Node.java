package com.zfy.linklist;

public class Node {
	private Object data;//�洢���ݣ�
	private Node next;//�洢�ڵ㣻
	
	public Node(Object data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(Object data) {
		super();
		this.data = data;
	}
	public Node() {
		super();
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	
	

}
