package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.volatile关键字
 *可见性；内存的可见性，每次访问变量是，都需要去内存里面看；
 *不是枷锁问题，只是内存数据可见；
 *
 *
 * @author DELL
 *
 */
public class MultThread10 {
	
	volatile int count=0;
	//加上synchronized后，为10000
	/*synchronized*/ void m() {
		for(int i=0;i<1000;i++) {
			count++;
		}
	}
	public static void main(String[] args) {
		MultThread10 mt10=new MultThread10();
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


