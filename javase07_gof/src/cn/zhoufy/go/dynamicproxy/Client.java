package cn.zhoufy.go.dynamicproxy;

import java.lang.reflect.Proxy;
/**
 * 1.JDK自己提供的动态代理，可以进行控制！
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		RealStar realStar=new RealStar();
		StarHandler starHandler=new StarHandler(realStar);
		Star proxy=(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), 
				new Class[] {Star.class}, starHandler);
		proxy.confer();
		proxy.bookTicket();
		proxy.sing();
		proxy.bookHotel();
	}

}
