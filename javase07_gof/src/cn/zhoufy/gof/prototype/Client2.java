package cn.zhoufy.gof.prototype;
/**
 * 1.ǳ��¡
 *  2.����ָ���ͬһ��Date���󣬵�s1���ĺ�s2Ҳ���ģ��ʽ��һ�£�
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
