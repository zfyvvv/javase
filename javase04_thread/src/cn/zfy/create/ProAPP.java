package cn.zfy.create;

/**
 * 推荐Runnable创建线程
 * 1-避免单继承的局限性；
 * 2-方便共享资源；
 * 
 * 使用：
 * 1-创建真实类，实现Runnabl接口；
 * 2-使用Thread()代理，添加真实角色的代理；
 * 3-调用.start()方式，启动线程；
 * 
 * @author DELL
 *
 */
public class ProAPP {

	public static void main(String[] args) {
		Pragrammer p=new Pragrammer();
		//Pragrammer方法的线程；
		Thread t=new Thread(p);
		t.start();;
		//main方法的线程；
		for(int i=0;i<=10;i++) {
			System.out.println("main:"+i);
		}
		
	}

}


class Pragrammer implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Programmer:"+i);
		}
	}
}
