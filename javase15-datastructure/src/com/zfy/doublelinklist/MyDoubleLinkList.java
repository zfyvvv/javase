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
		//当i=0时，此时的指针P还是指向first；相当于队首添加；
		//当i=size时，此时的指针P还是指向last；相当于队尾添加；
		//当0<i<size时，此时的指针P还是指向下标为n的节点；相当于队中添加；
		
		
		//新建需要插入的节点；
		Nodee newNodee=new Nodee(e);
		
		newNodee.setPre(p);
		newNodee.setNext(p.getNext());
		
		p.setNext(newNodee);
		p.getNext().setPre(newNodee);
		
		/*if(first==null) {//当i=0时；插入的位置是第一个；
			//新节点的next连接后一个前节点last；
			newNodee.setNext(null);
			//连接前一个节点；
			newNodee.setPre(null);
			first=newNodee;
			last=newNodee;
			
		}else if(p.getNext()==null){//当i=size时；插入的位置是最后一个；
			//修改当前节点的前后节点；
			//新节点的next连接后一个前节点；
			newNodee.setPre(p);
			newNodee.setNext(null);
			//连接前一个节点；
			last.setNext(newNodee);
			last=newNodee;
			
		}else{//在中间插入；
			newNodee.setPre(p);
			newNodee.setNext(p.getNext());
			
			p.setNext(newNodee);
			p.getNext().setPre(newNodee);
		}*/
		//元素个数增加；
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
		Nodee p=first;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		return p.getNext().getData();
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
