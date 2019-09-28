package cn.zfy.lock;
/**
 * 1.不可重入锁：锁不可以延续使用；
 * @author DELL
 *
 */
public class LockTest2 {
	Lock lock=new Lock();
	
	public void aaa() throws InterruptedException {
		lock.lock();
		bbb();
		lock.unlock();
	}
	//不可重入；使用这个锁之后呢，不可释放；
	public void bbb() throws InterruptedException {
		lock.lock();
		//....
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest2 lt=new LockTest2();
		lt.aaa();
		lt.bbb();
		
	}
}

//锁，其实就是自己定义的类；类里面有对象而已；
//不可重入锁
class Lock{
	//是否占用
	private boolean isLocked=false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked=true;
		
	}
	//释放锁
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
	
}
