package cn.zfy.create;

/**
 * �Ƽ�Runnable�����߳�
 * 1-���ⵥ�̳еľ����ԣ�
 * 2-���㹲����Դ��
 * 
 * ʹ�ã�
 * 1-������ʵ�࣬ʵ��Runnabl�ӿڣ�
 * 2-ʹ��Thread()���������ʵ��ɫ�Ĵ���
 * 3-����.start()��ʽ�������̣߳�
 * 
 * @author DELL
 *
 */
public class ProAPP {

	public static void main(String[] args) {
		Pragrammer p=new Pragrammer();
		//Pragrammer�������̣߳�
		Thread t=new Thread(p);
		t.start();;
		//main�������̣߳�
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
