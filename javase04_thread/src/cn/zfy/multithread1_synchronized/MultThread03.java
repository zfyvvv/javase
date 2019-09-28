package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized锁的目的？
 * 同步方法，原子性；
 * 加锁的目的就是为了保证操作的原子性；
 * 原子性：并不是count++是原子性的，而是代码从开始执行到结束，都是原子性的；
 * 某一个范围内的代码操作时不可分割的；
 * 2.锁的概念？
 * 不是在栈帧里面，栈帧里面执行代码，但是锁实在堆里面或者代码区；
 * 堆空间里面有对象，代码区里面有类对象；我们枷锁的是对象或类对象；
 * 加锁之后，访问对象时没有问题的；但是给对象再次加锁是不行的；
 * 加锁之后，并不是锁类对象或对象的方法不可用；
 *
 * @author DELL
 *
 */
public class MultThread03 implements Runnable{
	private int count=0;

	//加上锁之后，按照顺序打印；
	@Override
	public /*synchronized*/ void run() {
		System.out.println(Thread.currentThread().getName()+"count="+count++);
	}
	public static void main(String[] args) {
		MultThread03 mt3 = new MultThread03();
		for(int i=0;i<5;i++) {
			new Thread(mt3,"Thread-"+i).start();
		}
		
		//结果全部是0；因为每次都有new MultThread3对象，导致每次count都是0；
		/*for(int i=0;i<5;i++) {
			new Thread(new MultThread3(),"Thread-"+i).start();
		}*/
		
	}
}
