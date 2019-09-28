package cn.zhoufy.gof.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * 1.���Ե���ģʽ�Ƿ���Ч
 * @author DELL
 *
 */
public class Cilent {
	
	public static void main(String[] args) {
		test01();
		
	}
	// 1.���Ե���ģʽ�Ƿ���Ч
	public static void test01() {
		SingletonDome1 s1=SingletonDome1.getInstance();
		SingletonDome1 s2=SingletonDome1.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(SingletonDome5.INSTANCE.equals(SingletonDome5.INSTANCE));
	}
	
	
	//1.����5�ֵ���ģʽ��Ч�ʣ�
	public static void test02() throws Exception {
		long start=System.currentTimeMillis();
		int threadNum=10;
		CountDownLatch countDownLatch=new CountDownLatch(threadNum);
		for(int i=0;i<threadNum;i++) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100000;i++) {
					//Object o=SingletonDome2.getInstance();
					Object o=SingletonDome5.INSTANCE;
				}
				countDownLatch.countDown();
			}
		}).start();
		}
		countDownLatch.await();
		
		long end=System.currentTimeMillis();
		System.out.println("�ܺ�ʱ��"+(end-start));
	}
	
	// 1.ʹ�÷���ͷ����л��ƽⵥ��ģʽ��ö������⣩��
	// 2.��ȡ��Ӧ��ʩ��ֹ�ƽ������
	public static void test03() throws Exception {
		SingletonDome6 s1=SingletonDome6.getInstance();
		SingletonDome6 s2=SingletonDome6.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//ͨ������ķ�ʽֱ�ӵ���˽�й��������ƽⵥ��ģʽ��
		/*Class<SingletonDome6> clazz=(Class<SingletonDome6>)Class.forName("cn.zhoufy.gof.singleton.SingletonDome6");
		System.out.println(clazz);
		Constructor<SingletonDome6> c=clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDome6 s1=c.newInstance();
		SingletonDome6 s2=c.newInstance();
		System.out.println(s1);//��������
		System.out.println(s2);//��������*/
		
		//ͨ�������л��ķ�ʽ�ƽⵥ��ģʽ��
		FileOutputStream fos=new FileOutputStream("F:/mycode/a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		//��д��oos�У�oosֱ��д��fos�У�fosд��a.txt�У�
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("F:/mycode/a.txt"));
		SingletonDome6 s3=(SingletonDome6) ois.readObject();
		System.out.println(s3);
		//s1��s2��ͬһ�����󣬵���s3������ ��һ������
		//�޸�֮����������ͬһ������
	}

	
}
