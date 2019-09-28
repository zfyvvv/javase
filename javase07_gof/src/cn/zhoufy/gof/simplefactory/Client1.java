package cn.zhoufy.gof.simplefactory;



/**
 * 1.无工厂模式，需要同三个类发生联系！
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
