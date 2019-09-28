package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字
 *同步方法-多方法调用的原子性问题；
 *同步方法只能保证当前方法的原子性问题，不能保障多个业务方法之间的互相访问的原子性。
 *注意在商业开发中，多方法要求结构访问原子操作，需要多个方法都加锁，且锁定同一个资源；
 *
 * 一般来说，商业项目中，不考虑业务逻辑上的脏读问题，只关注数据库层面的脏读问题；
 *
 * @author DELL
 *
 */
public class MultThread05 {
	private double d=0.0;
	public synchronized void m1(double d) {
		//如果注释，两次打印的结果都是200；
		//如果不注释，两次打印的结果不同，脏数据；
		//相当于复杂的业务逻辑代码；执行需要一定的时间；
/*		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.d=d;
	}
	public  double m2() {
		return this.d;
	}
	
	public static void main(String[] args) {
		 final MultThread05 mt5 = new MultThread05();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt5.m1(200);
			}
		}).start();
		
		//我们想要的结果是：200和200；因为已经启动一个线程去set值；
		//但实际结果是：0和200
		//把m1中的睡眠删掉，很可能没有脏读问题；
		System.out.println(mt5.m2());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mt5.m2());
	}
}
