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
 * 1.��ϰ
 * �Զ���ͬ����������������Ϊ10���ڶ��߳���Ӧ�ã�����֤�̰߳�ȫ����������������ģʽ��
 * 2.�����synchronized�����Ӿ�׼��
 *synchronized�л��ѵĿ�����ͬ���̣߳������������������̣߳�
 *Condition��Ϊlock��������������������ʱ����ʲô���飬��������������ȴ����ѣ�
 *
 *3.��ĿǰΪֹ��������̵Ļ���֪ʶ�Ѿ������ˣ�֪ʶ����֪ʶŶ��
 *
 * 
 * @author DELL
 *
 */
public class MuThread07 {
	public static void main(String[] args) {
		Container07<String> container=new Container07<>();
		//����12�������ߣ�
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<5;j++) {
						System.out.println("consumer get:"+container.get());
					}
				}
			},"consumer"+i).start();
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����12�������ߣ�
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<25;j++) {
					container.put("container value"+j);
					}
				}
			},"producer"+i).start();
		}
	}
}

//�������������������������г�����������-->��������������
//ͬ������������ķ�������ͬ���ģ�
//����lock������synchronized��
class Container07<E>{
	private final LinkedList<E> list=new LinkedList<>();
	private final int MAX=10;
	private int count=0;
	
	private Lock lock=new ReentrantLock();
	private Condition producer=lock.newCondition();
	private Condition consumer=lock.newCondition();
	
	public  int getConunt() {
		return count;
	}
	
	public void put(E e) {
		lock.lock();
		try {
			while(list.size()==MAX) {
				System.out.println(Thread.currentThread().getName()+"�ȴ�...");
				producer.await();
			}
			System.out.println(Thread.currentThread().getName()+"put...");
			list.add(e);
			count++;
			//�����������������е������ߣ�
			consumer.signalAll();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				lock.unlock();
			}
		}


	
	public E get() {
		E e=null;
		lock.lock();
		try {
			while(list.size()==0) {
				System.out.println(Thread.currentThread().getName()+"�ȴ�...");
				//���������������߽���ȴ����У�
				consumer.await();
			}
			System.out.println(Thread.currentThread().getName()+"get...");
			e=list.removeFirst();
			count--;
			//�����������������е������ߣ�
			producer.signal();
			
		}catch (Exception e1) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
		return e;

	}

}



