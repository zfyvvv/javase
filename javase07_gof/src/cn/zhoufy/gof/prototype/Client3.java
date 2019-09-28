package cn.zhoufy.gof.prototype;
/**
 * 1.深克隆：属性也跟着克隆！克隆时Binthday也是一个新对象！多加属性的clone()方法！
 * 2.属性指向的不同Date对象，当s1更改后，s2不更改！
 * 3.
 */
import java.util.Date;

public class Client3 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d=new Date(123123123L);
		Sheep2 s1=new Sheep2("zfy",d);
		Sheep2 s2=(Sheep2) s1.clone();
		d.setTime(123123123123L);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
	
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	}

}
