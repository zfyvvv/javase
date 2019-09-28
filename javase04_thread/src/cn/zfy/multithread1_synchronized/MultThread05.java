package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized�ؼ���
 *ͬ������-�෽�����õ�ԭ�������⣻
 *ͬ������ֻ�ܱ�֤��ǰ������ԭ�������⣬���ܱ��϶��ҵ�񷽷�֮��Ļ�����ʵ�ԭ���ԡ�
 *ע������ҵ�����У��෽��Ҫ��ṹ����ԭ�Ӳ�������Ҫ���������������������ͬһ����Դ��
 *
 * һ����˵����ҵ��Ŀ�У�������ҵ���߼��ϵ�������⣬ֻ��ע���ݿ�����������⣻
 *
 * @author DELL
 *
 */
public class MultThread05 {
	private double d=0.0;
	public synchronized void m1(double d) {
		//���ע�ͣ����δ�ӡ�Ľ������200��
		//�����ע�ͣ����δ�ӡ�Ľ����ͬ�������ݣ�
		//�൱�ڸ��ӵ�ҵ���߼����룻ִ����Ҫһ����ʱ�䣻
/*		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.d=d;
	}
	public  double m2() {
		return this.d;
	}
	
	public static void main(String[] args) {
		 final MultThread05 mt5 = new MultThread05();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt5.m1(200);
			}
		}).start();
		
		//������Ҫ�Ľ���ǣ�200��200����Ϊ�Ѿ�����һ���߳�ȥsetֵ��
		//��ʵ�ʽ���ǣ�0��200
		//��m1�е�˯��ɾ�����ܿ���û��������⣻
		System.out.println(mt5.m2());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mt5.m2());
	}
}
