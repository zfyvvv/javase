package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.并发容器；DelayQueue；
 * 延时队列，
 * 有计划的定时任务；比如定时关机；
 * 会按照你指定的规则自动排序；
 * 2.每计划24h，系统做什么事情；
 * 邮件的定时发送等场景；
 * 
 * @author DELL
 *
 */
public class MuThColle06 {
	static BlockingQueue<MyTask> queue=new DelayQueue<>();
	
	public static void main(String[] args) throws InterruptedException {
		long value=System.currentTimeMillis();
		MyTask task1=new MyTask(value+2000);
		MyTask task2=new MyTask(value+1000);
		MyTask task3=new MyTask(value+3000);
		MyTask task4=new MyTask(value+2500);
		MyTask task5=new MyTask(value+1500);
		
		queue.put(task1);
		queue.put(task2);
		queue.put(task3);
		queue.put(task4);
		queue.put(task5);
		
		System.out.println(queue);
		System.out.println(value);
		for(int i=0;i<5;i++) {
			System.out.println(queue.take());
		}
	}
}

class MyTask implements Delayed{
	private long compareValue;
	
	public MyTask(long compareValue) {
		this.compareValue=compareValue;
	}
	
	/**
	 * 比较大小，自动实现升序；
	 * 建议和getDelay()配合完成；
	 * 如果在DelayQueue是需要按时间完成的计划，必须配合getDelay()方法完成；
	 */
	@Override
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
	}
	
	/**
	 * 获取时长计划的方法；
	 * 根据参数TimeUnit来决定，如何返回结果值；
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(compareValue-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "Task compareValue is" + this.compareValue;
	}
	
	
	
}

