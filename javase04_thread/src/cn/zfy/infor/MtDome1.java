package cn.zfy.infor;
/**
 * 1-设定线程名字；
 * 2-获得线程名字；
 * 3-打印当前线程名字；
 * 4-判断线程是否还活在；
 * @author DELL
 *
 */
public class MtDome1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadStop mt=new ThreadStop();
		Thread t=new Thread(mt);
		//Thread t=new Thread(mt,"zfy");//设定线程名字1
		t.setName("zfy");//设定线程名字2
		System.out.println(t.getName());//获得线程t的名字；
		System.out.println(Thread.currentThread().getName());//mian线程名字；
		System.out.println("1111111"+t.isAlive());//判断线程是否还还运行；false
		t.start();
		System.out.println("2222222"+t.isAlive());//true
		t.sleep(200);
		mt.stop();
		System.out.println("3333333"+t.isAlive());//true
		t.sleep(200);//程序需要一定的延时时间，
		System.out.println("3333333"+t.isAlive());//false
	}

}
