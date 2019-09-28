package cn.zhoufy.gof.prototype;
/**
 * 1.ʵ��Cloneable�ӿ�+��дclone()������
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
		s2.setName("lt");//�����Լ�����s2�����ԣ�
		System.out.println(s2.getName());
		
		
	}

}
