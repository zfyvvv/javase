package cn.zfy.lambda;

/**
 * 1.lambda表达式：自定义类的lambda表达式；labmdad推到过程；
 * @author DELL
 *
 */
public class Lamb2 {
	
	public static class La2 implements La{

		@Override
		public void la() {
			// TODO Auto-generated method stub
			System.out.println("this la2");
		}
		
	}

	public static void main(String[] args) {
		//局部内部类；
		class La3 implements La{
			@Override
			public void la() {
				// TODO Auto-generated method stub
				System.out.println("this is la3");
			}
			
		}
		
		//调用外部类；
		La la1=new La1();
		la1.la();
		//静态内部类；优点；不使用不会编译；
		La la2=new La2();
		la2.la();
		//局部内部类，
		La la3=new La3();
		la3.la();
		//匿名内部内；
		La la4=new La() {
			@Override
			public void la() {
				// TODO Auto-generated method stub
				System.out.println("this la niming");
			}
		};
		la4.la();
		//lambda表达式，jdk8对其进行简化；
		//必须需要一个类型；前面必须给一个引用或一个形参(一个类型)
		La la5=()->{
				// TODO Auto-generated method stub
				System.out.println("this lambda!");
			};
			la5.la();
			
		//不能这样；
		/*()->{
			// TODO Auto-generated method stub
			System.out.println("this lambda!");
		}.la();	*/
			
	}
}

//外部类；
class La1 implements La{
	@Override
	public void la() {
		System.out.println("this is la1");
	}
}

//定义接口；
interface La{
	void la();
}
