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
 * 1.面试题
 * 定义一个容器，两个方法，增加和获取容器的大小；
 * 两个线程，一个向容器里面添加元素，一个线程当容器大小为5时，获取容器大小并停止；
 * 2.使用CountDownLatch
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
		//增加线程；
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<8;i++) {
					System.out.println("m1()-->"+myList19.getSize());
					myList19.add(new Object());
					if(myList19.getSize()==5) {
						//当=5时，门闩减一；
						//然后线程2开始工作；
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
		
		//该线程监听是否等于5.不等于5就等待；
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(myList19.getSize()!=5) {
					try {
						//等待门闩开放，不是进入等待队列；
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



