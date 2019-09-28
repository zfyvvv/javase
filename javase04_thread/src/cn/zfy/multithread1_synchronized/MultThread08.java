package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字
 *同步方法-异常
 *
 * @author DELL
 *
 */
public class MultThread08 {
	int i=0;
	
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+"-->start!");
		while(true) {
			i++;
			System.out.println(Thread.currentThread().getName()+"-->i-->"+i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//发生异常！
			//发生异常释放锁，实际业务中该如和解决？
			if(5==i) {
				i=i/0;
			}
			
			//解决方案；
	/*		try {
				if(5==i) {
					i=i/0;
				}
			} catch (Exception e) {
				// TODO: handle exception
				i=0;
			}*/
			
		}
		
	}
	
	public static void main(String[] args) {
		MultThread08 mt8=new MultThread08();
		new Thread(()-> {
			mt8.m();
		},"t1").start();
		//t1中i=5后，抛出异常；释放锁！
		//t2接在i=6继续运行，
		new Thread(()-> {
			mt8.m();
		},"t2").start();

	}
}


