package cn.zfy.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
	
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(()-> {
				//ģ��������ʱ
				//main�����в����׳��쳣��ֻ�ܲ���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<1) {
					System.out.println("�����ˡ�����");
					return ;
				}
				System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ʣ��"+left);
			}).start();
		}
	}
}
