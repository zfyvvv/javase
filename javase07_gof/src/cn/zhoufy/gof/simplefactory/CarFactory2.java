package cn.zhoufy.gof.simplefactory;



/**
 * 1.�򵥹����ࣺ��̬������
 * @author DELL
 *
 */
public class CarFactory2 {
	public static Car creatAudi() {
			return new Audi();
	}
	public static Car creatBiyadi() {
		return new Biyadi();
}
}
