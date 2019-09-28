package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.volatile�ؼ���
 *�ɼ��ԣ��ڴ�Ŀɼ��ԣ�ÿ�η��ʱ����ǣ�����Ҫȥ�ڴ����濴��
 *CPU�����Լ��Ļ��棻
 *֪ͨOS����ϵͳ�ײ㣬��CPU��������У����м���ڴ������ݵ���Ч�ԣ���֤���µ��ڴ�����ʹ�ã�
 *
 * @author DELL
 *
 */
public class MultThread09 {
	//����֮���߳̿���ͣ������
	//���ӣ��߳�һ��ѭ����b��ֵһ��Ϊtrue��
	
	/*volatile*/ boolean b=true;
	
	void m() {
		System.out.println("strat!");
		while(b) {
		}
		System.out.println("end!");
		
	}
	
	public static void main(String[] args) {
		MultThread09 mt9=new MultThread09();
		new Thread(()-> {
			mt9.m();
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����������ڴ�����ģ�
		mt9.b=false;

	}
}


