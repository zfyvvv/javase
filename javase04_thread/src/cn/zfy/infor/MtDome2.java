package cn.zfy.infor;
/**
 * 1-�趨�߳����ȼ���������Ǹ��ʣ����Ǿ��Ե����ȼ���Ҳ����˳��
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
