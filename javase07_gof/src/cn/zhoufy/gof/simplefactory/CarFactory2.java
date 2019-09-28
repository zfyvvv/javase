package cn.zhoufy.gof.simplefactory;



/**
 * 1.简单工厂类：静态工厂类
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
