package cn.zfy.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
	
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(()-> {
				//模拟网络延时
				//main方法中不能抛出异常，只能捕获
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<1) {
					System.out.println("抢完了、、、");
					return ;
				}
				System.out.println(Thread.currentThread().getName()+"抢到了一件商品！还剩余"+left);
			}).start();
		}
	}
}
