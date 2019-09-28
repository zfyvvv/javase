package cn.zhoufy.gof.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 1.����ģʽ-����ʽ
 * @author DELL
 *
 */
public class SingletonDome1 {
	//˽�л���̬��һ��ʵ������ʼ��ʱ���½����һ������û����ʱ���أ�
	private static SingletonDome1 instance=new SingletonDome1();
	//������˽�л���
	private SingletonDome1() {
	}
	//�ṩ����Ļ�ö���ķ�����
	public static SingletonDome1 getInstance() {
		return instance;
	}
}


/**
 * 2.����ģʽ-����ʽ
 * @author DELL
 *
 */
class SingletonDome2 {
	//˽�л���̬��һ��ʵ������ʼ��ʱ���½����һ��������ʱ���أ�
	private static SingletonDome2 instance;
	//������˽�л���
	private SingletonDome2() {
	}
	//�ṩ����Ļ�ö���ķ���������ͬ��������֤�̰߳�ȫ
	public static synchronized SingletonDome2 getInstance() {
		if(instance==null) {
			instance=new SingletonDome2();
		}
		return instance;
	}
}


/**
 * 3.����ģʽ-˫�ؼ����ʵ��
 * @author DELL
 *
 */
class SingletonDome3 {
	//˽�л���̬��һ��ʵ������ʼ��ʱ���½����һ��������ʱ���أ�
	private static SingletonDome3 instance=null;
	//������˽�л���
	private SingletonDome3() {
	}
	//�ṩ����Ļ�ö���ķ�����������ͬ������������Ŀ�ͬ����
	public static synchronized SingletonDome3 getInstance() {
		if(instance==null) {
			SingletonDome3 sd;
			//��ͬ���������·ŵ�if�ڲ�������ͬ�������飬���ִ��Ч�ʣ�
			synchronized(SingletonDome3.class) {
			sd=instance;
			//��һ�δ���ʱ��Ҫͬ������������Ҫ��
			synchronized(SingletonDome3.class) {
			if(sd==null) {
				//���ڱ������Ż���JVM�ڲ�ԭ��ż�������⣬������ʹ�ã�
				sd=new SingletonDome3();
			}}
			instance=sd;
		}}
		return instance;
	}
}

/**
 * 4.����ģʽ-��̬�ڲ���ʵ�ַ�ʽ��Ҳ��һ�������أ�
 * @author DELL
 *
 */
class SingletonDome4 {
	//�ⲿ��û��static���ԣ����������ʽ�����������أ�
	//ֻ������ʹ��getinstance()�Ż���أ���ʱ���أ������̰߳�ȫ��
	//������static final����ֻ��һ��ʵ�����ҿ��Ը�ֵһ�Σ����̰߳�ȫ��
	//����и�Ч���ú���ʱ���ص����ƣ�
	private static class SingletonClassInstance{
		private static final SingletonDome4 instance =new SingletonDome4();
	}  
	private SingletonDome4() {
	}
	//��þ�̬�ڲ����һ������-����Ҫ�Ķ���
	public static synchronized SingletonDome4 getInstance() {
		return SingletonClassInstance.instance;
	}
}


/**
 * 5.����ģʽ-ö����
 * @author DELL
 *
 */
enum SingletonDome5 {
	//ö�ٱ������һ������Ч�ʸ��ҷ��䰲ȫ��û����ʱ���أ�ȱ�㣩
	INSTANCE;
	//�Լ����嵥���Ĳ�����
	public void singletonOperator() {
		
	}
}


/**
 * 1.����ģʽ-����ʽ
 * 2�������ƽ⣻
 * @author DELL
 *
 */
class SingletonDome6 implements Serializable {
	
	private static SingletonDome6 instance;
	private SingletonDome6() {
		//�������ʱ�������ƻ���
		if(instance!=null) {
			throw new RuntimeException();
		}
	}
	public static synchronized SingletonDome6 getInstance() {
		if(instance==null) {
			instance=new SingletonDome6();
		}
		return instance;
	}
	//�����л�����ʱ����ֹ�ƻ�
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}

