package com.zfy.linetable;

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
		//如果数组满了，
		if(size==elementData.length) {
			//就新建一个扩容的数组；
			Object[] newArray=new Object[elementData.length*2];
			//原数组的值拷贝;
			for(int i=0;i<size;i++) {
				newArray[i]=elementData[i];
			}
			//让elementData指向新数组；
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
			throw new MyLineTableException("数组索引越界异常:"+i);
		}
		return elementData[i];
	}

	@Override
	public boolean replace(int i, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

}
