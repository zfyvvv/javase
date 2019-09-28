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
 * 
 * volatile�ؼ��֣�
 * ���߳̿ɼ��ԣ�
 * 
 * @author DELL
 *
 */
public class MultThread17 {
	private volatile MyList myList=new MyList();
	
	void m1() {
		for(int i=0;i<10;i++) {
			myList.add(new Object());
			System.out.println("m1()-->"+myList.getSize());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	void m2() {
		while(true) {
			if(myList.getSize()==5) {
				System.out.println("m2()-->"+myList.getSize());
				break;
				}
		}
	}
	
	public static void main(String[] args) {
		MultThread17 mt17=new MultThread17();
		
		//���ָ�����
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt17.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt17.m2();
			}
		}).start();
	}
	
}

class MyList{
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



