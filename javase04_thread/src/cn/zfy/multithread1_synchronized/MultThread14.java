package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字;
 * 常量问题；
 * 在定义同步代码块时，不要使用常量对象作为锁目标对象；
 * 你以为是多个引用，其实是同一个对象；
 * 
 * 2.常量池问题包括字符串，数字等；
 * new一定会开辟堆内存，新建对象；
 * 
 * @author DELL
 *
 */
public class MultThread14 {
	private String s1="hello";
	private String s2="hello";
	//new关键字，一定是在堆中创建一个新的对象；
	private String s3=new String("hello");
	
	//此时锁定i1和i2，是可以运行的，不是同一个对象；
	Integer i1=new Integer(1);
	Integer i2=new Integer(1);
	//此时锁定i3和i4，是m2阻塞的，是同一个对象；-128~127；
	Integer i3=1;
	Integer i4=	1;	

	void m1() {
		synchronized (s1) {
			System.out.println("m1...");
			while(true) {
			}
		}
	}
	void m2() {
		synchronized (s2) {
			System.out.println("m2...");
			while(true) {
			}
		}
	}
	void m3() {
		synchronized (s3) {
			System.out.println("m3...");
			while(true) {
			}
		}
	}
	
	public static void main(String[] args) {
		MultThread14 mt14=new MultThread14();
		
		//m1和m3可以正常运行；
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m2();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m3();
			}
		}).start();
	}
	
}


