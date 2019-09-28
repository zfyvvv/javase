package cn.zhoufy.innerclass.a;

public class Dome1 {
	public static void main(String[] args) {
		Car c=new Car() {//继承式
			@Override
			void run() {
				System.out.println("继承跑！");
			}
		};
		c.run();
		
	}
	
	
	
	
	public static class StaticInnerClass{//静态内部类
	}
	public class FileClass{//成员内部类|普通内部类
	}
	
	void text1() {
		class LocalClass{//局部内部类|方法内部类
		}
		Runnable run=new Runnable() {//匿名内部类：定义了一个匿名内部类的类体，创建了匿名内部类 的一个实例；（在方法内部）|方法内部类
			@Override
			public void run() {
			}
		};//
	}
		Runnable run1=new Runnable() {//匿名内部类：（在方法外部）|成员内部类
		@Override
		public void run() {
			// TODO Auto-generated method stub
		}
		};
		
		
	
}
class Car{
	
	void run() {
		System.out.println("正常跑！");
	}
}
