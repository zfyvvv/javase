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
 * 1.线程池-ExecutorService 
 * FixedThreadPool(5)，固定容量线程池；new Xxxxx
 * 容量表示最大容量；
 * ExecutorService，线程池服务类型，所有的线程类型都实现了这个接口；
 * 实现这个接口，代表可以提供线程池的能力；
 * shutdown-优雅关闭；不是强行关闭线程池，回收线程池中的资源，而是不再处理新的任务；
 * 将已经接受的任务处理完毕后再关闭；
 * 2.Executors-Executor的工具类，类似collection的collections的关系；
 * 可以更加简单的创建若干线程池；
 * 
 * @author DELL
 *
 */
public class MuThPoll02 {
	
	public static void main(String[] args) {
		//多态
		ExecutorService service=Executors.newFixedThreadPool(5);
		for(int i=0;i<6;i++) {
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
		System.out.println(service);
		
		service.shutdown();
		//是否已经结束，相当于回收了资源；
		System.out.println(service.isTerminated());
		//是否已经关闭，是否调用过shutdown方法；
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}

}

