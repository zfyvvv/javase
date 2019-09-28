package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.ReentrantLock;
 * �ɴ�ϣ�ReentrantLock�Ĺ���֮һ��
 * ����״̬����ͨ�������ȴ����У�����״̬��
 * ��ͨ������sleep(1000);���Ա���ϣ�ͨ������thread.interrupt()�����Ա��������״̬���׳��쳣��
 * �ȴ����У�wait()���������ã�Ҳ��һ������״̬��ֻ����notify���ѣ��޷���ϣ�
 * ���ض��У��޷���ȡ����ǣ��������е����ض��ж����Ա���ϣ�
 * 
 * 2.ʹ��ReentrantLock��lock��������ȡ�����ʱ�������Ҫ�����ȴ�����ǣ��޷�����ϣ�
 * ʹ��ReentrantLock��lockInterruptibly()��������ȡ�����ʱ�������Ҫ�����ȴ������Ա���ϣ�
 * 3.�ɴ�ϵķ����������׳�InterruptedException�쳣��
 * 4.synchronized�ò���������ʱ��Ҳ��ϲ��ˣ��ײ���Ʋ�һ����
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
			//�ɳ��Դ�����������ȴ��������Ա��������̴߳������״̬��
			//ֻ�ܴ������״̬���������ܴ��ִ��״̬���̣߳�
			lock.lockInterruptibly();
			//��ʱ�޷�����ϣ�
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
		//����߳����ߣ���������������״̬���̣߳����׳��쳣��
		t2.interrupt();
		
	}

}
