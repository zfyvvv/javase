package cn.zhoufy.go.facade;

public class Facade {
	void facadeWork() {
		Bank b=new Bank();
		Factory f=new Factory();
		Human h=new Human();
		b.openBank();
		f.openFactory();
		h.openHuan();
	}

}
