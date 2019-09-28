package cn.zfy.test;
/**
 * 1��ʹ��synchronized+ָʾ�Ʒ���
 * ���߳̽��п��ƣ��߳�֮���ͨ�ŵȣ�
 * wait();notify()�ȷ�����
 * @author DELL
 *
 */
public class Test04 {
	public static void main(String[] args) {
		//������Դ��ͻ��
		/*Student s=new Student(1);
		new Thread(new Comsum(s)).start();
		new Thread(new Save(s)).start();;*/
		
		Student2 s2=new Student2(1);
		new Thread(new Comsum(s2)).start();
		new Thread(new Save(s2)).start();;
		
	}
}

/**
 * 1��һ�����е�һ����Դpower����������ʱ��power�Ĳ�����
 *   ������Դ��ͻ���������Դ��������Դ��ʣ��
 *   ͨ���źŵ�ģʽ�������ߺ�������ģʽ�������������⣻
 *   
 *  2���̳�Student�࣬����Comsum��s2����Save(s2)����Student��ע�룻
 *   �������½�people��ģ�Ȼ������Student���̳и��ࣻ
 *   Comsum��s2����Save(s2)����ע���people��ͨ����̬��ǿ����Ľ�׳�ԣ�
 *   ͬ���ķ��������벻ͬ��ѧ������ý����ͬ��
 *   �����߳�ʵ���ࣨ���������ж�ͬһ��������Դ���Ĳ�������������synchronized��
 *   Ϊ�˱����ͻ������ʹ��ָʾ�Ʒ���
 *   ����߳�(����)ֻ����ִ�У��ڶ�����Դ������ͨ��ʹ��synchronized+ָʾ�Ʒ���
 *   Э��ÿ���߳�֮��Ĺ�ϵ��
 *   ���ʣ�һ�������ĳһ����Դ���������Ҫ���ƣ�����ͬʱ���ж���������̣߳���
 *   ����һ����Ҫ����Դ���к�����ƣ�����ҪЭ��ÿ���������̣߳�֮��Ĺ�ϵ��
 *   ���ȣ��̰߳�ȫ����Σ���Դ��Ҫ��ͻ����ʹ��synchronized+ָʾ�Ʒ���
 *   
 * @author DELL
 *
 */

class Student2 extends Student{
	
	public Student2(int power) {
		super(power);
		// TODO Auto-generated constructor stub
	}

	private int power;
	private boolean flag=true;
	
	//��������ʱ��flagΪtrue�����Խ��и��߳�,�������������ģ�����
	//��û������ʱ��flagΪfalse�����̱߳���ֹͣ���ȴ������̵߳Ļ��ѣ�
	public synchronized void savePower(int power) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.power=power;
		power++;
		System.out.println("����++:"+power);
		this.notify();
		this.flag=false;
	}
	
	public synchronized void consumPower(int power) {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.power=power;
		
		power--;
		System.out.println("����--:"+power);
		this.notify();
		this.flag=true;
	}
}





class Student{
	private int power;
	public Student(int power) {
		super();
		this.power = power;
	}
	
	public synchronized void savePower(int power) {
		power++;
		System.out.println("����++:"+power);
	}
	
	public synchronized void consumPower(int power) {
		power--;
		System.out.println("����--:"+power);
	}
}


/**
 * 1�����������߳����Ƕ�Student��power��Դ�Ĳ�����
 * @author DELL
 *
 */
class Save implements Runnable{
	private Student s;
	private int num;

	public Save(Student s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("save thread!");
			s.savePower(1);
		}
		
	}
	
}

class Comsum implements Runnable{
	private Student s;

	public Comsum(Student s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("consum thread!");
			s.consumPower(1);
		}
		
	}
	
}


