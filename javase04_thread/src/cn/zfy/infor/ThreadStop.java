package cn.zfy.infor;
/**
 * 1��ͨ��flag�����̵߳Ĺرգ������ǵ��÷�����
 * @author DELL
 *
 */
public class ThreadStop implements Runnable {
	private int num;
	private boolean flag=true;
	
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+"--->"+num++);
		}
	}
	public void stop() {
		this.flag=!this.flag;
	}

}
