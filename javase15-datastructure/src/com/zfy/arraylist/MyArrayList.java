package com.zfy.arraylist;

import java.util.Arrays;

import com.zfy.exception.MyLineTableException;
/**
 * 1.模拟java.util.ArrayList,容量增长一倍；
 * 2.增加是比较难的，其他的可以通过移动进行实现；
 * 3.核心是数组的扩容和数组元素的移动；
 * @author DELL
 *
 */

public class MyArrayList implements MyList{
	//
	private Object[] elementData;
	//数组中元素的个数,不是数组的大小；
	private int size;
	
	public MyArrayList() {
		this(4);
		//java中默认的长度为零；
		//elementDate=new Object[] {};
		
	}
	public MyArrayList(int initialCapacity) {
		//指定数组初始化大小；
		elementData=new Object[initialCapacity];
		//size默认也是0；
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
		/*//如果数组满了，
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
			throw new MyLineTableException("数组索引越界异常："+i);
		}
		if(size==elementData.length) {
			grow();
		}
		//从最后一个开始，后移i及后面的元素；
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
			throw new MyLineTableException("数组索引越界异常:"+i);
		}
		return elementData[i];
	}

	@Override
	public boolean replace(int i, Object e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 数组扩容；
	 */
	private void grow() {
		/*//就新建一个扩容的数组；
		Object[] newArray=new Object[elementData.length*2];
		//原数组的值拷贝;
		for(int i=0;i<size;i++) {
			newArray[i]=elementData[i];
		}
		//让elementData指向新数组；
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
