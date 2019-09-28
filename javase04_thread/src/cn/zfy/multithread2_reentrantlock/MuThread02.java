package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ReentrantLock;
 * 尝试锁；ReentrantLock的功能之一；
 * @author DELL
 *
 */
public class MuThread02 {
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
		boolean isLock=false;
		try {
			//尝试锁，如果有锁，无法获取锁标记，返回false；
			//如果获取锁标记，返回true；
			//isLock=lock.tryLock();
			
			//阻塞尝试锁，阻塞参数代表时长，尝试获取锁标记，
			//如果超时，不等待，直接返回结果；
			//当方法1为10时，也获取不到；当方法1为3时，可以获取到；
			isLock=lock.tryLock(5, TimeUnit.SECONDS);
			if(isLock) {
				System.out.println("m()2 is synchronized");
			}else {
				System.out.println("m()2 is notsynchronized");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//尝试锁在解除锁标记时，一定要判断是否获取锁标记；
			//如果当前线程没有获取锁标记，会抛出异常；
			if(isLock) {
				lock.unlock();
			}
		}
		
	}
	
	public static void main(String[] args) {
		MuThread02 mt=new MuThread02();
		
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
