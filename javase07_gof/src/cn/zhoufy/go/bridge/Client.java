package cn.zhoufy.go.bridge;

public class Client {
	public static void main(String[] args) {
		//销售小米牌平板
		Computer cp=new Laptop(new Mi());
		cp.sale();
		//销售戴尔牌组桌面电脑，
		Computer cp1=new Desklop(new Dell());
		cp1.sale();
		
	}

}
