package cn.zfy.sleep;
/**
 * 1、并发，多人同时访问同一资源；
 * 2、多个线程访问同一个资源；
 * @author DELL
 *
 */
public class SleepDome {
		public static void main(String[] args) {
			
		
		Webb w=new Webb();
		//多个线程访问同一个资源num;
		Thread t1=new Thread(w,"zfy1");
		Thread t2=new Thread(w,"zfy2");
		Thread t3=new Thread(w,"zfy3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Webb implements Runnable{
		private int num=50;
		
		@Override
		public void run() {
			while(true) {
			if(num<=0) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了："+num--);
		}}
		
	}
