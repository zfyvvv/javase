package cn.zhoufy.gof.factorymethod;

public class BiyadiFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Biyadi();
	}
	

}
