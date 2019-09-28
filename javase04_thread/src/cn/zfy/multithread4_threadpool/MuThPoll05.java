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
 * 1.�̳߳�
 * newScheduledThreadPool��
 * ��ʱ������񣻼ƻ�����ʱѡ�ã�
 * �ײ���delayqueue��
 * @author DELL
 *
 */
public class MuThPoll05 {
	public static void main(String[] args) {
		//��Ҫʹ���Լ��ķ��������ö�̬��
		ScheduledExecutorService service=Executors.newScheduledThreadPool(3);
		System.out.println(service);
		//service.scheduleAtFixedRate(���񣬵�һ��ִ������ʱ�䣬���ִ������ļ��������ĵ�λ)
		//ÿ��0.3��ִ��һ������
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

