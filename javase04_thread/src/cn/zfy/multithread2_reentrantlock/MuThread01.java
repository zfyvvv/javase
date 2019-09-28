package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ReentrantLock;
 * 可重入锁；
 * 部分代替synchronized功能；
 * 2.高并发是netty ,NIO,AIO的学习基础；
 * @author DELL
 *
 */
public class MuThread01 {
	Lock lock=new ReentrantLock();
	
	void m1() {
		try {
			lock.lock();
			for(int i=0;i<10;i++) {
				System.out.println("m1-->"+i);
				TimeUnit.SECONDS.sleep(1);
			 }
		} catch (InterruptedException e) {
		}finally {
				lock.unlock();
			}
	}
	void m2() {
		lock.lock();
		System.out.println("m2()-->start!");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		MuThread01 mt=new MuThread01();
		
		//当m1方法彻底运行完之后，m2才开始运行；
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mt.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mt.m2();
			}
		}).start();
	}
}
