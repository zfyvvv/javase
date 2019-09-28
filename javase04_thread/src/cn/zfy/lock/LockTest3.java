package cn.zfy.lock;
/**
 * 1.可重入锁：锁可以延续使用；且里面有计数器；
 * 2.原理：就是判断进来的线程是否是已经锁定的线程；
 *	如果是，那就不用等了，就直接使用吧；
 *	如果不是，那就好好等，等这个锁释放了，你才可以 进去；
 *3.GUC中有个ReentrantLock
 *4.lock ,无非就是一个类，类里面的一个对象，对象里面记录了有一些信息
 * @author DELL
 *
 */
public class LockTest3 {
	ReLock lock=new ReLock();
	
	public void aaa() throws InterruptedException {
		lock.lock();
		System.out.println("aaa1-->"+lock.getHoldCount());
		bbb();
		lock.unlock();
		System.out.println("aaa2-->"+lock.getHoldCount());
	}
	//不可重入；使用这个锁之后呢，不可释放；
	public void bbb() throws InterruptedException {
		lock.lock();
		System.out.println("bbb1-->"+lock.getHoldCount());
		//....
		lock.unlock();
		System.out.println("bbb2-->"+lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest3 lt=new LockTest3();
		lt.aaa();
		
		Thread.sleep(1000);
		System.out.println("last-->"+lt.lock.getHoldCount());
		
	}
}

//锁，其实就是自己定义的类；类里面有对象而已；
//不可重入锁
class ReLock{
	//是否占用
	private boolean isLocked=false;
	//存储当前线程；
	Thread lockedBy=null;
	//锁的计数器；
	private int holdCount=0;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		//当前线程的引用；
		Thread t=Thread.currentThread();
		//如果当前线程已经占用，且线程不是当前线程-->不是由当前线程锁定，
		//那结果只能是等待；
		//如果当前线程没有被占用或是被自身线程占用，不用等待，直接进行后续操作；
		//进行后续操作后，使用一些标识，进行标记，连续进入；
		while(isLocked&&lockedBy!=t) {
			wait();
		}
		isLocked=true;
		lockedBy=t;
		holdCount++;
		
	}
	//释放锁
	public synchronized void unlock() {
		//什么时候释放锁；
		//当前线程等于自身的时候，释放锁；
		if(Thread.currentThread()==lockedBy) {
			holdCount--;
			if(holdCount==0) {
				isLocked=false;
				notify();
				lockedBy=null;
			}
		}
	}
	public int getHoldCount() {
		return holdCount;
	}
	
	
}
