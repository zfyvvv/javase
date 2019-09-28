package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.三种List的比较；
 * 效率和准确性；
 * 
 * @author DELL
 *
 */
public class MuThColle02 {
	
	public static void main(String[] args) {
		//110ms,98810<100000;
		//final List<String> list=new ArrayList<>();
		//102ms,100000;
		//final List<String> list=new Vector<>();
		//20228ms,100000;
		final List<String> list=new CopyOnWriteArrayList<>();
		
		final Random r=new Random();
		Thread[] array=new Thread[10];
		final CountDownLatch latch=new CountDownLatch(array.length);
		
		long begin=System.currentTimeMillis();
		for(int i=0;i<array.length;i++) {
			array[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<10000;j++) {
						list.add("value"+r.nextInt(100));
					}
					latch.countDown();
				}
			});
		}
		for(Thread t:array) {
			t.start();
		}	
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		System.out.println("执行时间为："+(end-begin)+"ms");
		System.out.println("list.size()->"+list.size());
		}
	}

