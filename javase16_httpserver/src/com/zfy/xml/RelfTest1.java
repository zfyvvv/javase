package com.zfy.xml;
/**
 * 1����귴�䣻
 * @author DELL
 *
 */
public class RelfTest1 {
	public static void main(String[] args) throws Exception {
		
		//���Class����ֻ��һ��
		Class clazz=Class.forName("com.zfy.xml.Person");
		System.out.println(clazz);
		Class clazz2=Class.forName("com.zfy.xml.Person");
		System.out.println(clazz2);
		//ture
		System.out.println(clazz==clazz2);
		
		//��Ķ�������ж����
		Person p=(Person) clazz.newInstance();
		Person p2=(Person) clazz.newInstance();
		System.out.println(p);
		System.out.println(p2);
		//false
		System.out.println(p==p2);
		
		//��귴��
		p.setName("zfy");
		p.setAge(20);
		System.out.println(p.getName()+"-->"+p.getAge());
	}
}
