package cn.zfy.cooperation;
/**
 * 1.协作模型：生产者和消费者实现方式一，管程法；
 * 2.第一步：加入并发，方法中添加synchronized;
 * 
 * 
 * @author DELL
 *
 */
public class Cooperation {
	public static void main(String[] args) {
		//先来一个缓冲区，后来分别来一个生产者和消费者，
		SynContainer sc=new SynContainer();
		Productor p=new Productor(sc);
		Consumer c=new Consumer(sc);
		
		new Thread(p).start();
		new Thread(c).start();
	}
}

//生产者
class Productor implements Runnable{
	SynContainer container;
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}
	
	//开始生产；
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("生产了第"+i+"个西瓜！！");
			container.push(new Watermelon(i));
		}
	}
	
}
//消费者
class Consumer implements Runnable{
	SynContainer container;

	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}

	//开始消费；
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("消费了第"+container.pop().getI()+"个西瓜！");
		}
	}
}
//缓冲区
class SynContainer{
	Watermelon[] ws=new Watermelon[10];
	int count=0;
	//储存西瓜，生产；
	public synchronized void push(Watermelon wm) {
		//何时生产？什么时候不能生产？
		if(count==ws.length) {
			try {
				//此时线程阻塞，何时解除阻塞？
				//消费者通知生产；解除阻塞；
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		//容器存在空间；可以生产；只要不是上述if情况，就可以生产；
		ws[count]=wm;
		count++;
		//存在数据了，可以通知消费了；
		this.notifyAll();
	}
	//消费西瓜，消费；
	public synchronized Watermelon pop() {
		//何时消费？
		//没有数据，就只能等待；
		if(count==0) {
			try {
				//此时线程阻塞，何时解除阻塞？
				//生产者通知消费；解除阻塞；
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		//容器中有数据存在，就可以消费；此时可以消费；
		count--;
		Watermelon wm=ws[count];
		//消费后，有空间，通知所有的生产者；
		this.notifyAll();
		return wm;
	}
	
	
}
//数据对象；
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

