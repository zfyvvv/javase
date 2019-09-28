package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.volatile�ؼ���
 *�ɼ��ԣ��ڴ�Ŀɼ��ԣ�ÿ�η��ʱ����ǣ�����Ҫȥ�ڴ����濴��
 *���Ǽ������⣬ֻ���ڴ����ݿɼ���
 *
 *
 * @author DELL
 *
 */
public class MultThread10 {
	
	volatile int count=0;
	//����synchronized��Ϊ10000
	/*synchronized*/ void m() {
		for(int i=0;i<1000;i++) {
			count++;
		}
	}
	public static void main(String[] args) {
		MultThread10 mt10=new MultThread10();
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


