package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.����������LinkedBlockingQueue��
 * �Զ�������
 * ���Queue��������
 * put&take �Զ�������
 * put�Զ��������������������Զ�������
 * take�Զ�������������������Ϊ0���Զ�������
 * @author DELL
 *
 */
public class MuThColle04 {
	final LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>();
	final Random r=new Random();
	public static void main(String[] args) {
		final MuThColle04 mt=new MuThColle04();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						mt.queue.put("value"+mt.r.nextInt(10000));
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		},"producer").start();
		
		for(int i=0;i<3;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true) {
						try {
							System.out.println(Thread.currentThread().getName()+
									"-"+mt.queue.take());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			},"consumer"+i).start();
		}

	}
}

