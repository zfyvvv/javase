package cn.zfy.multithread2_reentrantlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.ThreadLocal
 *������һ��map��key��Thread.currentThread(),  value->�߳���Ҫ����ı�����
 *ThreadLocal.set(value) -> map.put(Thread.currentThread(),value);
 *ThreadLocal.get()      -> map.get(Thread.currentThread());
 *
 *2.�ڴ����⣬�ڲ�������ʱ�������ڴ������
 *ʹ��ThreadLocal��ʱ��һ��ע�������Դ��ÿ���߳̽���֮ǰ��һ��Ҫ����ǰ�̱߳����������Դɾ����
 *ThreadLocal.remove��
 * 
 * @author DELL
 *
 */
public class MuThread08 {
	volatile static String name="zhangsan";
	//���գ�����ָ��null��
	static ThreadLocal<String> tl=new ThreadLocal<>();
	
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//zfy
				System.out.println(name);
				//null,
				System.out.println(tl.get());
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name="zfy";
				tl.set("ltt");
			}
		}).start();
		
		
		
	}
	

}



