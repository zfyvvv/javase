package cn.zfy.sleep;
/**
 * 1��ͨ���ⲿ�����������߳����ѭ��ֹͣ��
 *
 * @author DELL
 *
 */
public class StopDome {
	public static void main(String[] args) {
		Study s=new Study();
		new Thread(s).start();
		for(int i=0;i<100;i++) {
			if(50==i) {
				s.stop();
			}
			System.out.println("main....."+i);
		}
	}

}
class Study implements Runnable{
	private boolean flag=true;
	@Override
	public void run() {
		while(flag) {//һ����flag������������
			System.out.println("study..........");
		}
	}
	public void stop() {
		this.flag=false;
	}
	
}
