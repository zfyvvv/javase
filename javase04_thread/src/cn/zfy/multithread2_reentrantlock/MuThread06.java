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
 * 
 * 2.wati/notify���Ǻ�while���Ӧ�ã����Ա�����̲߳����ж��߼�ʧЧ���⣻
 * ��֤wait֮�󣬻����Խ��������жϣ�
 * ifֻ���ж�һ�Σ�
 * 
 * 3.JDK1.7�����ڵĺܶ��ܼ��ݣ�����ѧspringCloudʱ������ѧJDK1.8��
 * 
 * 
 * @author DELL
 *
 */
public class MuThread06 {
	public static void main(String[] args) {
		Container06<String> container=new Container06<>();
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
class Container06<E>{
	private final LinkedList<E> list=new LinkedList<>();
	private final int MAX=10;
	private int count=0;
	
	public synchronized int getConunt() {
		return count;
	}
	
	public synchronized void put(E e) {
		while(list.size()==10) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		list.add(e);
		count++;
		this.notifyAll();
	}
	
	public synchronized E get() {
		E e=null;
		while(list.size()==0) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		e=list.removeFirst();
		count--;
		this.notifyAll();
		return e;
	}

}



