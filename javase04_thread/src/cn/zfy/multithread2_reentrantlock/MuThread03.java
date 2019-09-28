package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.ReentrantLock;
 * 可打断；ReentrantLock的功能之一；
 * 阻塞状态：普通阻塞，等待队列，锁池状态；
 * 普通阻塞：sleep(1000);可以被打断，通过调用thread.interrupt()，可以被打断阻塞状态，抛出异常；
 * 等待队列：wait()方法被调用，也是一种阻塞状态，只能由notify唤醒；无法打断；
 * 锁池队列：无法获取锁标记；不是所有的锁池队列都可以被打断；
 * 
 * 2.使用ReentrantLock的lock方法，获取锁标记时，如果需要阻塞等待锁标记，无法被打断；
 * 使用ReentrantLock的lockInterruptibly()方法，获取锁标记时，如果需要阻塞等待，可以被打断；
 * 3.可打断的方法，都会抛出InterruptedException异常；
 * 4.synchronized拿不到锁对象时，也打断不了；底层机制不一样；
 * 
 * 
 * @author DELL
 *
 */
public class MuThread03 {
	Lock lock=new ReentrantLock();
	void m1() {
		try {
			lock.lock();
			for(int i=0;i<5;i++) {
				System.out.println("m1-->"+i);
				TimeUnit.SECONDS.sleep(1);
			 }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
				lock.unlock();
		}
	}
	
	void m2() {
		try {
			//可尝试打断锁，阻塞等待锁。可以被其他的线程打断阻塞状态；
			//只能打断阻塞状态的锁，不能打断执行状态的线程；
			lock.lockInterruptibly();
			//此时无法被打断；
			//lock.lock();
			System.out.println("m2....");
			
		} catch (Exception e) {
			System.out.println("m2....Interruptibly--->Exception!");
		}finally {
			try {
			lock.unlock();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MuThread03 mt=new MuThread03();
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mt.m1();
			}
		});
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mt.m2();
			}
		});
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//打断线程休眠；非正常结束阻塞状态的线程，会抛出异常；
		t2.interrupt();
		
	}

}
