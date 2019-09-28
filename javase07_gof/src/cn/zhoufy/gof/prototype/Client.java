package cn.zhoufy.gof.prototype;
/**
 * 1.实现Cloneable接口+重写clone()方法；
 */
import java.util.Date;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d=new Date(123123123L);
		Sheep1 s1=new Sheep1("zfy",d);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		Sheep1 s2=(Sheep1) s1.clone();
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		s2.setName("lt");//可以自己设置s2的属性，
		System.out.println(s2.getName());
		
		
	}

}
