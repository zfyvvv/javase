package cn.zfy.set;

import java.util.TreeSet;

public class TreeSetDome1 {
	public static void main(String[] args) {
		TreeSet<Person> ts=new TreeSet<Person>();
		ts.add(new Person("周方杨",1000));
		ts.add(new Person("周方",800));
		ts.add(new Person("周杨",900));
		System.out.println(ts);
		System.out.println("################################");
		TreeSet<Student> ts2=new TreeSet<Student>(//匿名内部类，放到调用的方法里面；
				new java.util.Comparator<Student>() {//类名称使用实现的接口名字；
					@Override
					public int compare(Student o1, Student o2) {
						return o1.getScore()-o2.getScore();
					}
				}
				);
		ts2.add(new Student("周方杨",100));
		ts2.add(new Student("周方",80));
		ts2.add(new Student("周杨",90));
		System.out.println(ts2);
		
	}
}
