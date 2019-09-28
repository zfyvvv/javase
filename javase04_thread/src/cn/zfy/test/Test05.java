package cn.zfy.test;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
/**
 * 1、并发非同步的三大典型案例；
 * @author DELL
 *
 */
public class Test05 {

	public static void main(String[] args) throws InterruptedException{
		
		test5();
		
	}
	
	//案例一：网站抢票；
	//案例二：二人同时操作同一个账户；
	//案例三，并发非同步，容器方面；
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
		//9996,值不确定；
		System.out.println(list.size());
	}
	//同步并发控制；
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
		//10001 值确定；
		System.out.println(list.size());
	}
	
}
