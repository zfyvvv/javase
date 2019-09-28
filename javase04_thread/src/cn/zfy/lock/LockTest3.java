package cn.zfy.lock;
/**
 * 1.��������������������ʹ�ã��������м�������
 * 2.ԭ�������жϽ������߳��Ƿ����Ѿ��������̣߳�
 *	����ǣ��ǾͲ��õ��ˣ���ֱ��ʹ�ðɣ�
 *	������ǣ��Ǿͺúõȣ���������ͷ��ˣ���ſ��� ��ȥ��
 *3.GUC���и�ReentrantLock
 *4.lock ,�޷Ǿ���һ���࣬�������һ�����󣬶��������¼����һЩ��Ϣ
 * @author DELL
 *
 */
public class LockTest3 {
	ReLock lock=new ReLock();
	
	public void aaa() throws InterruptedException {
		lock.lock();
		System.out.println("aaa1-->"+lock.getHoldCount());
		bbb();
		lock.unlock();
		System.out.println("aaa2-->"+lock.getHoldCount());
	}
	//�������룻ʹ�������֮���أ������ͷţ�
	public void bbb() throws InterruptedException {
		lock.lock();
		System.out.println("bbb1-->"+lock.getHoldCount());
		//....
		lock.unlock();
		System.out.println("bbb2-->"+lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest3 lt=new LockTest3();
		lt.aaa();
		
		Thread.sleep(1000);
		System.out.println("last-->"+lt.lock.getHoldCount());
		
	}
}

//������ʵ�����Լ�������ࣻ�������ж�����ѣ�
//����������
class ReLock{
	//�Ƿ�ռ��
	private boolean isLocked=false;
	//�洢��ǰ�̣߳�
	Thread lockedBy=null;
	//���ļ�������
	private int holdCount=0;
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		//��ǰ�̵߳����ã�
		Thread t=Thread.currentThread();
		//�����ǰ�߳��Ѿ�ռ�ã����̲߳��ǵ�ǰ�߳�-->�����ɵ�ǰ�߳�������
		//�ǽ��ֻ���ǵȴ���
		//�����ǰ�߳�û�б�ռ�û��Ǳ������߳�ռ�ã����õȴ���ֱ�ӽ��к���������
		//���к���������ʹ��һЩ��ʶ�����б�ǣ��������룻
		while(isLocked&&lockedBy!=t) {
			wait();
		}
		isLocked=true;
		lockedBy=t;
		holdCount++;
		
	}
	//�ͷ���
	public synchronized void unlock() {
		//ʲôʱ���ͷ�����
		//��ǰ�̵߳��������ʱ���ͷ�����
		if(Thread.currentThread()==lockedBy) {
			holdCount--;
			if(holdCount==0) {
				isLocked=false;
				notify();
				lockedBy=null;
			}
		}
	}
	public int getHoldCount() {
		return holdCount;
	}
	
	
}
