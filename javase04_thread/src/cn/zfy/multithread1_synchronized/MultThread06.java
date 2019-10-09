package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized�ؼ���
 *ͬ������-��������ͬ��������
 *�������룬ͬһ���̣߳���ε���ͬ�����룬����ͬһ�������󣬿����룻
 *��������������ʵ����һ����ǣ�
 *���߳�����ͬһ�����󣬲������룻
 *
 * @author DELL
 *
 */
public class MultThread06 {
	
	public synchronized void m1() {
		System.out.println("m1 start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end!");
	}
	
	public synchronized  void m2() {
		System.out.println("m2 start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2 end!");
		
	}
	
	public static void main(String[] args) {
		MultThread06 mt6 = new MultThread06();
		mt6.m1();

	}
}
