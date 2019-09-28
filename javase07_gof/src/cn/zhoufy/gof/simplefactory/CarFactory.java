package cn.zhoufy.gof.simplefactory;



/**
 * 1.简单工厂模式：无法扩展！使用较多！
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
			return null;//不好扩展！
		}
	}

}
