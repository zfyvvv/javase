package cn.zfy.create;

/**\
 * 1-创建继承Thread类的对象，
 * 2-调用对象的start()方法，而不是run()方法；
 * 3、run()为重写，主要是执行体方法，而启动该run()方法的方法是父类的start()方法；
 * @author DELL
 *
 */

public class RTAPP {
	public static void main(String[] args) {
		Rabbit ra=new Rabbit();//新建兔子对象
		Tortoise to=new Tortoise();//新建乌龟对象
		
		ra.start();//兔子准备跑，但是什么时候跑靠CPU的调度；
		to.start();//乌龟准备跑，也靠CPU的调度；如果调用ra.run()方法，则只有一条路径；
		
		for(int i=0;i<=10;i++) {
			System.out.println("main方法："+i+"步");//mian方法也准备好了，等待CPU的调度；
		}
		
	}

}

/**
 * 1-继承Thread类，重写run()方法；
 *
 * @author DELL
 *
 */
class Rabbit extends Thread {
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("兔子："+i+"步");
		}
		super.run();
	}
}

class Tortoise extends Thread {
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("乌龟："+i+"步");
		}
		super.run();
	}
}


