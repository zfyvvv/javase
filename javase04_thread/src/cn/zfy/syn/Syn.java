package cn.zfy.syn;
/**
 * 线程安全synchronized
 * 本质是为了内存安全；
 * 1-同步块
 *    synchronized（引用类型|this|类.class|）{
 *    需要同步的块
 *    }
 * 2-同步方法：方法前面+synchronized
 * 3、写代码线程安全与效率的问题：范围过大，效率低下；范围过小，还是不安全；
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
			//不安全
			//text1();
			//锁定方法，安全；
			//text2();
			//锁定块，安全；里面传的对象为this;一个人只有持有一个资源！
			//text3();
			//锁定块，不安全；里面传的对象为num，对象的一个属性；传的对象太小，
			//text4();
			//锁定块，不安全；里面传的对象为this，锁的范围过窄！同理锁定后面的num块，也是过窄！
			text5();
			//写代码线程安全与效率的问题：范围过大，效率低下；范围过小，还是不安全；
		}
	}
	
	public void text1() {//不安全
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
	
	public synchronized void text2() {//安全,锁定的是方法；
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
	
	public void text3() {//安全,
		 synchronized(this) {//里面必须传引用类型，锁定为对象；
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
	
	public void text4() {//安全,
		 synchronized((Integer)num) {//不可为基本类型，必须为引用类型；
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
	
	public void text5() {//安全,
		//里面必须传引用类型，锁定为对象；但此时范围仅限于if语句；
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