package cn.zfy.cooperation;
/**
 * 1.ģ���ͻ��û��ʹ���źŵƷ�+synchronized������car��power���ָ�����
 * @author DELL
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Car car=new Car(0);
	
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10;i++) {
					car.consum();
					}
				}
			}).start();
	
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10;i++) {
					car.product();
					}
				}
			}).start();
	}
}

class Car{
	private int power;
	
	public Car(int power) {
		this.power=power;
	}
	public void product() {
		power++;
		System.out.println("power product 1->"+power);
		
	}
	public synchronized void consum() {
		power--;
		System.out.println("power consum 1->"+power);
	}
	
}
