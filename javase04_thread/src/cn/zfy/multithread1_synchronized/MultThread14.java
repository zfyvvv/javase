package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized�ؼ���;
 * �������⣻
 * �ڶ���ͬ�������ʱ����Ҫʹ�ó���������Ϊ��Ŀ�����
 * ����Ϊ�Ƕ�����ã���ʵ��ͬһ������
 * 
 * 2.��������������ַ��������ֵȣ�
 * newһ���Ὺ�ٶ��ڴ棬�½�����
 * 
 * @author DELL
 *
 */
public class MultThread14 {
	private String s1="hello";
	private String s2="hello";
	//new�ؼ��֣�һ�����ڶ��д���һ���µĶ���
	private String s3=new String("hello");
	
	//��ʱ����i1��i2���ǿ������еģ�����ͬһ������
	Integer i1=new Integer(1);
	Integer i2=new Integer(1);
	//��ʱ����i3��i4����m2�����ģ���ͬһ������-128~127��
	Integer i3=1;
	Integer i4=	1;	

	void m1() {
		synchronized (s1) {
			System.out.println("m1...");
			while(true) {
			}
		}
	}
	void m2() {
		synchronized (s2) {
			System.out.println("m2...");
			while(true) {
			}
		}
	}
	void m3() {
		synchronized (s3) {
			System.out.println("m3...");
			while(true) {
			}
		}
	}
	
	public static void main(String[] args) {
		MultThread14 mt14=new MultThread14();
		
		//m1��m3�����������У�
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m2();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt14.m3();
			}
		}).start();
	}
	
}


