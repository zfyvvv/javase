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
		System.out.println("-------------");//ÿһ�δ��������������ķ�����������������п��ƣ�
		//System.out.println("bookTicket!");
		method.invoke(realStar, args);
		return null;
	}

}
