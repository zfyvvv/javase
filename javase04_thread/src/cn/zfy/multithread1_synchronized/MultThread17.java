package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.面试题
 * 定义一个容器，两个方法，增加和获取容器的大小；
 * 两个线程，一个向容器里面添加元素，一个线程当容器大小为5时，获取容器大小并停止；
 * 
 * volatile关键字；
 * 多线程可见性；
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
		
		//出现负数！
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



