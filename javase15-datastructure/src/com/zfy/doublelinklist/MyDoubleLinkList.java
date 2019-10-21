package com.zfy.doublelinklist;

import com.zfy.arraylist.MyList;
import com.zfy.btree.Node;
import com.zfy.exception.MyLineTableException;

public class MyDoubleLinkList implements MyList{
	//�½������սڵ㣬���������һ��Ҫnew������
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
		//�ж�����λ�ã�
		if(i<0 || i>size) {
			throw new MyLineTableException("��������Խ���쳣��"+i);
		}

		//����i��λ�ã��ҳ�ָ��λ�ã��½ڵ��ڸ�λ�ú���룻
		Nodee p=first;
		for(int j=0;j<i;j++) {
			p=p.getNext();
		}
		//�½���Ҫ����Ľڵ㣻
		Nodee newNodee=new Nodee(e);
		
		//˫��������4����������newNodee��ǰ����ǰ�ڵ㣩�ͺ�̣���ڵ㣩�������ú�ڵ��ǰ������㶨ǰ�ڵ�ĺ�̣�
		//1.��P��ֵ��newNodee��ǰ����2.��p.next��ֵ��newNodee�ĺ�̣�
		//3.��newNodee��ֵ��p.next��ǰ����4.��newNodee��ֵ��p�ĺ�̣�
		
		if(p.getNext()==null) {//�ӿ�����ʼ���룻����Ϊͷ�ڵ�Ϊfirst�ĺ��Ϊnull��
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
		//Ԫ�ظ������ӣ�
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
			throw new MyLineTableException("��������Խ���쳣��"+i);
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
		//��p�ĺ�̸�ֵ��p��ǰ���ĺ�̣���p��ǰ����ֵ��p�ĺ�̵�ǰ����
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
