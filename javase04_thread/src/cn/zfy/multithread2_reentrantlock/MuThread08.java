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
 * 1.ThreadLocal
 *本质是一个map；key是Thread.currentThread(),  value->线程需要保存的变量；
 *ThreadLocal.set(value) -> map.put(Thread.currentThread(),value);
 *ThreadLocal.get()      -> map.get(Thread.currentThread());
 *
 *2.内存问题，在并发量高时，可能内存溢出；
 *使用ThreadLocal的时候，一定注意回收资源；每个线程结束之前，一定要将当前线程变量保存的资源删除；
 *ThreadLocal.remove；
 * 
 * @author DELL
 *
 */
public class MuThread08 {
	volatile static String name="zhangsan";
	//回收，变量指向null；
	static ThreadLocal<String> tl=new ThreadLocal<>();
	
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//zfy
				System.out.println(name);
				//null,
				System.out.println(tl.get());
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name="zfy";
				tl.set("ltt");
			}
		}).start();
		
		
		
	}
	

}



