package cn.zhoufy.gof.abstractfactory;

public interface Engine {
	void start();
}
class LowEngine implements Engine{

	@Override
	public void start() {
		System.out.println("lowengine!");
	}
}

class LuxEngine implements Engine{

	@Override
	public void start() {
		System.out.println("luxengine!");
	}
}
