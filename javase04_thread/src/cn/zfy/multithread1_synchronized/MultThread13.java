package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字;
 * 锁的是对象，不是引用；
 * 锁的是两个对象，打印的是同一个对象；
 * 打印是需要通过对象（MultThread13）去打印的；
 * 通过MultThread13的引用，去打印;
 * 打印永远依赖于this.o;所以永远先找this,后找this.o；
 * 而锁定的时候，已经指定了前一个对象；当new后，锁定是，引用还是o，但是对象却还了；
 * 
 * 2.锁对象变更问题；
 * 同步代码一旦加锁后，那么会有一个临时变量的锁指向锁对象，和真实的引用无直接关联；
 * 在锁未释放之前，修改锁对象引用，不会影响同步代码的执行；
 * 
 * @author DELL
 *
 */
public class MultThread13 {
	Object o=new Object();
	
	int i=0;
	int a() {
		try {
			/*
			 * return i->
			 * int _returnValue=i;//0,java运行时会产生大量的临时变量；
			 * return _returnValue;
			 * 
			 */
			return i;
		} finally {
			i=10;
		}
	}
	
	
	
	void m(){
		synchronized (o) {
			System.out.println(Thread.currentThread().getName()+"-->start!");
			while(true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"-->"+o);
			}
		}
	}
	
	public static void main(String[] args) {
		MultThread13 mt13=new MultThread13();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				mt13.m();
			}
		},"t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t1一直运行；
		//Object o=new Object();
		//t1和t2交替运行；
		//锁的是对象，不是引用；
		mt13.o=new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt13.m();
			}
		},"t2").start();
		
		//0,0,10
		System.out.println(mt13.i);
		System.out.println(mt13.a());
		System.out.println(mt13.i);
	}
	
}


