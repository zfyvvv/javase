package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.ReentrantLock;��ƽ����
 * OS�ײ��Ǿ������ƣ��ǲ���ƽ�ģ�Ϊ�˿���Ч�ʣ��ö���߳�ͬʱ������
 * 
 * 2.��ƽ�����������ã�����CPUҪ����ʱ�������Բ��������Ǻܸߣ�һ��С��10��
 * ��ƽ������֤���ǵȴ�ʱ���Ĺ�ƽ�ԣ�
 * Synchronised��û�й�ƽ�Եģ�ReentrantLock���й�ƽ�ԣ�
 * 3.���쳣����finally��
 * 4.��������������Ӧ��ͬ�����������Ч�ʱ�synchronized�ߣ��������᣻
 * synchronized��JDK1.5�Ժ����Ż����ھ���Ч�ʣ�����ReentrantLock�Ͷ��٣�
 * 5.ʹ��������ʱ�������������ֹ��ͷ�����ǣ�һ����finally������ж����ͷ�����ǵ�unlock������
 * �������ԣ���synchronized�Ŀ���������һ���ģ�
 * 
 * 
 * 
 * 
 * @author DELL
 *
 */
public class MuThread04 {
	
	public static void main(String[] args) {
		//���Թ�ƽ�Ľ���ִ�У�
		//TestReentrantLock t=new TestReentrantLock();
		//����ִ�У�
		TestSynchronised t=new TestSynchronised();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
	}

}

//����һ��ReentrantLock��
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


