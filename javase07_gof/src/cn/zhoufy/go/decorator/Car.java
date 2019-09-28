package cn.zhoufy.go.decorator;
/**
 * 1.MyCar��SuperCar�й�ͬ�Ľӿڣ�
 * 2.SuperCar�е���Car��һ������ʵ�ֽӿڷ����У�����Car�Ľӿڷ�����
 * 3.SuperCar�����ʵ�����У���д�ӿڷ�����������µ��Լ����õķ������Ӷ�ʵ��װ�Σ�
 * @author DELL
 *
 */
public interface Car {//component ���󹹼���
	void move();
}

class MyCar implements Car{//concretecomponent ���幹����ɫ��
	@Override
	public void move() {
		System.out.println("putongcar");
	}
}

class SuperCar implements Car{//decorator  װ�ν�ɫ��
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
class FlyCar extends SuperCar{//concretedecorator  ����װ�ν�ɫ����
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
