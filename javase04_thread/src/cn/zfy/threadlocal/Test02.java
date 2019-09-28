package cn.zfy.threadlocal;
/**
 * 1.线程之间不相互干扰；更改自身线程数据，不影响其他线程的数据；
 * @author DELL
 *
 */
public class Test02 {
	
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		//main-->null
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		threadLocal.set(50);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		//每个线程都有自己的内存；
		//Thread-0-->72
		//Thread-1-->34
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}
	
	public static class MyRun implements Runnable{

		@Override
		public void run() {
			Integer left=threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"获取了-->"+threadLocal.get());
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"剩余-->"+threadLocal.get());
		}
		
	}
	

}
