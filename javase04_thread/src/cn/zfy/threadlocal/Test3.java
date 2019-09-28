package cn.zfy.threadlocal;
/**
 * 1.线程上下文环境；
 * threadLocal在使用的过程中一定要看他的环境，尤其是他的起点；
 * 2.构造器:哪里调用，就属于哪里，找线程体；
 * 3.run方法：本线程自身的;
 * @author DELL
 *
 */
public class Test3 {
	
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		new Thread(new MyRun()).start();
	}
	
	public static class MyRun implements Runnable{
		public MyRun() {
			//构造器中的Thread.currentThread().getName()是main方法中；
			//当start启动后，才开启了新线程；
			threadLocal.set(22);
			System.out.println(Thread.currentThread().getName()+"构造器-->"+threadLocal.get());
		} 

		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*100));
			System.out.println(Thread.currentThread().getName()+"线程体-->"+threadLocal.get());
		}
		
	}
	

}
