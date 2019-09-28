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
 * ͬ���������⣻
 * ��������ҵ�����б���ͬ��������ʹ��ͬ������飻ϸ���Ƚ��ͬ�����⣬��߿���Ч�ʣ�
 * 
 * @author DELL
 *
 */
public class MultThread12 {
	
	synchronized void m1(){
		//ǰ���߼�
		System.out.println("ͬ���߼�");
		//�����߼�
	}
	
	//m2Ҫ����m1��ֻ����ͬ���߼���
	void m2(){
		//ǰ���߼�
		synchronized (this) {
			System.out.println("ͬ���߼�");
		}
		//�����߼�
	}
}


