package cn.zhoufy.g.mediator;
/**
 * 1.��������ͨ��Mediator����ͨ��
 * 2. Developement-->d.outAction()-->map.get(dname).outAction()-->Map()-->Finacial.outAction()!
 *   
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		Mediator m=new President();
		Developement d=new Developement(m);
		Finacial f=new Finacial(m);
		
		d.selfAction();
		d.outAction();
	}

}
