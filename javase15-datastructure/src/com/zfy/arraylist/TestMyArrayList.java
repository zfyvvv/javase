package com.zfy.arraylist;

public class TestMyArrayList {

	public static void main(String[] args) {
		MyList list=new MyArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("ddd");
		
		list.add(3, "zzz");
		System.out.println(list.size());
		System.out.println(list.get(1));
		//System.out.println(list.get(-8));
		System.out.println(list.toString());
	}

}
