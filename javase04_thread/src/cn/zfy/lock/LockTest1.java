package cn.zfy.lock;
/**
 * 1.可重入锁：锁可以延续使用；
 * @author DELL
 *
 */
public class LockTest1 {
	public static void main(String[] args) {
		LockTest1 lt=new LockTest1();
		lt.test1();
		
	}
	
	public void test1() {
		synchronized (this) {
			while(true) {
				synchronized (this) {
					System.out.println("ReentrantLock!!");
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
