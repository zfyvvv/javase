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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.并发容器；LinkedTransferQueue；
 * 转移队列；
 * 该队列没有容量，等别人直接过来使用；
 * 相当于一个临时柜台；
 * add-队列会保存数据，不做阻塞等待；
 * transfer-TransferQueue的特有方法，必须有消费者（take方法的调用者）
 * 如果没有任意线程消费数据；transfer方法阻塞，一般由于处理即时消息；
 * 2.TransferQueue，一般配合transfer使用；实现数据的即时处理，
 * 
 * @author DELL
 *
 */
public class MuThColle07 {
	TransferQueue<String> queue=new LinkedTransferQueue<>();
	
	public static void main(String[] args){
		final MuThColle07 mt=new MuThColle07();
		
		//获取一个数据；
		new  Thread(new Runnable() {
			@Override
			public void run() {
				try {
					mt.queue.transfer("test string!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//消费数据；
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName()+":thread begin");
					System.out.println(Thread.currentThread().getName()+"->"+mt.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}


