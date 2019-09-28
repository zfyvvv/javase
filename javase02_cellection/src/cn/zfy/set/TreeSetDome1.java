package cn.zfy.set;

import java.util.TreeSet;

public class TreeSetDome1 {
	public static void main(String[] args) {
		TreeSet<Person> ts=new TreeSet<Person>();
		ts.add(new Person("�ܷ���",1000));
		ts.add(new Person("�ܷ�",800));
		ts.add(new Person("����",900));
		System.out.println(ts);
		System.out.println("################################");
		TreeSet<Student> ts2=new TreeSet<Student>(//�����ڲ��࣬�ŵ����õķ������棻
				new java.util.Comparator<Student>() {//������ʹ��ʵ�ֵĽӿ����֣�
					@Override
					public int compare(Student o1, Student o2) {
						return o1.getScore()-o2.getScore();
					}
				}
				);
		ts2.add(new Student("�ܷ���",100));
		ts2.add(new Student("�ܷ�",80));
		ts2.add(new Student("����",90));
		System.out.println(ts2);
		
	}
}
