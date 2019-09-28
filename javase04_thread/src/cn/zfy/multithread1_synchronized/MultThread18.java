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
 * 2.信号灯法，对两个线程体进行标记，标记共同的对象o;
 * 
 * @author DELL
 *
 */
public class MultThread18 {
	
	public static void main(String[] args) {
		final  MyList18 myList18=new MyList18();
		final Object o=new Object();
		//增加线程；
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					for(int i=0;i<10;i++) {
						System.out.println("m1()-->"+myList18.getSize());
						myList18.add(new Object());
						if(myList18.getSize()==5) {
							//监听不成功？？
							//等于5的时候，唤醒监听线程；自己等待；
							//监听线程执行完后，唤醒该线程；
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
		
		//该线程监听是否等于5.不等于5就等待；
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					if(myList18.getSize()!=5) {
						try {
							//wait之后，线程进入等待队列；会释放锁标记；
							o.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					System.out.println("m2()-->"+myList18.getSize());
					//执行完成后，唤醒增加线程；
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



