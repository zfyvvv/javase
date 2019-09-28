package cn.zfy.test;

import java.util.Currency;
/**
 * 1、同步产生的原因；
 * 2、解决同步的方法：
 * @author DELL
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Person p1=new Person();
		Person p2=new Person();
		Person p3=new Person();
		
		Thread t1=new Thread(p1, "p1");
		Thread t2=new Thread(p1, "p2");
		Thread t3=new Thread(p1, "p3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

/**
 * 1、同步产生的原因；
 * @author DELL
 *
 */
/*class Person implements Runnable{
	private int num=10;
	@Override
	public void run() {
		
		while(true) {
			if(num<0) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"->"+num);
			num--;
		}
	}
}*/

/**
 * 2、同步的解决方式：
 * @author DELL
 *
 */
class Person implements Runnable{
	private int num=10;
	private boolean flag=true;
	
	@Override
	public void run() {
//		test();
//		test1();
		test2();
		
	}
	
	//增加延时，还是出现同步问题；
	public void test() {
		while(flag) {
			if(num<=0) {
				flag=!flag;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"->"+num--);
			num--;
		}
	}
	/**
	 * 1、使用synchronized锁方法，可以保障线程安全；
	 */
	public synchronized void test1() {
		while(flag) {
			if(num<=0) {
				flag=!flag;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"->"+num--);
		}
	}
	
	/**
	 * 1、使用synchronized锁块，可以保障线程安全；
	 */
	public synchronized void test2() {
		synchronized(this){
		while(flag) {
			if(num<=0) {
				flag=!flag;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"->"+num--);
		}
		}
	}
}
