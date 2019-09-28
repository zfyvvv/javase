package cn.zhoufy.gof.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * 1.测试单例模式是否有效
 * @author DELL
 *
 */
public class Cilent {
	
	public static void main(String[] args) {
		test01();
		
	}
	// 1.测试单例模式是否有效
	public static void test01() {
		SingletonDome1 s1=SingletonDome1.getInstance();
		SingletonDome1 s2=SingletonDome1.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(SingletonDome5.INSTANCE.equals(SingletonDome5.INSTANCE));
	}
	
	
	//1.测试5种单例模式的效率！
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
		System.out.println("总耗时："+(end-start));
	}
	
	// 1.使用反射和反序列化破解单例模式（枚举类除外）；
	// 2.采取相应措施防止破解产生；
	public static void test03() throws Exception {
		SingletonDome6 s1=SingletonDome6.getInstance();
		SingletonDome6 s2=SingletonDome6.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//通过反射的方式直接调用私有构造器，破解单例模式！
		/*Class<SingletonDome6> clazz=(Class<SingletonDome6>)Class.forName("cn.zhoufy.gof.singleton.SingletonDome6");
		System.out.println(clazz);
		Constructor<SingletonDome6> c=clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDome6 s1=c.newInstance();
		SingletonDome6 s2=c.newInstance();
		System.out.println(s1);//两个对象！
		System.out.println(s2);//两个对象！*/
		
		//通过反序列化的方式破解单例模式；
		FileOutputStream fos=new FileOutputStream("F:/mycode/a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		//是写到oos中，oos直接写到fos中，fos写到a.txt中；
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("F:/mycode/a.txt"));
		SingletonDome6 s3=(SingletonDome6) ois.readObject();
		System.out.println(s3);
		//s1和s2是同一个对象，但是s3是另外 的一个对象！
		//修改之后，三个都是同一个对象！
	}

	
}
