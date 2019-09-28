package cn.zhoufy.go.decorator;

public class Client {
	public static void main(String[] args) {
	MyCar mc=new MyCar();
	mc.move();
	System.out.println("---------1-----");
	FlyCar fmc=new FlyCar(mc);
	fmc.move();
	System.out.println("-----2---------");
	AutoCar awmc=new AutoCar(new WaterCar(mc));//Ò»²ãÒ»²ã×°ÊÎ£¬
	awmc.move();
	
	
}
}
