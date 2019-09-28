package cn.zfy.syn;
/**
 * �̰߳�ȫsynchronized
 * ������Ϊ���ڴ氲ȫ��
 * 1-ͬ����
 *    synchronized����������|this|��.class|��{
 *    ��Ҫͬ���Ŀ�
 *    }
 * 2-ͬ������������ǰ��+synchronized
 * 3��д�����̰߳�ȫ��Ч�ʵ����⣺��Χ����Ч�ʵ��£���Χ��С�����ǲ���ȫ��
 * @author DELL
 *
 */
public class Syn {
	public static void main(String[] args) {
		Num n=new Num();
		Thread t1=new Thread(n);
		Thread t2=new Thread(n);
		Thread t3=new Thread(n);
		t1.setName("zfy");
		t2.setName("lt");
		t3.setName("momo");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Num implements Runnable{
	private int num=10;
	private boolean flag=true;
	
	@Override
	public void run() {
		while(flag) {
			//����ȫ
			//text1();
			//������������ȫ��
			//text2();
			//�����飬��ȫ�����洫�Ķ���Ϊthis;һ����ֻ�г���һ����Դ��
			//text3();
			//�����飬����ȫ�����洫�Ķ���Ϊnum�������һ�����ԣ����Ķ���̫С��
			//text4();
			//�����飬����ȫ�����洫�Ķ���Ϊthis�����ķ�Χ��խ��ͬ�����������num�飬Ҳ�ǹ�խ��
			text5();
			//д�����̰߳�ȫ��Ч�ʵ����⣺��Χ����Ч�ʵ��£���Χ��С�����ǲ���ȫ��
		}
	}
	
	public void text1() {//����ȫ
		if(num<=0) {
			flag=!flag;
			return ;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+num--);
		
	}
	
	public synchronized void text2() {//��ȫ,�������Ƿ�����
		if(num<=0) {
			flag=!flag;
			return ;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+num--);
		
	}
	
	public void text3() {//��ȫ,
		 synchronized(this) {//������봫�������ͣ�����Ϊ����
			if(num<=0) {
				flag=!flag;
				return ;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+num--);
			
	}}
	
	public void text4() {//��ȫ,
		 synchronized((Integer)num) {//����Ϊ�������ͣ�����Ϊ�������ͣ�
			if(num<=0) {
				flag=!flag;
				return ;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+num--);
			
	}}
	
	public void text5() {//��ȫ,
		//������봫�������ͣ�����Ϊ���󣻵���ʱ��Χ������if��䣻
		 synchronized(this) {
			if(num<=0) {
				flag=!flag;
				return ;
			}}
		 
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+num--);
			
	}
}