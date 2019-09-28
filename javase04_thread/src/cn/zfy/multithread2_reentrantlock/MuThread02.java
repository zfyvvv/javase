package cn.zfy.multithread2_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ReentrantLock;
 * ��������ReentrantLock�Ĺ���֮һ��
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
			//������������������޷���ȡ����ǣ�����false��
			//�����ȡ����ǣ�����true��
			//isLock=lock.tryLock();
			
			//������������������������ʱ�������Ի�ȡ����ǣ�
			//�����ʱ�����ȴ���ֱ�ӷ��ؽ����
			//������1Ϊ10ʱ��Ҳ��ȡ������������1Ϊ3ʱ�����Ի�ȡ����
			isLock=lock.tryLock(5, TimeUnit.SECONDS);
			if(isLock) {
				System.out.println("m()2 is synchronized");
			}else {
				System.out.println("m()2 is notsynchronized");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//�������ڽ�������ʱ��һ��Ҫ�ж��Ƿ��ȡ����ǣ�
			//�����ǰ�߳�û�л�ȡ����ǣ����׳��쳣��
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
