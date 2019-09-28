package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized��ʲô��
 * ������synchronized (this)��synchronized������������ǰ����
 * ��ǰ������ָMultThread1�����д��������Ķ���
 * ����2�ͷ���3����ͬһ������
 * @author DELL
 *
 */
public class MultThread01 {
	private int count=0;
	private Object o=new Object();
	
	public void testSync1() {
		synchronized (o) {
			System.out.println(Thread.currentThread().getName()+"count="+count++);
		}
	}
	
	public void testSync2() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+"count="+count++);
		}

	}
	public synchronized void testSync3() {
		System.out.println(Thread.currentThread().getName()+"count="+count++);
	}
	
	public static void main(String[] args) {
		 MultThread01 mt=new MultThread01();
		 //mt����ֵ��ǰ����
		 mt.testSync1();
	}

}
