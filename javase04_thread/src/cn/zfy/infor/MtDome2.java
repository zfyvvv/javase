package cn.zfy.infor;
/**
 * 1-设定线程优先级：代表的是概率，不是绝对的优先级，也不是顺序；
 * 2-MAX_Priority    10
 *   NORM_Priority    5
 *   MIN_Priority    1
 * @author DELL
 *
 */
public class MtDome2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadStop mt=new ThreadStop();
		Thread t=new Thread(mt,"zfy");
		
		ThreadStop mt2=new ThreadStop();
		Thread t2=new Thread(mt2,"lt");
		t.setPriority(5);
		t2.setPriority(1);
		t.start();
		t2.start();
		Thread.sleep(100);
		mt.stop();
		mt2.stop();
		
	}

}
