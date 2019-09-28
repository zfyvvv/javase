package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized�ؼ���
 *ͬ������-�쳣
 *
 * @author DELL
 *
 */
public class MultThread08 {
	int i=0;
	
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+"-->start!");
		while(true) {
			i++;
			System.out.println(Thread.currentThread().getName()+"-->i-->"+i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�����쳣��
			//�����쳣�ͷ�����ʵ��ҵ���и���ͽ����
			if(5==i) {
				i=i/0;
			}
			
			//���������
	/*		try {
				if(5==i) {
					i=i/0;
				}
			} catch (Exception e) {
				// TODO: handle exception
				i=0;
			}*/
			
		}
		
	}
	
	public static void main(String[] args) {
		MultThread08 mt8=new MultThread08();
		new Thread(()-> {
			mt8.m();
		},"t1").start();
		//t1��i=5���׳��쳣���ͷ�����
		//t2����i=6�������У�
		new Thread(()-> {
			mt8.m();
		},"t2").start();

	}
}


