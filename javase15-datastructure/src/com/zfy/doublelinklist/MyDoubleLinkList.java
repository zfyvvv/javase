package com.zfy.doublelinklist;

import com.zfy.arraylist.MyList;
import com.zfy.btree.Node;
import com.zfy.exception.MyLineTableException;

public class MyDoubleLinkList implements MyList{
	//新建两个空节点，方便操作，一定要new出来；
	private Nodee first=new Nodee();
	private Nodee last=new Nodee();
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
		// TODO Auto-generated method stub
		this.add(size, e);
	}

	@Override
	public void add(int i, Object e) {
		//判断索引位置；
		if(i<0 || i>size) {
			throw new MyLineTableException("数组索引越界异常："+i);
		}

		//根据i的位置；找出指针位置；新节点在给位置后插入；
		Nodee p=first;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		//新建需要插入的节点；
		Nodee newNodee=new Nodee(e);
		
		//双向链表是4步；先设置newNodee的前驱（前节点）和后继（后节点），后设置后节点的前驱，后搞定前节点的后继；
		//1.把P赋值给newNodee的前驱；2.把p.next赋值给newNodee的后继；
		//3.把newNodee赋值给p.next的前驱；4.把newNodee赋值给p的后继；
		
		if(p.getNext()==null) {//从空链表开始插入；条件为头节点为first的后继为null；
			newNodee.setPre(first);
			newNodee.setNext(last);
			p.setNext(newNodee);
			last.setPre(newNodee);
			
		}else {
		newNodee.setPre(p);
		newNodee.setNext(p.getNext());
		p.setNext(newNodee);
		p.getNext().setPre(newNodee);
		}
		//元素个数增加；
		size++;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		remove(size-1);
	}

	@Override
	public void remove(int i) {
		if(i<0 || i>size) {
			throw new MyLineTableException("数组索引越界异常："+i);
		}
		
		Nodee p=first.getNext();
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		System.out.println("##");
		System.out.println(p.getPre().getData());
		System.out.println(p.getData());
		System.out.println(p.getNext().getData());
		System.out.println("##");
		//把p的后继赋值给p的前驱的后继；把p的前驱赋值给p的后继的前驱；
		p.getPre().setNext(p.getNext());
		p.getNext().setPre(p.getPre());
		size--;
	}

	@Override
	public void remove(Object e) {
		Nodee p=first.getNext();
		int index=-1;
		for(int i=0;i<size;i++) {
			if(p.getData().equals(e)) {
				index=i;
			}
			p=p.getNext();
		}
		System.out.println(index);
		remove(index);
	}

	@Override
	public Object get(int i) {
		Nodee p=first.getNext();
		for(int j=0;j<i;j++) {
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
		StringBuilder sb=new StringBuilder("[");
		Nodee p=first;
		for(int i=0;i<size;i++) {
			p=p.getNext();
			if(i<size-1) {
			sb.append(p.getData()).append(",");
			}else {
				sb.append(p.getData());
			}
		}
		sb=sb.append("]");
		return sb.toString();
	}
	

}
