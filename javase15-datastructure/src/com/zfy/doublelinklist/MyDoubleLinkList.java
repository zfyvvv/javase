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
		//��i=0ʱ����ʱ��ָ��P����ָ��first���൱�ڶ�����ӣ�
		//��i=sizeʱ����ʱ��ָ��P����ָ��last���൱�ڶ�β��ӣ�
		//��0<i<sizeʱ����ʱ��ָ��P����ָ���±�Ϊn�Ľڵ㣻�൱�ڶ�����ӣ�
		
		
		//�½���Ҫ����Ľڵ㣻
		Nodee newNodee=new Nodee(e);
		
		newNodee.setPre(p);
		newNodee.setNext(p.getNext());
		
		p.setNext(newNodee);
		p.getNext().setPre(newNodee);
		
		/*if(first==null) {//��i=0ʱ�������λ���ǵ�һ����
			//�½ڵ��next���Ӻ�һ��ǰ�ڵ�last��
			newNodee.setNext(null);
			//����ǰһ���ڵ㣻
			newNodee.setPre(null);
			first=newNodee;
			last=newNodee;
			
		}else if(p.getNext()==null){//��i=sizeʱ�������λ�������һ����
			//�޸ĵ�ǰ�ڵ��ǰ��ڵ㣻
			//�½ڵ��next���Ӻ�һ��ǰ�ڵ㣻
			newNodee.setPre(p);
			newNodee.setNext(null);
			//����ǰһ���ڵ㣻
			last.setNext(newNodee);
			last=newNodee;
			
		}else{//���м���룻
			newNodee.setPre(p);
			newNodee.setNext(p.getNext());
			
			p.setNext(newNodee);
			p.getNext().setPre(newNodee);
		}*/
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
