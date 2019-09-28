package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ReentrantLock;
 * ����������
 * ���ִ���synchronized���ܣ�
 * 2.�߲�����netty ,NIO,AIO��ѧϰ������
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
		
		//��m1��������������֮��m2�ſ�ʼ���У�
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
