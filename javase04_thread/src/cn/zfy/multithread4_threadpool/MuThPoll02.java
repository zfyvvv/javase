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
 * 1.�̳߳�-ExecutorService 
 * FixedThreadPool(5)���̶������̳߳أ�new Xxxxx
 * ������ʾ���������
 * ExecutorService���̳߳ط������ͣ����е��߳����Ͷ�ʵ��������ӿڣ�
 * ʵ������ӿڣ���������ṩ�̳߳ص�������
 * shutdown-���Źرգ�����ǿ�йر��̳߳أ������̳߳��е���Դ�����ǲ��ٴ����µ�����
 * ���Ѿ����ܵ���������Ϻ��ٹرգ�
 * 2.Executors-Executor�Ĺ����࣬����collection��collections�Ĺ�ϵ��
 * ���Ը��Ӽ򵥵Ĵ��������̳߳أ�
 * 
 * @author DELL
 *
 */
public class MuThPoll02 {
	
	public static void main(String[] args) {
		//��̬
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
		//�Ƿ��Ѿ��������൱�ڻ�������Դ��
		System.out.println(service.isTerminated());
		//�Ƿ��Ѿ��رգ��Ƿ���ù�shutdown������
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

