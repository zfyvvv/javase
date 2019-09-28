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
 * 1.线程池-Executor接口
 * Executor,线程池底层处理机制；
 * 在使用线程池的时候，底层如何调用线程的底层逻辑；
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

