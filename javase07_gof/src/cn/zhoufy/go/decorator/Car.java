package cn.zhoufy.go.decorator;
/**
 * 1.MyCar和SuperCar有共同的接口；
 * 2.SuperCar中调用Car的一个对象，实现接口方法中，调用Car的接口方法，
 * 3.SuperCar具体的实现类中，重写接口方法，并添加新的自己特用的方法，从而实现装饰！
 * @author DELL
 *
 */
public interface Car {//component 抽象构件，
	void move();
}

class MyCar implements Car{//concretecomponent 具体构建角色！
	@Override
	public void move() {
		System.out.println("putongcar");
	}
}

class SuperCar implements Car{//decorator  装饰角色；
	protected Car car;
	public SuperCar(Car car) {
		super();
		this.car = car;
	}
	@Override
	public void move() {
		car.move();
	}
}
class FlyCar extends SuperCar{//concretedecorator  具体装饰角色；！
	public FlyCar(Car car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
	void fly() {
		System.out.println("flycar!");
	}
}
class WaterCar extends SuperCar{
	public WaterCar(Car car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		water();
	}
	void water() {
		System.out.println("watercar!");
	}
}
class AutoCar extends SuperCar{
	public AutoCar(Car car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		auto();
	}
	void auto() {
		System.out.println("autocar!");
	}
}
