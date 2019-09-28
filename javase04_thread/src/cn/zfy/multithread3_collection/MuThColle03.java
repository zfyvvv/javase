package cn.zfy.multithread3_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 1.ConcurrentLinkedQueue��
 * ��������ͬ�����У�
 * @author DELL
 *
 */
public class MuThColle03 {
	
	public static void main(String[] args) {
		Queue<String> queue=new ConcurrentLinkedQueue<>();
		for(int i=0;i<10;i++) {
			//���10������;
			queue.offer("value"+i);
		}
		System.out.println(queue);
		System.out.println(queue.size());
		//�鿴queue�е������ݣ�
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//��ȡqueue�е�������;
		System.out.println(queue.poll());
		System.out.println(queue.size());

	}
}

