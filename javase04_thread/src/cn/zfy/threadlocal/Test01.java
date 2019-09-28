package cn.zfy.threadlocal;
/**
 * 1、ThreadLocal的三个方法；
 * get/set/initialValue
 * 2.赋予初始值；
 * 3.每个线程都有自己的内存；
 * @author DELL
 *
 */
public class Test01 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
	//更改初始值；
	/*private static ThreadLocal<Integer> threadLocal=new ThreadLocal(){
		protected Object initialValue() {
			return 100;
		}
	};*/
	//更改初始值，方案二；使用xxx表达式
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->101);
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
	}
	
	public static class MyRun implements Runnable{

		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*100));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
		
	}
	

}
