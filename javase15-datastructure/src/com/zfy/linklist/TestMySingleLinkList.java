package com.zfy.linklist;

import com.zfy.arraylist.MyList;

public class TestMySingleLinkList {

	public static void main(String[] args) {
		MyList list=new MySingleLinkList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		
		list.add(3, "zzz");
		System.out.println(list.size());
		System.out.println(list.get(1));
		System.out.println(list.toString());
		
		
		
	}

}
