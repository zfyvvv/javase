package cn.zfy.cooperation;
/**
 * 1.模拟冲突，使用信号灯法；
 * @author DELL
 *
 */
public class Test {
	public static void main(String[] args) {
		People people = new People(0);
	
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10;i++) {
					people.consum();
					}
				}
			}).start();
	
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10;i++) {
					people.product();
					}
				}
			}).start();
		
	}
}

class People{
	private int power;
	
	public People(int power) {
		this.power=power;
	}
	
	public synchronized void product() {
		if(power>=1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		power++;
		System.out.println("power product 1->"+power);
		this.notify();
		
	}
	public synchronized void consum() {
		if(power==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		power--;
		System.out.println("power consum 1->"+power);
		this.notify();
	}
	
}
