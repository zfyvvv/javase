package com.zfy.arraylist;

import java.util.Arrays;

import com.zfy.exception.MyLineTableException;
/**
 * 1.ģ��java.util.ArrayList,��������һ����
 * 2.�����ǱȽ��ѵģ������Ŀ���ͨ���ƶ�����ʵ�֣�
 * 3.��������������ݺ�����Ԫ�ص��ƶ���
 * @author DELL
 *
 */

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
		this.add(size, e);
		/*//����������ˣ�
		if(size==elementData.length) {
			grow();
		}
		elementData[size]=e;
		size++;
		//elementDate[size++];*/
		
	}

	@Override
	public void add(int i, Object e) {
		if(i<0 || i>size) {
			throw new MyLineTableException("��������Խ���쳣��"+i);
		}
		if(size==elementData.length) {
			grow();
		}
		//�����һ����ʼ������i�������Ԫ�أ�
		for(int j=size;j>i;j--) {
			elementData[j]=elementData[j-1];
		}
		elementData[i]=e;
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
	
	/**
	 * �������ݣ�
	 */
	private void grow() {
		/*//���½�һ�����ݵ����飻
		Object[] newArray=new Object[elementData.length*2];
		//ԭ�����ֵ����;
		for(int i=0;i<size;i++) {
			newArray[i]=elementData[i];
		}
		//��elementDataָ�������飻
		elementData=newArray;*/
		elementData=Arrays.copyOf(elementData, elementData.length*2);
	}
	
	//[236,569,...]
	@Override
	public String toString() {
		if(size==0) {
			return "[]";
		}
		StringBuilder bulider=new StringBuilder("[");
		for(int i=0;i<size;i++) {
			if(i!=size-1) {
				bulider.append(elementData[i]).append(",");
			}else {
				bulider.append(elementData[i]);
			}
		}
		bulider.append("]");
		return bulider.toString();
	}
}
