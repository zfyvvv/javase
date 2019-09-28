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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.�̳߳�-�Զ����̳߳أ�
 * Ĭ���ṩ���̳߳ز���������ʱ����ʹ�ã�
 * ����ʱʹ���̳߳أ�90%������Ҫ�Զ����̳߳أ�
 * 
 * @author DELL
 *
 */
public class MuThPoll08 {
	public static void main(String[] args) {
		//ģ��fixedThreadPoll,�����߳�5�����������5�����̵߳������������ޣ�
		ExecutorService service=new ThreadPoolExecutor(5, 5, 0L, 
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
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
					System.out.println(Thread.currentThread().getName()+"- test executor");
				}
			});
		}
		System.out.println(service);
		
		service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}

}

