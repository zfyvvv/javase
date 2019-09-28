package cn.zfy.threadlocal;
/**
 * 1.InheritableThreadLocal:继承上下文环境数据的起点；
 * 拷贝一份数据给子线程，子线程可以更改数据；
 * @author DELL
 *
 */
public class Test4 {
	
	//Thread-0-->null
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
	//Thread-0-->222;继承了main线程中的值；
	private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();
	public static void main(String[] args) {
		
		threadLocal.set(222);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		//子线程由main线程开辟；
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
			//子线程可以更改main线程的值；
			threadLocal.set(223);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}).start();
	}
}
