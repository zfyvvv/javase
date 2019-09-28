package cn.zhoufy.gof.prototype;
/**
 * 1.浅克隆
 *  2.属性指向的同一个Date对象，当s1更改后，s2也更改！故结果一致！
 */
import java.util.Date;

public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d=new Date(123123123L);
		Sheep1 s1=new Sheep1("zfy",d);
		Sheep1 s2=(Sheep1) s1.clone();
		d.setTime(123123123123L);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
	
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	}

}
