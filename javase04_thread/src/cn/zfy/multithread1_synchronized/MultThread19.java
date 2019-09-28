package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.������
 * ����һ���������������������Ӻͻ�ȡ�����Ĵ�С��
 * �����̣߳�һ���������������Ԫ�أ�һ���̵߳�������СΪ5ʱ����ȡ������С��ֹͣ��
 * 2.ʹ��CountDownLatch
 * 
 * 
 * 
 * @author DELL
 *
 */
public class MultThread19 {
	
	public static void main(String[] args) {
		final  MyList19 myList19=new MyList19();
		final CountDownLatch cdt=new CountDownLatch(1);
		//�����̣߳�
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<8;i++) {
					System.out.println("m1()-->"+myList19.getSize());
					myList19.add(new Object());
					if(myList19.getSize()==5) {
						//��=5ʱ�����ż�һ��
						//Ȼ���߳�2��ʼ������
						cdt.countDown();
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//���̼߳����Ƿ����5.������5�͵ȴ���
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(myList19.getSize()!=5) {
					try {
						//�ȴ����ſ��ţ����ǽ���ȴ����У�
						cdt.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				System.out.println("m2()-->"+myList19.getSize());
			}
		}).start();
	}
	
}

class MyList19{
	private Object[] entity=new Object[20];
	private int count=0;
	public void add(Object o) {
		entity[count]=o;
		count++;
	}
	public int getSize() {
		return count;
	}
}



