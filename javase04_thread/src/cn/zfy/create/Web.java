package cn.zfy.create;
/**
 * �Ƽ�Runnable�����߳�
 * 1-���ⵥ�̳еľ����ԣ�
 * 2-���㹲����Դ��ģ��12306��Ʊ����
 * 
 * ʹ�ã�
 * 1-������ʵ�࣬ʵ��Runnabl�ӿڣ�
 * 2-ʹ��Thread()���������ʵ��ɫ�Ĵ���
 * 3-����.start()��ʽ�������̣߳�ִ��run()������
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
			System.out.println(Thread.currentThread().getName()+"�����ˣ�"+num--);
		}
	}
	
	public static void main(String[] args) {
		Web w=new Web();
		//ThreadΪ����t.startΪThread�ķ���������ִ�е�����ʵ����WEB�ķ�����
		//����Threadʱ���Ѿ�����ʵw���󴫵ݸ�Thread��
		Thread t1=new Thread(w,"·�˼�");
		Thread t2=new Thread(w,"·����");
		Thread t3=new Thread(w,"·�˱�");
		t2.start();
		t1.start();
		t3.start();
	}


	
}

