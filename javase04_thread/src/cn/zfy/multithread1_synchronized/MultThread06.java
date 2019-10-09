package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字
 *同步方法-调用其他同步方法；
 *锁可重入，同一个线程，多次调用同步代码，锁定同一个锁对象，可重入；
 *不是真正的锁，实际是一个标记；
 *多线程锁定同一个对象，不可重入；
 *
 * @author DELL
 *
 */
public class MultThread06 {
	
	public synchronized void m1() {
		System.out.println("m1 start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end!");
	}
	
	public synchronized  void m2() {
		System.out.println("m2 start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2 end!");
		
	}
	
	public static void main(String[] args) {
		MultThread06 mt6 = new MultThread06();
		mt6.m1();

	}
}
