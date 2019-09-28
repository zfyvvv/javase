package cn.zfy.multithread4_threadpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.线程池-future
 * 有返回值，通过callable接口实现；
 * 
 * @author DELL
 *
 */
public class MuThPoll03 {
	
	public static void main(String[] args) throws Exception {
		//用法同下；
		FutureTask<String> task=new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "first future task!";
			}
		});
		new Thread(task).start();
		System.out.println(task.get());
		
		
		/*ExecutorService service=Executors.newFixedThreadPool(1);
		
		Future<String> future=service.submit(new Callable<String>() {
			@Override
			public String call(){
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("aaaa");
				return Thread.currentThread().getName()+"-test executor!";
			}
		});
		System.out.println(future);
		//查看线程是否结束，任务是否完成；call方法是否执行结束；
		System.out.println(future.isDone());
		
		//返回call方法中的返回值；
		System.out.println(future.get());
		System.out.println(future.isDone());*/
	}

}

