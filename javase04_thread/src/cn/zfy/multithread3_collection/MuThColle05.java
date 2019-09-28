package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.����������LinkedBlockingQueue��
 * ���ò�ͬ��APU�����ֲ�ͬ�����ԣ�
 * add;
 * put;
 * offer
 * offer(vlaue,int,timeunit);
 * ��ǰ����Ҳ��take������Ҳ�������ģ�
 * @author DELL
 *
 */
public class MuThColle05 {
	final BlockingQueue<String> queue=new ArrayBlockingQueue<>(3);
	
	public static void main(String[] args) {
		final MuThColle05 mt=new MuThColle05();
		for(int i=0;i<5;i++) {
			//Queue full;
			//add ��������ʱ���׳��쳣��
			//System.out.println("add method:"+mt.queue.add("value"+i));
			
			//put����������ʱ�������ȴ���
			try {
				mt.queue.put("put value"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("put method"+i);
			
			//������offer������������������ʱ����false����ǰ�������ݷ�����
			//System.out.println("offer method:"+mt.queue.offer("value"+i));
			
			//�����offer;��������ʱ���ڵ�λʱ���ڣ����������У����������ݣ�����true��
			//�����������Χ�ڣ��������ռ䣬�����������ݣ�����false��
			/*try {
				System.out.println("offer method:"+
				mt.queue.offer("value"+i, 1, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		System.out.println(mt.queue);
	}
}

