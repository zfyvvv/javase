package cn.zfy.a;
/**
 * 1、类的加载全过程详解：加载，链接（验证、准备、解析），初始化，静态初始化块等；
 * 2、类的三种主动引用方式；
 * 3、类的三种被动引用方式；
 * @author DELL
 *
 */
public class Dome1 {
	static {System.out.println("静态初始化Dome1类！！");}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("加载Dome1的main方法！！");
		//主动引用的三种方式：
		//A a=new A();
		//System.out.println(a.width);
		//Class.forName("cn.zhouyfy.classloader.a.A");
		//System.out.println("@@@@@@@@@@@@@@@");
		//A a2=new A();//类只需加载一次，就可以多次调用；
		//System.out.println(a2.width);
		//被动引用
		//System.out.println(A.MAX);
		//A[] as=new A[10];
		
	}
}

class A extends A_Father{
	public static int width=100;//静态变量，静态域，静态属性，field；
	public static final int MAX=200;
	static {
		System.out.println("静态初始化类A！！");
		width=500;
	}
	public A(){
		System.out.println("创建A类的对象！！");
	}
}
class A_Father{
	static {
		System.out.println("静态初始化A_Father类！！");
	}
}
