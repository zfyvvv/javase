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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.�̳߳�-Executor�ӿ�
 * Executor,�̳߳صײ㴦����ƣ�
 * ��ʹ���̳߳ص�ʱ�򣬵ײ���ε����̵߳ĵײ��߼���
 * 
 * @author DELL
 *
 */
public class MuThPoll01 implements Executor{
	
	public static void main(String[] args) {
		new MuThPoll01().execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"- test execute");
			}
		});
		}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		new Thread(command).start();
	}
}

