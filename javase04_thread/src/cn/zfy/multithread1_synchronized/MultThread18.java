package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.������
 * ����һ���������������������Ӻͻ�ȡ�����Ĵ�С��
 * �����̣߳�һ���������������Ԫ�أ�һ���̵߳�������СΪ5ʱ����ȡ������С��ֹͣ��
 * 2.�źŵƷ����������߳�����б�ǣ���ǹ�ͬ�Ķ���o;
 * 
 * @author DELL
 *
 */
public class MultThread18 {
	
	public static void main(String[] args) {
		final  MyList18 myList18=new MyList18();
		final Object o=new Object();
		//�����̣߳�
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					for(int i=0;i<10;i++) {
						System.out.println("m1()-->"+myList18.getSize());
						myList18.add(new Object());
						if(myList18.getSize()==5) {
							//�������ɹ�����
							//����5��ʱ�򣬻��Ѽ����̣߳��Լ��ȴ���
							//�����߳�ִ����󣬻��Ѹ��̣߳�
							o.notifyAll();
							try {
								o.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
		//���̼߳����Ƿ����5.������5�͵ȴ���
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					if(myList18.getSize()!=5) {
						try {
							//wait֮���߳̽���ȴ����У����ͷ�����ǣ�
							o.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					System.out.println("m2()-->"+myList18.getSize());
					//ִ����ɺ󣬻��������̣߳�
					o.notifyAll();
				}
			}
		}).start();
	}
}

class MyList18{
	private Object[] entity=new Object[20];
	private volatile int count=0;
	public void add(Object o) {
		entity[count]=o;
		count++;
	}
	public int getSize() {
		return count;
	}
}



