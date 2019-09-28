package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.AtomicXxx;
 * ͬ�����ͣ�
 * ԭ�Ӳ������ͣ����е�ÿ����������ԭ�Ӳ��������Ա�֤�̰߳�ȫ��
 * @author DELL
 *
 */
public class MultThread11 {
	AtomicInteger count=new AtomicInteger(0);
	void m() {
		for(int i=0;i<1000;i++) {
			count.incrementAndGet();
		}
	}
	public static void main(String[] args) {
		MultThread11 mt10=new MultThread11();
		List<Thread> Threads=new ArrayList<Thread>();
		for(int i=0;i<10;i++) {
			Threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					mt10.m();
				}
			}));
		}
		for(Thread thread:Threads) {
			thread.start();
		}
		
		for(Thread thread:Threads) {
			try {
				//���߳�����������
				//��main����join�����󣬽������߳�����������
				//���Է��̵߳Ľ�����ӵ���ǰ�̵߳ĵ�ǰλ���ϣ�
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//9157,��������10000
		System.out.println(mt10.count);
	}
}


