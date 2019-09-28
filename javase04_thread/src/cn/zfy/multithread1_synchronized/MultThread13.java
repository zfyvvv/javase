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
 * �����Ƕ��󣬲������ã�
 * �������������󣬴�ӡ����ͬһ������
 * ��ӡ����Ҫͨ������MultThread13��ȥ��ӡ�ģ�
 * ͨ��MultThread13�����ã�ȥ��ӡ;
 * ��ӡ��Զ������this.o;������Զ����this,����this.o��
 * ��������ʱ���Ѿ�ָ����ǰһ�����󣻵�new�������ǣ����û���o�����Ƕ���ȴ���ˣ�
 * 
 * 2.�����������⣻
 * ͬ������һ����������ô����һ����ʱ��������ָ�������󣬺���ʵ��������ֱ�ӹ�����
 * ����δ�ͷ�֮ǰ���޸����������ã�����Ӱ��ͬ�������ִ�У�
 * 
 * @author DELL
 *
 */
public class MultThread13 {
	Object o=new Object();
	
	int i=0;
	int a() {
		try {
			/*
			 * return i->
			 * int _returnValue=i;//0,java����ʱ�������������ʱ������
			 * return _returnValue;
			 * 
			 */
			return i;
		} finally {
			i=10;
		}
	}
	
	
	
	void m(){
		synchronized (o) {
			System.out.println(Thread.currentThread().getName()+"-->start!");
			while(true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"-->"+o);
			}
		}
	}
	
	public static void main(String[] args) {
		MultThread13 mt13=new MultThread13();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				mt13.m();
			}
		},"t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t1һֱ���У�
		//Object o=new Object();
		//t1��t2�������У�
		//�����Ƕ��󣬲������ã�
		mt13.o=new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt13.m();
			}
		},"t2").start();
		
		//0,0,10
		System.out.println(mt13.i);
		System.out.println(mt13.a());
		System.out.println(mt13.i);
	}
	
}


