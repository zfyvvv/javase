package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized锁什么？
 * 锁对象：synchronized (this)和synchronized方法都是锁当前对象；
 * 当前对象是指MultThread1，运行代码依赖的对象；
 * 方法2和方法3锁的同一个对象；
 * @author DELL
 *
 */
public class MultThread01 {
	private int count=0;
	private Object o=new Object();
	
	public void testSync1() {
		synchronized (o) {
			System.out.println(Thread.currentThread().getName()+"count="+count++);
		}
	}
	
	public void testSync2() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+"count="+count++);
		}

	}
	public synchronized void testSync3() {
		System.out.println(Thread.currentThread().getName()+"count="+count++);
	}
	
	public static void main(String[] args) {
		 MultThread01 mt=new MultThread01();
		 //mt就是值当前对象；
		 mt.testSync1();
	}

}
