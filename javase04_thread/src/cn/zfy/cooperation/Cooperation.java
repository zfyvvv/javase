package cn.zfy.cooperation;
/**
 * 1.Э��ģ�ͣ������ߺ�������ʵ�ַ�ʽһ���̷ܳ���
 * 2.��һ�������벢�������������synchronized;
 * 
 * 
 * @author DELL
 *
 */
public class Cooperation {
	public static void main(String[] args) {
		//����һ���������������ֱ���һ�������ߺ������ߣ�
		SynContainer sc=new SynContainer();
		Productor p=new Productor(sc);
		Consumer c=new Consumer(sc);
		
		new Thread(p).start();
		new Thread(c).start();
	}
}

//������
class Productor implements Runnable{
	SynContainer container;
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}
	
	//��ʼ������
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("�����˵�"+i+"�����ϣ���");
			container.push(new Watermelon(i));
		}
	}
	
}
//������
class Consumer implements Runnable{
	SynContainer container;

	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}

	//��ʼ���ѣ�
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("�����˵�"+container.pop().getI()+"�����ϣ�");
		}
	}
}
//������
class SynContainer{
	Watermelon[] ws=new Watermelon[10];
	int count=0;
	//�������ϣ�������
	public synchronized void push(Watermelon wm) {
		//��ʱ������ʲôʱ����������
		if(count==ws.length) {
			try {
				//��ʱ�߳���������ʱ���������
				//������֪ͨ���������������
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		//�������ڿռ䣻����������ֻҪ��������if������Ϳ���������
		ws[count]=wm;
		count++;
		//���������ˣ�����֪ͨ�����ˣ�
		this.notifyAll();
	}
	//�������ϣ����ѣ�
	public synchronized Watermelon pop() {
		//��ʱ���ѣ�
		//û�����ݣ���ֻ�ܵȴ���
		if(count==0) {
			try {
				//��ʱ�߳���������ʱ���������
				//������֪ͨ���ѣ����������
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		//�����������ݴ��ڣ��Ϳ������ѣ���ʱ�������ѣ�
		count--;
		Watermelon wm=ws[count];
		//���Ѻ��пռ䣬֪ͨ���е������ߣ�
		this.notifyAll();
		return wm;
	}
	
	
}
//���ݶ���
class Watermelon{
	private int i;

	public Watermelon(int i) {
		super();
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}

