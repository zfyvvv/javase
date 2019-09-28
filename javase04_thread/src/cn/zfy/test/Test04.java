package cn.zfy.test;
/**
 * 1、使用synchronized+指示灯法，
 * 对线程进行控制，线程之间的通信等；
 * wait();notify()等方法；
 * @author DELL
 *
 */
public class Test04 {
	public static void main(String[] args) {
		//出现资源冲突；
		/*Student s=new Student(1);
		new Thread(new Comsum(s)).start();
		new Thread(new Save(s)).start();;*/
		
		Student2 s2=new Student2(1);
		new Thread(new Comsum(s2)).start();
		new Thread(new Save(s2)).start();;
		
	}
}

/**
 * 1、一个类中的一份资源power，两个方法时对power的操作；
 *   出现资源冲突的情况：资源不够或资源过剩；
 *   通过信号灯模式（生产者和消费者模式），解决这个问题；
 *   
 *  2、继承Student类，方便Comsum（s2）和Save(s2)类中Student的注入；
 *   本来想新建people类的，然后两个Student都继承该类；
 *   Comsum（s2）和Save(s2)类中注入的people，通过多态加强代码的健壮性；
 *   同样的方法，传入不同的学生，获得结果不同；
 *   两个线程实现类（动作）都有对同一个对象（资源）的操作，操作均是synchronized；
 *   为了避免冲突，所以使用指示灯法；
 *   多个线程(动作)只负责执行；在对象（资源）类中通过使用synchronized+指示灯法，
 *   协调每个线程之间的关系；
 *   本质：一个对象的某一份资源，如果不需要控制，可以同时进行多个动作（线程）；
 *   但是一旦需要对资源进行合理控制，就需要协调每个动作（线程）之间的关系；
 *   首先，线程安全；其次，资源不要冲突；故使用synchronized+指示灯法，
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
	
	//当有能量时，flag为true；可以进行该线程,进行能量的消耗（）；
	//当没有能量时，flag为false，该线程必须停止；等待其他线程的唤醒；
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
		System.out.println("能量++:"+power);
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
		System.out.println("能量--:"+power);
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
		System.out.println("能量++:"+power);
	}
	
	public synchronized void consumPower(int power) {
		power--;
		System.out.println("能量--:"+power);
	}
}


/**
 * 1、以下两个线程类是对Student中power资源的操作；
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


