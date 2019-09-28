package cn.zfy.implement;
/**
 * 1、接口的定义及实现；
 * 2、回调方法；根据传入对象的不同获得不同的结果；
 * @author DELL
 *
 */
public class Printframe {
	//定义一个需要这个接口的对象；
	public static void drawFrame(IMyframe f/*子类对象*/) {
		System.out.println("1启动线程");
		System.out.println("2增加循环");
		System.out.println("3查看信息条");
		//画窗口；
		f.paint();
		System.out.println("5启动缓存，增加效率");
		
	}
	public static void main(String[] args) {
		//Myframe a= new Myframe();
		//drawFrame(a);
		//drawFrame(Myframe f);
		//GameFrame01 a=new GameFrame01();
		//drawFrame(a);
		//根据传入的对象不同，获得不同的程序结果；
		drawFrame(new GameFrame02());
}

}

//定义一个接口；
interface IMyframe{
	void paint();
}
	 

//接口的两个实现；
 class GameFrame01 implements IMyframe {
	 public void paint() { 
		 System.out.println("GameFrame01.paint()");
		 System.out.println("画游戏窗口11！");
	 }	 
 }
		 
 class GameFrame02 implements IMyframe {
	 public void paint() { 
		 System.out.println("GameFrame02.paint()");
		 System.out.println("画游戏窗口22！");
	 }	 
 }		 
		 





