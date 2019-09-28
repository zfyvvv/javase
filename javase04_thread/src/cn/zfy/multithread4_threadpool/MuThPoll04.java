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
 * 1.�̳߳�
 * newCachedThreadPool��
 * �����̳߳أ�ÿ���߳̿��г���60��֮�󣬻��Զ����٣�
 * 2.�ڲ�Ӧ�û����Ӧ�ã�
 * ���������ڲ�����˲�䴦��ʱӦ�ã�
 * @author DELL
 *
 */
public class MuThPoll04 {
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
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
		System.out.println(service);
		//�ȴ�65S,���̵߳�Ĭ���������ڣ�
		try {
			TimeUnit.SECONDS.sleep(65);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(service);
	}
}

