package cn.zfy.syn;

/**
 * 一个场景，共同的资源；
 *生产者消费者 信号灯模式
 *1- wait()：等待，释放锁；sleep(),等待，不释放锁；
 *2- notify()/notifyAll()：唤醒，
 *3-synchronized()
 *同一个对象的即需要生产又需要消费；如果不实现同步，会出现生产和消费不搭配情况；
 *共同资源movie到底是m.play(pic)还是m.watch(pic)；
 *资源会冲突还是说资源不够，甚至出现死锁；
 *是对同一份资源movie进行执行；当两个线程watcher和player都要执行线程体里面的方法时；
 *就会对同一份资源movie进行争抢，watcher中线程体调用的是movie.watch()，
 *player中线程体中调用的是movie.play()方法；
 * 当两个类均需要传入同一个对象movie时，此时两个线程分别执行对象movie中的两个方法，
 *但是这两个方法均是synchronized修饰的，需要等待释放锁，才可以进行后面程序； 
 *4.此时需要协作资源，线程之间协作工作；
 *加入同步；
 *加入线程的逻辑方法，是的生产和消费协调；
 * @author DELL
 *
 */
public class SynD1 {
	public static void main(String[] args) {
		Movie m=new Movie();
		
		Player p=new Player(m);
		Watcher w=new Watcher(m);
		new Thread(p).start();
		new Thread(w).start();
	}

}





/**
 *一个场景，共同的资源；
 *生产者消费者 信号灯模式
 *1- wait()：等待，释放锁；sleep(),等待，不释放锁；
 *2- notify()/notifyAll()：唤醒，
 *3-synchronized（）
 *	共同资源movie到底是m.play(pic)还是m.watch(pic)；
	资源会冲突还是说资源不够，甚至出现死锁；
 * @author DELL
 *
 */
/*class Movie {
	private String pic;
	
	//信号灯
	//flag-->T,生产者生产，消费者等待；生产完成后，flag为F，通知消费；palyer开始生产；
	//flag-->F，消费者消费，生产者等待；消费完成后，通知生产；watcher开始消费；
	private boolean flag=true;
	

	public synchronized void play(String pic) {//生产者
		if(!flag) {//生产者等待；
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产；
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕；
		this.pic=pic;
		System.out.println("生产了--->"+pic);
		//通知消费；
		this.notify();
		//生产者停下；
		this.flag=false;
		}
	
	public synchronized void watch() {//消费者
		if(flag) {//消费者等待；
			try {
				this.wait();;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//消费者生产；
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费了--->"+pic);
		//消费完毕；
		//通知生产；
		this.notifyAll();
		//消费停止；
		this.flag=true;
	}
}*/



class Movie {
	private String pic;
	//信号灯
	//flag-->T,生产者生产，消费者等待；生产完成后，flag为F，通知消费；palyer开始生产；
	//flag-->F，消费者消费，生产者等待；消费完成后，通知生产；watcher开始消费；
	private boolean flag=true;
	public synchronized void play(String pic) {//生产者
		//开始生产；
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕；
		this.pic=pic;
		System.out.println("生产了--->"+pic);
		//通知消费；
		//生产者停下；
		}
	public synchronized void watch() {//消费者
		//消费者生产；
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费了--->"+pic);
		//消费完毕；
		//通知生产；
		//消费停止；
	}
}



class Player implements Runnable {
	private Movie m;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}
	@Override
	public void run() {
		
		for(int i=0;i<=10;i++) {
			if(0==i%2) {
				m.play("zfy");
			}else {
				m.play("lt");
			}
		}
	}
}

class Watcher implements Runnable {
	private Movie m;
	public Watcher(Movie m) {
		super();
		this.m = m;
	}
	
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			m.watch();
		}
		
	}
}

