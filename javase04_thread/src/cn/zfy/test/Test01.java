package cn.zfy.test;

import java.util.Currency;

/**
 * 1���̵߳�ʵ�֣�
 * 2���̵߳�ֹͣ��
 * 3���̵߳ĵȴ���
 * 4���̵߳ļ��룻
 * 5���̵߳Ļ�����Ϣ��ȡ��
 * 6���̵߳����ȼ���
 * @author DELL
 *
 */
public class Test01 {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new App1();
		
		App2 a=new App2();
		Thread t2=new Thread(a);
		
		App3 b=new App3();
		Thread t3=new Thread(b);
		
		App4 c=new App4();
		Thread t4=new Thread(c);
		
		App5 d=new App5();
		Thread t5=new Thread(d);
		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		t5.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("main->"+i);
			if(3==i) {
//				a.stop();
//				t3.join();
			}
		}
	}
}
/**
 * 1���̵߳�ʵ�ַ�ʽ1��
 * @author DELL
 *
 */
class App1 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("app1->"+i);
		}
		super.run();
	}
}
/**
 * 1���̵߳�ʵ�ַ�ʽ2��
 * 2���̵߳�ֹͣ��ʽ��
 * @author DELL
 *
 */
class App2 implements Runnable{
	boolean flag=false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(flag) {}
			System.out.println("app2->"+i);
			if(flag) {break;}
	}
  }
	public void stop() {
		this.flag=true;
	}
	
}
/**
 * 3���̵߳ļ��룻
 * @author DELL
 *
 */
class App3 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("app3->"+i);
	}
  }
}

/**
 * 1���̵߳�˯�ߣ�
 * @author DELL
 *
 */
class App4 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("app4->"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
}
/**
 *1���̵߳ĵȴ��ͻ��ѣ�
 * @author DELL
 *
 */
class App5 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("app5->"+i);
			if(4==i) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			                                                        
	}
}
}

