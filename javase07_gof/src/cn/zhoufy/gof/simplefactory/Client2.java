package cn.zhoufy.gof.simplefactory;
/**
 * 1.简单工厂模式，只和一个类发生联系；
 * 2.已经明确的类，可以直接加；未明确的类，需要修改已有的类！
 * 3.使用最多！
 * @author DELL
 *
 */
public class Client2 {
	public static void main(String[] args) {
		Car c=CarFactory.creatCar("Audi");
		Car c2=CarFactory.creatCar("Biyadi");
		c.run();
		c2.run();
	}

}
