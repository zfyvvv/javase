package cn.zfy.lock;
/**
 * 1.������������������������ʹ�ã�
 * @author DELL
 *
 */
public class LockTest2 {
	Lock lock=new Lock();
	
	public void aaa() throws InterruptedException {
		lock.lock();
		bbb();
		lock.unlock();
	}
	//�������룻ʹ�������֮���أ������ͷţ�
	public void bbb() throws InterruptedException {
		lock.lock();
		//....
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest2 lt=new LockTest2();
		lt.aaa();
		lt.bbb();
		
	}
}

//������ʵ�����Լ�������ࣻ�������ж�����ѣ�
//����������
class Lock{
	//�Ƿ�ռ��
	private boolean isLocked=false;
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked=true;
		
	}
	//�ͷ���
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
	
}
