package com.zfy.linetable;

public class TestMyArrayList {

	public static void main(String[] args) {
		MyList list=new MyArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("ddd");
		
		System.out.println(list.size());
		System.out.println(list.get(1));
		//System.out.println(list.get(-8));
	}

}
