package cn.zfy.multithread2_reentrantlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.练习
 * 自定义同步容器，容器上限为10；在多线程中应用，并保证线程安全；（生产者消费者模式）
 * 2.相比于synchronized，更加精准；
 *synchronized中唤醒的可能是同类线程，但是这里面是条件线程；
 *Condition，为lock增加条件；但条件满足时，做什么事情，如加锁或解锁，如等待或唤醒；
 *
 *3.当目前为止，并发编程的基础知识已经将完了，知识基础知识哦；
 *
 * 
 * @author DELL
 *
 */
public class MuThread07 {
	public static void main(String[] args) {
		Container07<String> container=new Container07<>();
		//启动12个消费者；
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<5;j++) {
						System.out.println("consumer get:"+container.get());
					}
				}
			},"consumer"+i).start();
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//启动12个生产者；
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<25;j++) {
					container.put("container value"+j);
					}
				}
			},"producer"+i).start();
		}
	}
}

//是在容器上上锁，还是在运行程序中上锁？-->容器里面上锁；
//同步容器，里面的方法都是同步的；
//有了lock，不用synchronized；
class Container07<E>{
	private final LinkedList<E> list=new LinkedList<>();
	private final int MAX=10;
	private int count=0;
	
	private Lock lock=new ReentrantLock();
	private Condition producer=lock.newCondition();
	private Condition consumer=lock.newCondition();
	
	public  int getConunt() {
		return count;
	}
	
	public void put(E e) {
		lock.lock();
		try {
			while(list.size()==MAX) {
				System.out.println(Thread.currentThread().getName()+"等待...");
				producer.await();
			}
			System.out.println(Thread.currentThread().getName()+"put...");
			list.add(e);
			count++;
			//借助条件，唤醒所有的消费者；
			consumer.signalAll();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				lock.unlock();
			}
		}


	
	public E get() {
		E e=null;
		lock.lock();
		try {
			while(list.size()==0) {
				System.out.println(Thread.currentThread().getName()+"等待...");
				//借助条件，消费者进入等待队列；
				consumer.await();
			}
			System.out.println(Thread.currentThread().getName()+"get...");
			e=list.removeFirst();
			count--;
			//借助条件，唤醒所有的生产者；
			producer.signal();
			
		}catch (Exception e1) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
		return e;

	}

}



