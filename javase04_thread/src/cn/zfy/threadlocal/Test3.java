package cn.zfy.threadlocal;
/**
 * 1.�߳������Ļ�����
 * threadLocal��ʹ�õĹ�����һ��Ҫ�����Ļ�����������������㣻
 * 2.������:������ã�������������߳��壻
 * 3.run���������߳������;
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
			//�������е�Thread.currentThread().getName()��main�����У�
			//��start�����󣬲ſ��������̣߳�
			threadLocal.set(22);
			System.out.println(Thread.currentThread().getName()+"������-->"+threadLocal.get());
		} 

		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*100));
			System.out.println(Thread.currentThread().getName()+"�߳���-->"+threadLocal.get());
		}
		
	}
	

}
