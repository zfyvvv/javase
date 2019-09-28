package cn.zhoufy.gof.factorymethod;

public class BenciFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Benci();
	}
	

}
