package com.zfy.arraylist;

public interface MyList {
	public int size();
	public boolean isEmpty();
	public boolean contains(Object e);
	
	public void add(Object e);
	public void add(int i,Object e);
	
	public void remove();
	public void remove(int i);
	public void remove(Object e);
	
	public Object get(int i);
	
	public boolean replace(int i ,Object e);
	
	
	
}
