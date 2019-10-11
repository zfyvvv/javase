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
		//�ж�i��ȡֵ��Χ��
		if(i<0 || i>size) {
			throw new MyLineTableException("��������Խ���쳣��"+i);
		}
		//���ҵ������λ�ã���Ҫ����ͷ�ڵ㣻
		Node p=head;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		//�½���Ҫ����Ľڵ㣻�����Ӻ�ڵ㣬������ǰ�ڵ㣻
		Node newNode=new Node(e);
		//���Ӻ�һ���ڵ㣻��newNodeΪnext�ڵ�Ϊp����һ���ڵ㣻
		newNode.setNext(p.getNext());
		//����ǰһ���ڵ㣬��newNodeΪ�ڵ�P�ĺ�һ���ڵ㣻
		p.setNext(newNode);
		//Ԫ���������ӣ�
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
		//�ж�i��ȡֵ��Χ��
		if(i<0 || i>size) {
			throw new MyLineTableException("��������Խ���쳣��"+i);
		}
		//��ͷ��ʼ�ң�������Ҫj<=i����Ϊhead�ڵ�Ϊ�գ��Ѿ�ռ����0��λ�ã���Ҫ������ƶ�һλ��
		Node p=head;
		for(int j=0;j<=i;j++) {
			//�����ƶ���
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
		//�����ַ�ʽ��
		//1.��ʱ�ڵ������ָ��ͷ�ڵ㣬Ȼ����ѭ����ʼ���ƶ�ָ�룬����ָ���ҵ����ݣ�
		Node p=head;
		for(int i=0;i<size;i++) {
			p=p.getNext();
			if(i!=size-1) {
				bulider.append(p.getData()).append(",");
			}else {
				bulider.append(p.getData());
			}
		}
		//2.��ʱ�ڵ������ָ��ͷ�ڵ����һ�ڵ㣬Ȼ����ѭ����ֱ�Ӵ�ӡ���ݣ�ѭ������ʱ�ƶ�ָ�룻
	/*	Node p=head.getNext();
		for(int i=0;i<size;i++) {
		
			if(i!=size-1) {
				bulider.append(p.getData()).append(",");
			}else {
				bulider.append(p.getData());
			}
			//�ƶ�ָ�룻
			p=p.getNext();
		}*/
		bulider.append("]");
		return bulider.toString();
	}
}
