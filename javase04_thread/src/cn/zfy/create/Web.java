package cn.zfy.create;
/**
 * 推荐Runnable创建线程
 * 1-避免单继承的局限性；
 * 2-方便共享资源；模拟12306抢票！！
 * 
 * 使用：
 * 1-创建真实类，实现Runnabl接口；
 * 2-使用Thread()代理，添加真实角色的代理；
 * 3-调用.start()方式，启动线程；执行run()方法；
 * 
 * @author DELL
 *
 */
public class Web implements Runnable {
	private int num=500;
	@Override
	public void run() {
		while(true) {
			if(num<0) {
			break;
			}
			System.out.println(Thread.currentThread().getName()+"抢到了："+num--);
		}
	}
	
	public static void main(String[] args) {
		Web w=new Web();
		//Thread为代理，t.start为Thread的方法，但是执行的是真实对象WEB的方法；
		//创建Thread时，已经把真实w对象传递给Thread；
		Thread t1=new Thread(w,"路人甲");
		Thread t2=new Thread(w,"路人乙");
		Thread t3=new Thread(w,"路人丙");
		t2.start();
		t1.start();
		t3.start();
	}


	
}

