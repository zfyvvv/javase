package com.zfy.doublelinklist;

import com.zfy.arraylist.MyList;
import com.zfy.exception.MyLineTableException;

public class MyDoubleLinkList implements MyList{
	private Nodee first;
	private Nodee last;
	private int  size;

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
		//�ж�����λ�ã�
		if(i<0 || i>size) {
			throw new MyLineTableException("��������Խ���쳣��"+i);
		}
		//�½���Ҫ����Ľڵ㣻
		Nodee newNodee=new Nodee(e);
		//����i��λ�ã��ҳ�ָ��λ�ã��½ڵ��ڸ�λ�ú���룻
		Nodee p=first;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		if(first!=null) {
			//�½ڵ��next���Ӻ�һ��ǰ�ڵ㣻
			newNodee.setNext(p.getNext());
			p.setPre(newNodee);
			//����ǰһ���ڵ㣻
			p.setNext(newNodee);
			newNodee.setPre(p);
			
		}else {
			//�½ڵ��next���Ӻ�һ��ǰ�ڵ�last��
			newNodee.setNext(last);
			last.setPre(newNodee);
			//����ǰһ���ڵ㣻
			first.setNext(newNodee);
			newNodee.setPre(first);
		}
		//Ԫ�ظ������ӣ�
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean replace(int i, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

}
