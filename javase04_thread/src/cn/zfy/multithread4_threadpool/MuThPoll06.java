package cn.zfy.multithread4_threadpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.线程池-newSingleThreadExecutor
 * 单一容量线程池；
 * 线程容量为1的线程池，
 * 保证任务的顺序执行；
 * 2.线程组：ThreadGroup
 * 
 * @author DELL
 *
 */
public class MuThPoll06 {
	
	public static void main(String[] args) {
		//多态
		ExecutorService service=Executors.newSingleThreadExecutor();
		System.out.println(service);
		for(int i=0;i<5;i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"-test executor");
				}
			});
		}
	}
}

