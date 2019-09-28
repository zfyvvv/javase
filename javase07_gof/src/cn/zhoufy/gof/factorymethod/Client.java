package cn.zhoufy.gof.factorymethod;
/**
 * 1.工厂方法模式，易于扩展，不需要修改已有的类；只和工厂联系，不和具体的Car类发生联系；！
 * 2.新建XXclass（实现Car接口）-->建XXFactory类（实现CarFactory接口）-->直接调用:Car c=new AudiFactory().creatCar();
 * 3.类多！
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		Car c=new AudiFactory().creatCar();
		Car c2=new BiyadiFactory().creatCar();
		c.run();
		c2.run();
		Car c3=new BenciFactory().creatCar();
		c3.run();
	}
}
