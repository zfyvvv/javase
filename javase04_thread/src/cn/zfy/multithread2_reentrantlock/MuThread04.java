package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.ReentrantLock;公平锁；
 * OS底层是竞争机制；是不公平的；为了考虑效率，让多个线程同时竞争；
 * 
 * 2.公平锁尽可能少用；由于CPU要计算时长，所以并发量不是很高，一般小于10；
 * 公平锁，保证就是等待时长的公平性；
 * Synchronised是没有公平性的，ReentrantLock是有公平性；
 * 3.有异常，有finally；
 * 4.可重入锁，建议应用同步方法，相对效率比synchronized高；量级较轻；
 * synchronized在JDK1.5以后，有优化；在绝对效率，不比ReentrantLock低多少；
 * 5.使用重入锁时，必须必须必须手工释放锁标记；一般在finally代码块中定义释放锁标记的unlock方法；
 * 可重入性，和synchronized的可重入性是一样的；
 * 
 * 
 * 
 * 
 * @author DELL
 *
 */
public class MuThread04 {
	
	public static void main(String[] args) {
		//可以公平的交替执行；
		//TestReentrantLock t=new TestReentrantLock();
		//穿插执行；
		TestSynchronised t=new TestSynchronised();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
	}

}

//定义一个ReentrantLock；
class TestReentrantLock extends Thread{
	private static ReentrantLock lock=new ReentrantLock(true);
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			lock.lock();
			try {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			}finally {
				lock.unlock();
			}
		}
	}
}

class TestSynchronised extends Thread{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+"-->"+i);
			}
		}
	}
	
}


