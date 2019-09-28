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
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.����������LinkedTransferQueue��
 * ת�ƶ��У�
 * �ö���û���������ȱ���ֱ�ӹ���ʹ�ã�
 * �൱��һ����ʱ��̨��
 * add-���лᱣ�����ݣ����������ȴ���
 * transfer-TransferQueue�����з����������������ߣ�take�����ĵ����ߣ�
 * ���û�������߳��������ݣ�transfer����������һ�����ڴ���ʱ��Ϣ��
 * 2.TransferQueue��һ�����transferʹ�ã�ʵ�����ݵļ�ʱ����
 * 
 * @author DELL
 *
 */
public class MuThColle07 {
	TransferQueue<String> queue=new LinkedTransferQueue<>();
	
	public static void main(String[] args){
		final MuThColle07 mt=new MuThColle07();
		
		//��ȡһ�����ݣ�
		new  Thread(new Runnable() {
			@Override
			public void run() {
				try {
					mt.queue.transfer("test string!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ݣ�
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName()+":thread begin");
					System.out.println(Thread.currentThread().getName()+"->"+mt.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}


