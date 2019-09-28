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
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.并发容器；SynchronousQueue；
 * add 无阻塞，若没有消费线程阻塞等待数据，则抛出异常；
 * put 有阻塞，若没有消费线程阻塞等待数据，则阻塞；
 * 2.用法类似于TransferQueue
 * 
 * 
 * @author DELL
 *
 */
public class MuThColle08 {
	SynchronousQueue<String> queue=new SynchronousQueue<>();
	
	public static void main(String[] args){
		final MuThColle08 mt=new MuThColle08();
		
		//获取一个数据；
		new  Thread(new Runnable() {
			@Override
			public void run() {
				try {
				System.out.println(Thread.currentThread().getName()+"thread begin");
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName()+"-"+mt.queue.take());
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"output thread").start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mt.queue.add("test add");
		//消费数据；
		try {
			mt.queue.put("test put");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mt.queue.size());
	}
}


