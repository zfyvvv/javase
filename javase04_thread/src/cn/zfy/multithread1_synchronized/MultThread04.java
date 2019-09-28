package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized�ؼ���
 * ͬ�������ͷ�ͬ�������ĵ��ã�
 * ͬ������ֻӰ������ͬһ���������ͬ������ʱ�������⣻
 * ��Ӱ�������̵߳��÷�ͬ���������������������Դ�ķ�����
 * �����߳�2���÷�ͬ�����������߳�1�����Ķ����޹أ����Ե��ã�
 * 	�߳�2����ͬ������ʱ�����������Ķ�����߳�1���Ĳ�һ����Ҳ���Ե��ã�
 * 
 *
 * @author DELL
 *
 */
public class MultThread04 {
	Object o=new Object();
	//ͬ������
	public synchronized void m1() {
		System.out.println("m1 start!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1 end!");
	}
	//ͬ�����������ٽ������m1���Ķ���һ����
	public synchronized void m2() {
		synchronized(o) {
			System.out.println("m2 start!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2 end!");
			
		}
	}
	//��ͨ������
	public void m3() {
		System.out.println("m3 start!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m3 end!");
		
	}
	
	//��̬�ڲ��ࣻ
	public static class MyThread01 implements Runnable{
		int i;
		MultThread04 mt;
		
		public MyThread01(int i,MultThread04 mt) {
			this.i=i;
			this.mt=mt;
		} 
	
		@Override
		public void run() {
			if(i==0) {
				mt.m1();
			}else if(i==1) {
				mt.m2();
			}else {
				mt.m3();
			}
		}
		
	}
	
	public static void main(String[] args) {
		MultThread04 mt4 = new MultThread04();
		new Thread(new MyThread01(0, mt4)).start();
		new Thread(new MyThread01(1, mt4)).start();
		new Thread(new MyThread01(-1, mt4)).start();

		
	}
}
