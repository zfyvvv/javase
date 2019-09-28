package cn.zfy.syn;
/**
 * 1、synchronized实现单例设计模式：
 *   synchronized锁的地方和位置，考虑效率和安全；
 *2、单例设计模的对比和优化；
 *  懒汉式；
 *  饿汉式；
 *  优化后的懒汉式；
 *  
 * @author DELL
 *
 */
public class SynD2 {
	public static void main(String[] args) {
		JvmThread jt1=new JvmThread(200); 
		JvmThread jt2=new JvmThread(500); 
		jt1.setName("zfy");
		jt2.setName("lt");
		jt1.start();
		jt2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	public JvmThread() {
		super();
	}
	public JvmThread(long time) {
		super();
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+Jvm.getInstance(time));
		super.run();
	}
}



/**
 * 单例设计模式：确保一个类只有一个对象；
 * 一、懒汉式：
 * 1-私有化构造器，避免外部直接访问；
 * 2-构建一个私有的静态变量对象；
 * 3-创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象；
 * 
 * 二、3种实现方式的比较：
 *   安全和效率；
 * @author DELL
 *
 */
//懒汉式：类加载时不一定立即创建instance；只有调用方法时才会创建；
class Jvm{
	private static Jvm instance=null;
	
	private Jvm() {};
	
	public static  Jvm getInstance(long time) {
		//安全，但是效率相对较高；提高已经存在对象产生的效率；后期有对象时，直接跳过锁定，获得对象；
		//当已经有对象时，可以不用等等待，直接返回静态变量对象；
		//如果没有，再去创建对象，这个时候才会考虑线程安全和锁定的事情；
		//进入synchronized{}代码块后，也需要判定一次，判定锁块内是否有重复情况；
		if(null==instance) {
		//dzouble checking!!!	               
		synchronized(Jvm.class) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			
	}
		}
		return instance;
}
	//静态方法中没有对象，无法锁对象，通过锁类的字节码信息，控制并发，synchronized(类.class){}；
	/*public static  Jvm getInstance(long time) {
	 //安全，但是效率也不高；  
		synchronized(Jvm.class) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			return instance;
	}}*/
	
	//直接锁静态方法，安全，但效率不高；
	/*public static synchronized Jvm getInstance(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			return instance;
	}*/
}

/**
 * 单例设计模式：确保一个类只有一个对象；
 * 一、饿汉式：
 * 1-私有化构造器，避免外部直接访问；
 * 2-构建一个私有的静态变量对象；同时创建该对象；
 * 3-创建一个对外的公共的静态方法访问该变量;
 * @author DELL
 *
 */
//加载该类时，静态方法和静态属性直接加载，就会创建一个对象；
//调用|加载该类时，创建对象；类加载时，属性一定会被创建！！！
class Jvm2{

	//创建一个私有静态变量对象；类加载时就已经创建，饿汉式；
	private static Jvm2 instance=new Jvm2();
	//私有化构造器；
	private Jvm2() {};
	//对外提供获取私有静态变量的方法；
	public Jvm2 getInstance() {
		return instance;
	}
	
}
/**
 * 单例设计模式：确保一个类只有一个对象；
 * 一、饿汉式：提高效率
 * 1-私有化构造器，避免外部直接访问；
 * 2-构建一个私有的静态变量对象；同时创建该对象；
 * 3-创建一个对外的公共的静态方法访问该变量;
 * @author DELL
 *
 */
//调用|加载该类时，只加载该类的静态方法和静态属性；
//内部类，内部类的静态属性和方法在Jvm3加载过程中不一定加载，只有调用时才会加载；延缓加载时机，提高效率，
//类加载时，方法不一定加载；内部类也不一定加载；

class Jvm3{
	
	//私有化构造器；
	private Jvm3() {};
	//对外提供获取方法；但是在调用|加载该类时不会生成；
	public Jvm3 getInstance() {
		//此时不一定立即获取；
		return JvmHolder.instance;
	}
	
	//静态内部类，不一定立即加载，只有调用getInstance()时才会加载；
	private static class JvmHolder{
		private static Jvm3 instance=new Jvm3();
		}
	
}