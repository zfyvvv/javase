package cn.zfy.infor;
/**
 * 1-�趨�߳����֣�
 * 2-����߳����֣�
 * 3-��ӡ��ǰ�߳����֣�
 * 4-�ж��߳��Ƿ񻹻��ڣ�
 * @author DELL
 *
 */
public class MtDome1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadStop mt=new ThreadStop();
		Thread t=new Thread(mt);
		//Thread t=new Thread(mt,"zfy");//�趨�߳�����1
		t.setName("zfy");//�趨�߳�����2
		System.out.println(t.getName());//����߳�t�����֣�
		System.out.println(Thread.currentThread().getName());//mian�߳����֣�
		System.out.println("1111111"+t.isAlive());//�ж��߳��Ƿ񻹻����У�false
		t.start();
		System.out.println("2222222"+t.isAlive());//true
		t.sleep(200);
		mt.stop();
		System.out.println("3333333"+t.isAlive());//true
		t.sleep(200);//������Ҫһ������ʱʱ�䣬
		System.out.println("3333333"+t.isAlive());//false
	}

}
