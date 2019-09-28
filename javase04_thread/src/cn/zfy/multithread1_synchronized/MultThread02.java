package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized锁什么？
 * 锁对象：方法4和方法5锁的都是MultThread2.class，类对象；
 * 所有的锁都是应用在高并发场景中，为了保证资源的不冲突；
 * @author DELL
 *
 */
public class MultThread02 {
	private static int staticCount=0;
	
	public static synchronized void testSync4() {
			System.out.println(Thread.currentThread().getName()+"staticCount="+staticCount++);
	}
	
	public void testSync2() {
		synchronized (MultThread02.class) {
			System.out.println(Thread.currentThread().getName()+"count="+staticCount++);
		}

	}
	
	public static void main(String[] args) {
		 MultThread02 mt=new MultThread02();
		 //mt就是值当前对象；
	}
	

}
