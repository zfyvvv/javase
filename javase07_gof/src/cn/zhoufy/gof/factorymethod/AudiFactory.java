package cn.zhoufy.gof.factorymethod;

public class AudiFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Audi();
	}
	

}
