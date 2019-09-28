package cn.zfy.test;
/**
 * 1、当同一个方法中synchronized锁的对象过多或同时锁多个对象时，会出现死锁情况；
 *    test3()->此时通过控制synchronized锁的范围和有效性进行确认；综合考虑安全和效率；
 *    
 * 2、当多个线程访问同一个资源时，也会造成死锁情况；
 *    test4()->可以使用指示灯法；
 * 
 * @author DELL
 *
 */

/**
 * 1、测试死锁；
 * @author DELL
 *
 */
public class Test03 {
	
	public static void main(String[] args) {
		work1 w1=new work1("dell", "xiaomi");
		new Thread(w1).start();
		
//		work2 w2=new work2("dell", "xiaomi");
//		new Thread(w2).start();
	}
}


/**
 * 1、员工1先玩电脑，故先锁电脑；
 * @author DELL
 *
 */
class work1 implements Runnable{
	private String computer;
	private String phone;
	
	
	public work1(String computer, String phone) {
		super();
		this.computer = computer;
		this.phone = phone;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			playComp();
		}
	}
	
	
	public void playComp() {
		synchronized (computer) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (phone) {
				
			}
		}
		System.out.println("play computer!");
	}
}

/**
 * 1、员工2先玩手机，故先给手机上锁；
 * @author DELL
 *
 */
class work2 implements Runnable{
	private String computer;
	private String phone;
	
	
	public work2(String computer, String phone) {
		super();
		this.computer = computer;
		this.phone = phone;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			playPhon();
		}
	}
	
	public void playPhon() {
		synchronized (phone) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (computer) {
				
			}
		}
		System.out.println("play phone!");
	}
}