package cn.zhoufy.go.staticproxy;

public class Client {
	public static void main(String[] args) {
		RealStar realStar=new RealStar();
		Star proxy=new StaticProxy(realStar);//构造器中需要制定对象！
		proxy.confer();
		proxy.bookTicket();
		proxy.sing();
		proxy.bookHotel();
		
	}

}
