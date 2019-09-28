package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.三种map的比较；
 * 效率和准确性；
 * 
 * 
 * 
 * @author DELL
 *
 */
public class MuThColle01 {
	
	public static void main(String[] args) {
		
		//23ms,103;
		//final Map<String, String> map=new HashMap<String, String>();
		//54ms,100;
		//final Map<String, String> map=new ConcurrentHashMap<>();
		//85ms,100;
		final Map<String, String> map=new ConcurrentSkipListMap<>();
		final Random r=new Random();
		Thread[] array=new Thread[10];
		final CountDownLatch latch=new CountDownLatch(array.length);
		
		long begin=System.currentTimeMillis();
		for(int i=0;i<array.length;i++) {
			array[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<100;j++) {
						map.put("key"+r.nextInt(100), "value"+r.nextInt(100));
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
		System.out.println("map.size()->"+map.size());
		}
	}

