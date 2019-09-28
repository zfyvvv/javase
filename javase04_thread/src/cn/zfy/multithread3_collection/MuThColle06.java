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
 * 1.����������DelayQueue��
 * ��ʱ���У�
 * �мƻ��Ķ�ʱ���񣻱��綨ʱ�ػ���
 * �ᰴ����ָ���Ĺ����Զ�����
 * 2.ÿ�ƻ�24h��ϵͳ��ʲô���飻
 * �ʼ��Ķ�ʱ���͵ȳ�����
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
	 * �Ƚϴ�С���Զ�ʵ������
	 * �����getDelay()�����ɣ�
	 * �����DelayQueue����Ҫ��ʱ����ɵļƻ����������getDelay()������ɣ�
	 */
	@Override
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
	}
	
	/**
	 * ��ȡʱ���ƻ��ķ�����
	 * ���ݲ���TimeUnit����������η��ؽ��ֵ��
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

