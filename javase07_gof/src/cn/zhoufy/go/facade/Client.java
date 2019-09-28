package cn.zhoufy.go.facade;

public class Client {
	public static void main(String[] args) {
		/*Bank b=new Bank();
		Factory f=new Factory();
		Human h=new Human();
		b.openBank();
		f.openFactory();
		h.openHuan();*/
		Facade f=new Facade();
		f.facadeWork();
		
		
		
	}

}
