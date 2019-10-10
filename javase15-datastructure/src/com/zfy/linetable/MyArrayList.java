package com.zfy.linetable;

public class MyArrayList implements MyList{
	
	//
	private Object[] elementData;
	//������Ԫ�صĸ���,��������Ĵ�С��
	private int size;
	
	public MyArrayList() {
		this(4);
		//java��Ĭ�ϵĳ���Ϊ�㣻
		//elementDate=new Object[] {};
		
	}
	public MyArrayList(int initialCapacity) {
		//ָ�������ʼ����С��
		elementData=new Object[initialCapacity];
		//sizeĬ��Ҳ��0��
		size=0;
	}
	
	
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object e) {
		return false;
	}

	@Override
	public void add(Object e) {
		//����������ˣ�
		if(size==elementData.length) {
			//���½�һ�����ݵ����飻
			Object[] newArray=new Object[elementData.length*2];
			//ԭ�����ֵ����;
			for(int i=0;i<size;i++) {
				newArray[i]=elementData[i];
			}
			//��elementDataָ�������飻
			elementData=newArray;
			
		}
		
		
		
		
		elementData[size]=e;
		size++;
		//elementDate[size++];
		
	}

	@Override
	public void add(int i, Object e) {
		// TODO Auto-generated method stub
		
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
		if(i<0 || i>=size) {
			throw new MyLineTableException("��������Խ���쳣:"+i);
		}
		return elementData[i];
	}

	@Override
	public boolean replace(int i, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

}
