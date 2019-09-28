package cn.zfy.threadlocal;
/**
 * 1.InheritableThreadLocal:�̳������Ļ������ݵ���㣻
 * ����һ�����ݸ����̣߳����߳̿��Ը������ݣ�
 * @author DELL
 *
 */
public class Test4 {
	
	//Thread-0-->null
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
	//Thread-0-->222;�̳���main�߳��е�ֵ��
	private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();
	public static void main(String[] args) {
		
		threadLocal.set(222);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		//���߳���main�߳̿��٣�
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
			//���߳̿��Ը���main�̵߳�ֵ��
			threadLocal.set(223);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}).start();
	}
}
