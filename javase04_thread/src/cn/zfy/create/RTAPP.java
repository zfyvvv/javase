package cn.zfy.create;

/**\
 * 1-�����̳�Thread��Ķ���
 * 2-���ö����start()������������run()������
 * 3��run()Ϊ��д����Ҫ��ִ���巽������������run()�����ķ����Ǹ����start()������
 * @author DELL
 *
 */

public class RTAPP {
	public static void main(String[] args) {
		Rabbit ra=new Rabbit();//�½����Ӷ���
		Tortoise to=new Tortoise();//�½��ڹ����
		
		ra.start();//����׼���ܣ�����ʲôʱ���ܿ�CPU�ĵ��ȣ�
		to.start();//�ڹ�׼���ܣ�Ҳ��CPU�ĵ��ȣ��������ra.run()��������ֻ��һ��·����
		
		for(int i=0;i<=10;i++) {
			System.out.println("main������"+i+"��");//mian����Ҳ׼�����ˣ��ȴ�CPU�ĵ��ȣ�
		}
		
	}

}

/**
 * 1-�̳�Thread�࣬��дrun()������
 *
 * @author DELL
 *
 */
class Rabbit extends Thread {
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("���ӣ�"+i+"��");
		}
		super.run();
	}
}

class Tortoise extends Thread {
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("�ڹ꣺"+i+"��");
		}
		super.run();
	}
}


