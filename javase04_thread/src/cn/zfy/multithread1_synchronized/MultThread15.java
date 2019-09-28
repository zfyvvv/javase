package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.���ţ�CountDownLatch;
 * ����������Ĳ��ֹ��ܣ����Ժ������ʹ�ã�
 * ����δ����֮ǰ�ȴ�����ȫ����֮��ִ�У�
 * �������ĵ�Ч���⣻
 * 
 * 2.Ӧ��
 * �ܶ��ܵ�Դ���붼��ʹ�����ţ�
 * spring�����classpathXMLContain;
 * ��ʼ����������������ʱ����һ���Ⱥ��˳��
 * ��init���е�properties����init���е�serviceReginsry����init���е�bean��
 * �����notify��Ч��̫�ͣ�
 * ����ʹ�ò�ͬ�����ţ�
 * 
 * 3.ջ��ջ֡
 * ������ɺ󣬴�����е����ã�
 * ջ֡�д���ʱ�������ã����������й�����ָ����еĶ���
 * �������д�ŵ����ֽ���򷽷������룻�����߼������ݣ�
 * ���ݰ�����ʵ���ݺ��������ݣ�
 * ��ʵ������ָ8�ֻ������ͣ�ֱ��ռ���ֽڽ��б��棻���ƶ�����������ջ֡���棻
 * ���������Ǹ�����ʵ�����߳�����Ļ������õ�ջ֡���棨������ջ֡�У���
 * Ȼ���ٰ����ù������ѿռ��У�
 * ��ջִ֡�н����Ժ󣬵�ջ��ȫ�������ˣ������е�����ȫ����ϣ�����ʱ����������ˣ�
 * ����������ջ�кͶ��е����ݲ�����л��գ�
 * @author DELL
 *
 */
public class MultThread15 {
	CountDownLatch latch=new CountDownLatch(5);
	void m1() {
		try {
			//�ȴ����ſ��ţ���ʱ������
			//��countΪ0ʱ���ţ�
			latch.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("m1()....start!");
	}
	void m2() {
		System.out.println("m2.start...");
		for(int i=0;i<10;i++) {
			if(latch.getCount()!=0) {
				System.out.println("latch count-->"+latch.getCount());
				//�������ϵ�����
				latch.countDown();
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2()...."+i);
		}
	}
	
	public static void main(String[] args) {
		MultThread15 mt15=new MultThread15();
		
		//
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt15.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt15.m2();
			}
		}).start();
	}
}


