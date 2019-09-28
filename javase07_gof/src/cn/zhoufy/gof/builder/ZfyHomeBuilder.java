package cn.zhoufy.gof.builder;

public class ZfyHomeBuilder implements HomeBuilder{
	@Override
	public House buildeHouse() {//实现接口，提供具体 的模块；
		System.out.println("bbzfydhouse!");
		return new House("zfyh");
	}
	@Override
	public Car builderCar() {
		System.out.println("bbzfydcar!");
		return new Car("zfyc");
	}
	@Override
	public Money builderMoney() {
		System.out.println("bbzfydmoney!");
		return new Money("zfym");
	}
}
