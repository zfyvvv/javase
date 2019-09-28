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
 * 
 * 2.wati/notify都是和while配合应用，可以避免多线程并发判断逻辑失效问题；
 * 保证wait之后，还可以进行连续判断；
 * if只能判断一次；
 * 
 * 3.JDK1.7和现在的很多框架兼容，但是学springCloud时，建议学JDK1.8；
 * 
 * 
 * @author DELL
 *
 */
public class MuThread06 {
	public static void main(String[] args) {
		Container06<String> container=new Container06<>();
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
class Container06<E>{
	private final LinkedList<E> list=new LinkedList<>();
	private final int MAX=10;
	private int count=0;
	
	public synchronized int getConunt() {
		return count;
	}
	
	public synchronized void put(E e) {
		while(list.size()==10) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		list.add(e);
		count++;
		this.notifyAll();
	}
	
	public synchronized E get() {
		E e=null;
		while(list.size()==0) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		e=list.removeFirst();
		count--;
		this.notifyAll();
		return e;
	}

}



