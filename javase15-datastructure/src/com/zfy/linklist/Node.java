package com.zfy.linklist;

public class Node {
	private Object data;//存储数据；
	private Node next;//存储节点；
	
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
