package cn.zhoufy.go.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{
	Star realStar;
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-------------");//每一次代理，都会调用这里的方法，可以在这里进行控制！
		//System.out.println("bookTicket!");
		method.invoke(realStar, args);
		return null;
	}

}
