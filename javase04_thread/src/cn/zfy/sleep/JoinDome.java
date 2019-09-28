package cn.zfy.sleep;
/**
 * 合并线程，被合并的线程优先运行完成；
 * @author DELL
 *
 */
public class JoinDome extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDome jd=new JoinDome();
		Thread t=new Thread(jd);
		t.start();
		//当前线程执行的方法；
		for(int i=0;i<500;i++) {
			if(100==i) {
				//把t的线程合并到main线程中去，只有当t线程运行完，才会运行main线程，而不是之前的cpu随机分配！
				t.join();
				//Thread.yield();放在哪个线程里面，就是阻碍哪个线程；但是阻碍之后，什么时候运行，就靠cpu的调度；
			}
			System.out.println("mian......."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<500;i++) {
			System.out.println("run......."+i);
		}
		super.run();
	}

}
