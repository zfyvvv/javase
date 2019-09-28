package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.volatile关键字
 *可见性；内存的可见性，每次访问变量是，都需要去内存里面看；
 *CPU都有自己的缓存；
 *通知OS操作系统底层，在CPU计算过程中，都有检查内存中数据的有效性；保证最新的内存数据使用；
 *
 * @author DELL
 *
 */
public class MultThread09 {
	//加上之后，线程可以停下来；
	//不加，线程一致循环，b的值一致为true；
	
	/*volatile*/ boolean b=true;
	
	void m() {
		System.out.println("strat!");
		while(b) {
		}
		System.out.println("end!");
		
	}
	
	public static void main(String[] args) {
		MultThread09 mt9=new MultThread09();
		new Thread(()-> {
			mt9.m();
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//该数据是在内存里面的；
		mt9.b=false;

	}
}


