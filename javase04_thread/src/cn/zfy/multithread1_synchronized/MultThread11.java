package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.AtomicXxx;
 * 同步类型；
 * 原子操作类型，其中的每个方法都是原子操作，可以保证线程安全；
 * @author DELL
 *
 */
public class MultThread11 {
	AtomicInteger count=new AtomicInteger(0);
	void m() {
		for(int i=0;i<1000;i++) {
			count.incrementAndGet();
		}
	}
	public static void main(String[] args) {
		MultThread11 mt10=new MultThread11();
		List<Thread> Threads=new ArrayList<Thread>();
		for(int i=0;i<10;i++) {
			Threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					mt10.m();
				}
			}));
		}
		for(Thread thread:Threads) {
			thread.start();
		}
		
		for(Thread thread:Threads) {
			try {
				//让线程连接起来；
				//当main调用join方法后，将其他线程连接起来；
				//将对方线程的结果连接到当前线程的当前位置上；
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//9157,理论上是10000
		System.out.println(mt10.count);
	}
}


