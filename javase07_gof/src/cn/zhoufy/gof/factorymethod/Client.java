package cn.zhoufy.gof.factorymethod;
/**
 * 1.��������ģʽ��������չ������Ҫ�޸����е��ֻࣻ�͹�����ϵ�����;����Car�෢����ϵ����
 * 2.�½�XXclass��ʵ��Car�ӿڣ�-->��XXFactory�ࣨʵ��CarFactory�ӿڣ�-->ֱ�ӵ���:Car c=new AudiFactory().creatCar();
 * 3.��࣡
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
