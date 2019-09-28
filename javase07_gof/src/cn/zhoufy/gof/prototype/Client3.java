package cn.zhoufy.gof.prototype;
/**
 * 1.���¡������Ҳ���ſ�¡����¡ʱBinthdayҲ��һ���¶��󣡶�����Ե�clone()������
 * 2.����ָ��Ĳ�ͬDate���󣬵�s1���ĺ�s2�����ģ�
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
