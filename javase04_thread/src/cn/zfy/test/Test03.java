package cn.zfy.test;
/**
 * 1����ͬһ��������synchronized���Ķ�������ͬʱ���������ʱ����������������
 *    test3()->��ʱͨ������synchronized���ķ�Χ����Ч�Խ���ȷ�ϣ��ۺϿ��ǰ�ȫ��Ч�ʣ�
 *    
 * 2��������̷߳���ͬһ����Դʱ��Ҳ��������������
 *    test4()->����ʹ��ָʾ�Ʒ���
 * 
 * @author DELL
 *
 */

/**
 * 1������������
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
 * 1��Ա��1������ԣ����������ԣ�
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
 * 1��Ա��2�����ֻ������ȸ��ֻ�������
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