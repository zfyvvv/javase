package cn.zfy.threadlocal;
/**
 * 1.�߳�֮�䲻�໥���ţ����������߳����ݣ���Ӱ�������̵߳����ݣ�
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
		
		//ÿ���̶߳����Լ����ڴ棻
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
			System.out.println(Thread.currentThread().getName()+"��ȡ��-->"+threadLocal.get());
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"ʣ��-->"+threadLocal.get());
		}
		
	}
	

}
