package com.zfy.linklist;

import com.zfy.arraylist.MyList;
import com.zfy.exception.MyLineTableException;

public class MySingleLinkList implements MyList{
	private Node head=new Node();
	private int size;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Object e) {
		this.add(size, e);
	}

	@Override
	public void add(int i, Object e) {
		//判断i的取值范围；
		if(i<0 || i>size) {
			throw new MyLineTableException("数组索引越界异常："+i);
		}
		//先找到插入的位置；需要借助头节点；
		Node p=head;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		//新建需要插入的节点；先连接后节点，后连接前节点；
		Node newNode=new Node(e);
		//连接后一个节点；即newNode为next节点为p的下一个节点；
		newNode.setNext(p.getNext());
		//连接前一个节点，即newNode为节点P的后一个节点；
		p.setNext(newNode);
		//元素数量增加；
		size++;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int i) {
		//判断i的取值范围；
		if(i<0 || i>size) {
			throw new MyLineTableException("数组索引越界异常："+i);
		}
		//从头开始找；这里需要j<=i；因为head节点为空，已经占据了0的位置，需要再向后移动一位；
		Node p=head;
		for(int j=0;j<=i;j++) {
			//索引移动；
			p=p.getNext();
		}
		return p.getData();
	}

	@Override
	public boolean replace(int i, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		if(size==0) {
			return "[]";
		}
		StringBuilder bulider=new StringBuilder("[");
		//有两种方式；
		//1.临时节点可以先指定头节点，然后在循环开始后移动指针，根据指针找到数据；
		Node p=head;
		for(int i=0;i<size;i++) {
			p=p.getNext();
			if(i!=size-1) {
				bulider.append(p.getData()).append(",");
			}else {
				bulider.append(p.getData());
			}
		}
		//2.临时节点可以先指定头节点的下一节点，然后在循环后直接打印数据；循环结束时移动指针；
	/*	Node p=head.getNext();
		for(int i=0;i<size;i++) {
		
			if(i!=size-1) {
				bulider.append(p.getData()).append(",");
			}else {
				bulider.append(p.getData());
			}
			//移动指针；
			p=p.getNext();
		}*/
		bulider.append("]");
		return bulider.toString();
	}
}
