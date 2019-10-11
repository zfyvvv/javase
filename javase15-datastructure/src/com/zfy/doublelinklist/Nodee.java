package com.zfy.doublelinklist;

public class Nodee {
	private Object data;
	private Nodee next;
	private Nodee pre;
	
	public Nodee() {
		// TODO Auto-generated constructor stub
	}

	public Nodee(Object data, Nodee next, Nodee pre) {
		super();
		this.data = data;
		this.next = next;
		this.pre = pre;
	}

	public Nodee(Nodee next, Nodee pre) {
		super();
		this.next = next;
		this.pre = pre;
	}
	

	public Nodee(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Nodee getNext() {
		return next;
	}

	public void setNext(Nodee next) {
		this.next = next;
	}

	public Nodee getPre() {
		return pre;
	}

	public void setPre(Nodee pre) {
		this.pre = pre;
	}
}
