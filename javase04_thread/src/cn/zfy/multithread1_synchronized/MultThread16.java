package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.ͬ������ع�:
 * @author DELL
 *
 */
public class MultThread16 {
	private int num=10;
	void m() {
		while(true) {
			if(num<=0) {
				break;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"get "+ num);
			num--;
		}
	}
	
	public static void main(String[] args) {
		MultThread16 mt16=new MultThread16();
		
		//���ָ�����
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt16.m();
			}
		},"aaa").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt16.m();
			}
		},"bbb").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				mt16.m();
			}
		},"ccc").start();
	}
	
}


