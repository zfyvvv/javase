package com.zfy.xml;
/**
 * 1、灵魂反射；
 * @author DELL
 *
 */
public class RelfTest1 {
	public static void main(String[] args) throws Exception {
		
		//类的Class对象只有一个
		Class clazz=Class.forName("com.zfy.xml.Person");
		System.out.println(clazz);
		Class clazz2=Class.forName("com.zfy.xml.Person");
		System.out.println(clazz2);
		//ture
		System.out.println(clazz==clazz2);
		
		//类的对象可以有多个，
		Person p=(Person) clazz.newInstance();
		Person p2=(Person) clazz.newInstance();
		System.out.println(p);
		System.out.println(p2);
		//false
		System.out.println(p==p2);
		
		//灵魂反射
		p.setName("zfy");
		p.setAge(20);
		System.out.println(p.getName()+"-->"+p.getAge());
	}
}
