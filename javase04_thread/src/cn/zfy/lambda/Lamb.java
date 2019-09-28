package cn.zfy.lambda;

/**
 * 1.lambda表达式：简化线程的使用，前提是该线程使用一次或很少的次数；
 * 外部类->静态内部类类->局部内部类->匿名内部类->lambda表达式
 * 	jdk8的新特性；用于简化简单的线程类；
 * @author DELL
 *
 */
public class Lamb {
	
	public static class LambdaIn implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				if(0==i%2) {
					System.out.println("static in,i为偶数！");
				}else {
					System.out.println("static in,i为奇数！");
				}
			}
		}
	}

	public static void main(String[] args) {
		//局部内部类；
		class LambdaFun implements Runnable{
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("fun,i为偶数！");
					}else {
						System.out.println("fun,i为奇数！");
					}
				}
			}
		}
		
		//调用外部类；
		//new Thread(new LambdaOut()).start();
		//静态内部类；优点；不使用不会编译；
		//new Thread(new LambdaIn()).start();
		//局部内部类，在方法里面，此时没有静态的概念，方法都是局部的；
		//new Thread(new LambdaFun()).start();
		//匿名内部内；当变量名字只使用一次时，可以使用父类和接口；后接花括号，接类体；
		//接口不可以new，所以后面接代码；
		//连类的名字都可以省略；
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("niming,i为偶数！");
					}else {
						System.out.println("niming,i为奇数！");
					}
				}
			}
		}).start();
		
		//lambda表达式，jdk8对其进行简化；
		//只关注线程体；连接口都可以去掉；
		new Thread(()->{
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("lamb,i为偶数！");
					}else {
						System.out.println("lamb,i为奇数！");
					}
				}
			}
		).start();
		
		
		
		
		
	}
}

//外部类；
class LambdaOut implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			if(0==i%2) {
				System.out.println("out,i为偶数！");
			}else {
				System.out.println("out,i为奇数！");
			}
		}
	}
}
