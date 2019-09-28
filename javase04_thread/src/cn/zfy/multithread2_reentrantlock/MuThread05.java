package cn.zfy.multithread2_reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.练习
 * 自定义同步容器，容器上限为10；在多线程中应用，并保证线程安全；（生产者消费者模式）
 * 
 * 
 * @author DELL
 *
 */
public class MuThread05 {
	
	public static void main(String[] args) {
		Container container=new Container();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("container.add-->"+i);
					container.add(new String("周"+i));
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<2;i++) {
					System.out.println("container.remove-->"+i);
					System.out.println(container.get(i+3));
					container.remove(i);
				}
				
			}
		}).start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if(container.getSize()==9) {
					System.out.println(container.get(9));
					break;
					}
				}
			}
		}).start();*/
		

		System.out.println(container.getSize());
	}
}

//是在容器上上锁，还是在运行程序中上锁？
class Container{
	
	private List list=new ArrayList<>();
	Lock lock=new ReentrantLock();
	
	public void add(Object o) {
		lock.lock();
		try {
			if(list.size()>=10) {
				lock.wait();
				lock.notifyAll();
			}
			list.add(o);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
		
	}
	public void remove(int i) {
		lock.lock();
		try {
			list.remove(i);
			lock.notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
		
		
	}
	
	public Object get(int i) {
		lock.lock();
		try {
			return list.get(i);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
			return null;
		}
	}
	
	public int getSize() {
		return list.size();
	}
	
	
}



