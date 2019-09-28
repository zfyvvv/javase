package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized关键字
 * 同步方法和非同步方法的调用；
 * 同步方法只影响锁定同一个锁对象的同步方法时的锁问题；
 * 不影响其他线程调用非同步方法，或调用其他锁资源的方法；
 * 即：线程2调用非同步方法，和线程1锁定的对象无关，可以调用；
 * 	线程2调用同步方法时，但是锁定的对象和线程1锁的不一样，也可以调用；
 * 
 *
 * @author DELL
 *
 */
public class MultThread04 {
	Object o=new Object();
	//同步方法
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
	//同步方法，锁临界对象；与m1锁的对象不一样；
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
	//普通方法；
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
	
	//静态内部类；
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
