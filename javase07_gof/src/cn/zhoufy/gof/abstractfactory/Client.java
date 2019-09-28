package cn.zhoufy.gof.abstractfactory;
/**
 * 1.抽象工厂模式，不增加产品，但是有产品族的概念！
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		CarFactory luxcf=new LowCarFactory();
		Chair luxcfc=luxcf.creatChair();
		 luxcfc.set();
		Engine luxcfe=luxcf.creatEngine();
		luxcfe.start();
		Tire luxcft=luxcf.creatTire();
		luxcft.run();
	}

}
