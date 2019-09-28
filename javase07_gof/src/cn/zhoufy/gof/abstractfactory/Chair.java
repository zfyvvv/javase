package cn.zhoufy.gof.abstractfactory;

public interface Chair {
	void set();
}
class LowChair implements Chair{

	@Override
	public void set() {
		System.out.println("lowchair!");
	}
}
class LuxChair implements Chair{

	@Override
	public void set() {
		System.out.println("luxchair!");
	}
	
}
