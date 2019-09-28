package cn.zfy.multithread4_threadpool;

import java.security.Timestamp;
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
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.线程池
 * newScheduledThreadPool，
 * 定时完成任务；计划任务时选用；
 * 底层是delayqueue；
 * @author DELL
 *
 */
public class MuThPoll05 {
	public static void main(String[] args) {
		//需要使用自己的方法，不用多态；
		ScheduledExecutorService service=Executors.newScheduledThreadPool(3);
		System.out.println(service);
		//service.scheduleAtFixedRate(任务，第一次执行任务时间，多次执行任务的间隔，间隔的单位)
		//每隔0.3秒执行一个任务；
		service.scheduleAtFixedRate(new Runnable() {
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
		}, 0, 300, TimeUnit.MILLISECONDS);
		
		System.out.println(service);
		try {
			TimeUnit.SECONDS.sleep(65);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(service);
	}

}

