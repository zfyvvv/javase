package cn.zhoufy.gof.simplefactory;



/**
 * 1.�򵥹���ģʽ���޷���չ��ʹ�ý϶࣡
 * @author DELL
 *
 */
public class CarFactory {
	public static Car creatCar(String type) {
		if(type.equals("Audi")) {
			return new Audi();
		}else if(type.equals("Biyadi")) {
			return new Biyadi();
		}else {
			return null;//������չ��
		}
	}

}
