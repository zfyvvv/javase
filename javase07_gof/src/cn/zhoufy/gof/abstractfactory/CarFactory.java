package cn.zhoufy.gof.abstractfactory;

public interface CarFactory {
	Engine creatEngine();
	Chair creatChair();
	Tire creatTire();
}
class LowCarFactory implements CarFactory{
	@Override
	public Engine creatEngine() {
		return new LowEngine();
	}
	@Override
	public Chair creatChair() {
		return new LowChair();
	}
	@Override
	public Tire creatTire() {
		return new LowTire();
	}
}
class LuxCarFactory implements CarFactory{
	@Override
	public Engine creatEngine() {
		return new LuxEngine();
	}
	@Override
	public Chair creatChair() {
		return new LuxChair();
	}
	@Override
	public Tire creatTire() {
		return new LuxTire();
	}
}


