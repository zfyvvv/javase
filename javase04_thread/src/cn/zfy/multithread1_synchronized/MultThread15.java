package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.门闩，CountDownLatch;
 * 可以替代锁的部分功能，可以和锁混合使用；
 * 门闩未开发之前等待，完全开放之后执行；
 * 避免锁的低效问题；
 * 
 * 2.应用
 * 很多框架的源代码都是使用门闩；
 * spring框架中classpathXMLContain;
 * 初始化容器，创建对象时就有一个先后的顺序；
 * 先init所有的properties；后init所有的serviceReginsry，后init所有的bean；
 * 如果加notify，效率太低；
 * 可以使用不同的门闩；
 * 
 * 3.栈和栈帧
 * 运行完成后，打断所有的引用；
 * 栈帧中存临时变量引用，都是在运行过程中指向堆中的对象；
 * 方法区中存放的是字节码或方法运行码；包含逻辑和数据；
 * 数据包含真实数据和引用数据；
 * 真实数据是指8种基础类型，直接占用字节进行保存；会移动到方法区和栈帧里面；
 * 引用数据是复制真实的主线程里面的基础引用到栈帧里面（方法区栈帧中）；
 * 然后再把引用关联到堆空间中；
 * 当栈帧执行结束以后，弹栈了全部都空了，把所有的引用全部打断，把临时变量都清空了；
 * 但是主方法栈中和堆中的数据不会进行回收；
 * @author DELL
 *
 */
public class MultThread15 {
	CountDownLatch latch=new CountDownLatch(5);
	void m1() {
		try {
			//等待门闩开放，何时开发？
			//当count为0时开放；
			latch.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("m1()....start!");
	}
	void m2() {
		System.out.println("m2.start...");
		for(int i=0;i<10;i++) {
			if(latch.getCount()!=0) {
				System.out.println("latch count-->"+latch.getCount());
				//减门闩上的锁；
				latch.countDown();
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2()...."+i);
		}
	}
	
	public static void main(String[] args) {
		MultThread15 mt15=new MultThread15();
		
		//
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt15.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt15.m2();
			}
		}).start();
	}
}


