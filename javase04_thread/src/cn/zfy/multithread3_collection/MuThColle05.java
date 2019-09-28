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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.并发容器；LinkedBlockingQueue；
 * 调用不同的APU，出现不同的特性；
 * add;
 * put;
 * offer
 * offer(vlaue,int,timeunit);
 * 当前，它也有take（）；也是阻塞的；
 * @author DELL
 *
 */
public class MuThColle05 {
	final BlockingQueue<String> queue=new ArrayBlockingQueue<>(3);
	
	public static void main(String[] args) {
		final MuThColle05 mt=new MuThColle05();
		for(int i=0;i<5;i++) {
			//Queue full;
			//add 容量不足时，抛出异常；
			//System.out.println("add method:"+mt.queue.add("value"+i));
			
			//put；容量不足时，阻塞等待；
			try {
				mt.queue.put("put value"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("put method"+i);
			
			//单参数offer；不阻塞；容量不足时返回false；当前新增数据放弃；
			//System.out.println("offer method:"+mt.queue.offer("value"+i));
			
			//多参数offer;容量不足时，在单位时间内，有容量空闲，则新增数据，返回true；
			//如果在阻塞范围内，无容量空间，放弃新增数据，返回false；
			/*try {
				System.out.println("offer method:"+
				mt.queue.offer("value"+i, 1, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		System.out.println(mt.queue);
	}
}

