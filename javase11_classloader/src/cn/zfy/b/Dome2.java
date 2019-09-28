package cn.zfy.b;
/**
 * 1、类的三种加载器；层次结构；
 * 2、类加载器的双亲委派机制；
 * 
 * @author DELL
 *
 */
public class Dome2 {
	public static void main(String[] args){
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		System.out.println(System.getProperty("java.class.path"));
		
	}
}

