package com.zfy.doublelinklist;

import com.zfy.arraylist.MyList;

public class TestMyDoubleLinkList {

	public static void main(String[] args) {
		MyList list=new MyDoubleLinkList();
		list.add("aaa");
		list.add("bbb");
		/*list.add("ccc");
		list.add("ddd");
		list.add("eee");*/
		System.out.println(list.size());
		System.out.println(list.get(1));
		System.out.println(list.toString());
		
		
		
	}

}
