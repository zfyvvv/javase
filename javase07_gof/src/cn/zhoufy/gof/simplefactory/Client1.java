package cn.zhoufy.gof.simplefactory;



/**
 * 1.�޹���ģʽ����Ҫͬ�����෢����ϵ��
 * @author DELL
 *
 */

public class Client1 {
	public static void main(String[] args) {
		Car c=new Audi();
		Car c2=new Biyadi();
		c.run();
		c2.run();
	}

}
