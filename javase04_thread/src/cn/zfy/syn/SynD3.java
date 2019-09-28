package cn.zfy.syn;
/**
 * 1-����̶߳�ͬһ����Դ���з��ʣ����ܻ����������
 * 2-�����߳�ͬʱ���ͷ���Դ�����������
 * 3-�����ͬ�������������������
 * @author DELL
 *
 */
public class SynD3 {
	public static void main(String[] args) {
		Object g=new Object();
		Object m=new Object();
		
		//����������У�
		Test t1=new Test(g,m);
		Test2 t2=new Test2(g,m);
		Thread th1=new Thread(t1);
		Thread th2=new Thread(t2);
		th1.start();
		th2.start();
		
		//����һֱ�ȴ����ȴ��˴��ͷ������޷��������У�
		Test3 t3=new Test3(g,m);
		Test4 t4=new Test4(g,m);
		Thread th3=new Thread(t3);
		Thread th4=new Thread(t4);
		th3.start();
		th4.start();
		
		
	}

}

class Test implements Runnable{
	private Object goods;
	private Object money;
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	
	@Override
	public void run() {
		while(true) {
			text();
		}
	}
	
	public void text() {
		//synchronized(goods) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(money) {
			};
		//}
		System.out.println("һ�ָ�Ǯ.........");
	}
}


class Test2 implements Runnable{
	private Object goods;
	private Object money;
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true) {
			text();
		}
	}
	public void text() {
		//synchronized(money) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(goods) {
			};
		//}
		System.out.println("һ�ָ���.........");
	}
}

class Test3 implements Runnable{
	private Object goods;
	private Object money;
	
	public Test3(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	
	@Override
	public void run() {
		while(true) {
			text();
		}
	}
	
	public void text() {
		synchronized(goods) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(money) {
			};
		}
		System.out.println("һ�ָ�Ǯ.........");
	}
}


class Test4 implements Runnable{
	private Object goods;
	private Object money;
	public Test4(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true) {
			text();
		}
	}
	public void text() {
		synchronized(money) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(goods) {
			};
		}
		System.out.println("һ�ָ���.........");
	}
}
