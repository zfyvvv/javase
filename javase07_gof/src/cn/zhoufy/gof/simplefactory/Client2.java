package cn.zhoufy.gof.simplefactory;
/**
 * 1.�򵥹���ģʽ��ֻ��һ���෢����ϵ��
 * 2.�Ѿ���ȷ���࣬����ֱ�Ӽӣ�δ��ȷ���࣬��Ҫ�޸����е��࣡
 * 3.ʹ����࣡
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
