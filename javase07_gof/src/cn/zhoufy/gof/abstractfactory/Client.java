package cn.zhoufy.gof.abstractfactory;
/**
 * 1.���󹤳�ģʽ�������Ӳ�Ʒ�������в�Ʒ��ĸ��
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
