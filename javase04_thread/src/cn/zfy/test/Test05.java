package cn.zfy.test;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
/**
 * 1��������ͬ����������Ͱ�����
 * @author DELL
 *
 */
public class Test05 {

	public static void main(String[] args) throws InterruptedException{
		
		test5();
		
	}
	
	//����һ����վ��Ʊ��
	//������������ͬʱ����ͬһ���˻���
	//��������������ͬ�����������棻
	public static void test5() throws InterruptedException {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<=10000;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(10000);
		//9996,ֵ��ȷ����
		System.out.println(list.size());
	}
	//ͬ���������ƣ�
	public static void test6() throws InterruptedException {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<=10000;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (list) {
						list.add(Thread.currentThread().getName());
					}
				}
			}).start();
		}
		Thread.sleep(10000);
		//10001 ֵȷ����
		System.out.println(list.size());
	}
	
}
