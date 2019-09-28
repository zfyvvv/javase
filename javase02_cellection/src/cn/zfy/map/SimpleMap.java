package cn.zfy.map;

import java.util.LinkedList;
import java.util.List;

public class SimpleMap {
	//定义一个链表数组；
	LinkedList[] arr=new LinkedList[999];
	
	//定义map的长度属性；
	private int size;
	//对外提供获取长度的方法；
	public int getSize() {
		return size;
	}
	
	//增；
	public void add(Object key,Object value) {
		//对象，需要存到链表节点里面的对象；
		SimpleEntry e=new SimpleEntry(key,value);
		//获取hashcode，即链表数组的下标；
		int index=key.hashCode()%999;
		//先判断该下标的链表是否存在；
		  //若不存在，则该下标的链表的第一个元素就该对象；相当于数组中添加一个SimpleEntry对象；
		  //若存在直接在链表后续加上该对象；并且需要判断key的值是否重复；
		    //若没有重复，则链表后添加SimpleEntry对象；
		    //若重复，则覆盖原来的value值；
		if(arr[index]==null) {
			//LinkedList的方法，JDK已经实现；
			LinkedList list=new LinkedList<>();
			arr[index]=list;
			list.add(e);
			size++;
		}else {
			LinkedList list=arr[index];
			//确认是否有相同的key;
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					e2.setValue(value);
					return;
				}
			}
			//没有相同的key，则直接在索引链表后面添加SimpleEntry对象
			arr[index].add(e);
			size++;
		}
	}
	//查
	//通过key的hashcode查询到链表数组arr[];然后遍历arr[]数组，通过key的equals()方法找到value；
	public Object get(Object key) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					return list.get(i);
				}
			}
		}
		//遍历完了，没有找到返回null|arr[index]=null则均返回null；
		return null;
	}
	
	//删；
	//先找到，后删除；
	public void remove(Object key) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					list.remove(i);
					size--;
				}
			}
		}
		
	}
	
	//改
	//先找到，后更改；
	public void set(Object key,Object value) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					e2.setValue(value);
				}
			}
		}
		
	}
	
	
	

}

//定义entry实体对象；封装key和value；
class SimpleEntry{
	private Object key;
	private Object value;
	public SimpleEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
