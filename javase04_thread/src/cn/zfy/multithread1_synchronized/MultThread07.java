package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字
 *同步方法-继承；
 *子类同步方法覆盖父类同步方法，可以指定调用父类的同步方法；
 *相当于锁的重入；
 *
 * @author DELL
 *
 */
public class MultThread07 {
	
	synchronized void m() {
		System.out.println("super m start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("super m end!");
	}
	
	public static void main(String[] args) {
		Sub_MultThread07 mt7s = new Sub_MultThread07();
		mt7s.m();

	}
}

class Sub_MultThread07 extends MultThread07{
	synchronized void m() {
		System.out.println("sub m start!");
		super.m();
		System.out.println("sub m end!");
	}
}
