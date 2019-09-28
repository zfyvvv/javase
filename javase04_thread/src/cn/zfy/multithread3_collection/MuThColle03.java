package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ConcurrentLinkedQueue；
 * 基础连表同步队列；
 * @author DELL
 *
 */
public class MuThColle03 {
	
	public static void main(String[] args) {
		Queue<String> queue=new ConcurrentLinkedQueue<>();
		for(int i=0;i<10;i++) {
			//添加10个数据;
			queue.offer("value"+i);
		}
		System.out.println(queue);
		System.out.println(queue.size());
		//查看queue中的首数据；
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//获取queue中的首数据;
		System.out.println(queue.poll());
		System.out.println(queue.size());

	}
}

