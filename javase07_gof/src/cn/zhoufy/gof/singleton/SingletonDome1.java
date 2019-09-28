package cn.zhoufy.gof.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 1.单例模式-饿汉式
 * @author DELL
 *
 */
public class SingletonDome1 {
	//私有化静态的一个实例，初始化时就新建类的一个对象，没有延时加载；
	private static SingletonDome1 instance=new SingletonDome1();
	//构造器私有化；
	private SingletonDome1() {
	}
	//提供对外的获得对象的方法；
	public static SingletonDome1 getInstance() {
		return instance;
	}
}


/**
 * 2.单例模式-懒汉式
 * @author DELL
 *
 */
class SingletonDome2 {
	//私有化静态的一个实例，初始化时不新建类的一个对象，延时加载；
	private static SingletonDome2 instance;
	//构造器私有化；
	private SingletonDome2() {
	}
	//提供对外的获得对象的方法；方法同步，并保证线程安全
	public static synchronized SingletonDome2 getInstance() {
		if(instance==null) {
			instance=new SingletonDome2();
		}
		return instance;
	}
}


/**
 * 3.单例模式-双重检测锁实现
 * @author DELL
 *
 */
class SingletonDome3 {
	//私有化静态的一个实例，初始化时不新建类的一个对象，延时加载；
	private static SingletonDome3 instance=null;
	//构造器私有化；
	private SingletonDome3() {
	}
	//提供对外的获得对象的方法；方法不同步，但是里面的块同步；
	public static synchronized SingletonDome3 getInstance() {
		if(instance==null) {
			SingletonDome3 sd;
			//将同步的内容下放到if内部，不用同步整个块，提高执行效率；
			synchronized(SingletonDome3.class) {
			sd=instance;
			//第一次创建时需要同步，后续不需要；
			synchronized(SingletonDome3.class) {
			if(sd==null) {
				//由于编译器优化及JVM内部原因，偶尔出问题，不建议使用；
				sd=new SingletonDome3();
			}}
			instance=sd;
		}}
		return instance;
	}
}

/**
 * 4.单例模式-静态内部类实现方式（也是一种懒加载）
 * @author DELL
 *
 */
class SingletonDome4 {
	//外部类没有static属性，不会像饿汉式那样立即加载；
	//只有真正使用getinstance()才会加载，延时加载；并且线程安全！
	//由于是static final，故只有一个实例，且可以赋值一次，且线程安全；
	//兼具有高效调用和延时加载的优势！
	private static class SingletonClassInstance{
		private static final SingletonDome4 instance =new SingletonDome4();
	}  
	private SingletonDome4() {
	}
	//获得静态内部类的一个属性-所需要的对象；
	public static synchronized SingletonDome4 getInstance() {
		return SingletonClassInstance.instance;
	}
}


/**
 * 5.单例模式-枚举类
 * @author DELL
 *
 */
enum SingletonDome5 {
	//枚举本身就是一个对象，效率高且反射安全，没有延时加载（缺点）
	INSTANCE;
	//自己定义单例的操作；
	public void singletonOperator() {
		
	}
}


/**
 * 1.单例模式-懒汉式
 * 2、用于破解；
 * @author DELL
 *
 */
class SingletonDome6 implements Serializable {
	
	private static SingletonDome6 instance;
	private SingletonDome6() {
		//反射调用时，反射破坏！
		if(instance!=null) {
			throw new RuntimeException();
		}
	}
	public static synchronized SingletonDome6 getInstance() {
		if(instance==null) {
			instance=new SingletonDome6();
		}
		return instance;
	}
	//反序列化调用时，防止破坏
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}

