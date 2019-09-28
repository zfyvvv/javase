package cn.zfy.threadlocal;
/**
 * 1��ThreadLocal������������
 * get/set/initialValue
 * 2.�����ʼֵ��
 * 3.ÿ���̶߳����Լ����ڴ棻
 * @author DELL
 *
 */
public class Test01 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
	//���ĳ�ʼֵ��
	/*private static ThreadLocal<Integer> threadLocal=new ThreadLocal(){
		protected Object initialValue() {
			return 100;
		}
	};*/
	//���ĳ�ʼֵ����������ʹ��xxx���ʽ
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->101);
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
	}
	
	public static class MyRun implements Runnable{

		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*100));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
		
	}
	

}
