package cn.zhoufy.gof.abstractfactory;

public interface Tire {
	void run();
}
class LowTire implements Tire{

	@Override
	public void run() {
		System.out.println("lowtire!");
	}
}

class LuxTire implements Tire{
	@Override
	public void run() {
		System.out.println("luxtire!");
	}
}
