package cn.zfy.sleep;
/**
 * �ϲ��̣߳����ϲ����߳�����������ɣ�
 * @author DELL
 *
 */
public class JoinDome extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDome jd=new JoinDome();
		Thread t=new Thread(jd);
		t.start();
		//��ǰ�߳�ִ�еķ�����
		for(int i=0;i<500;i++) {
			if(100==i) {
				//��t���̺߳ϲ���main�߳���ȥ��ֻ�е�t�߳������꣬�Ż�����main�̣߳�������֮ǰ��cpu������䣡
				t.join();
				//Thread.yield();�����ĸ��߳����棬�����谭�ĸ��̣߳������谭֮��ʲôʱ�����У��Ϳ�cpu�ĵ��ȣ�
			}
			System.out.println("mian......."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<500;i++) {
			System.out.println("run......."+i);
		}
		super.run();
	}

}
