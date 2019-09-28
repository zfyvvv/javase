package cn.zhoufy.g.iterator;

import java.util.ArrayList;

public class Client {
	public static void main(String[] args) {
		MyConcreteAggregate mca=new MyConcreteAggregate(new ArrayList<Object>());
		mca.addObject("aaa");
		mca.addObject("bbb");
		mca.addObject("ccc");
		MyIterator miter=mca.getConcreteIterator();
		while(miter.hasNext()) {
			System.out.println(miter.getCurrentObject());
			miter.next();
		}
		
		
		
		
		
	}

}
