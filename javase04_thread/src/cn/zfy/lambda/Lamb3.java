package cn.zfy.lambda;

/**
 * 1.lambda表达式：labmdad推到+方法中有参数；
 * 
 * @author DELL
 *
 */
public class Lamb3 {

	public static void main(String[] args) {
		//常规操作；
		Lam lam=new Lam1();
		lam.la(1);
		//lambda表达式；
		Lam lam2=(int a)->{
			System.out.println("this is la2"+"-->"+a);
		};
		lam2.la(2);
		//lambda表达式；省略参数类型 ；
		Lam lam3=(a)->{
			System.out.println("this is la3"+"-->"+a);
		};
		lam3.la(3);
		//lambda表达式；当参数只有一个时，括号也可以省略；
		Lam lam4=a->{
			System.out.println("this is la4"+"-->"+a);
		};
		lam4.la(4);
		//lambda表达式；如果只有一行代码；大括号也可以省略；
		//如果是多行代码，必须加花括号，括号里面语句加分号；
		Lam lam5=a->System.out.println("this is la5"+"-->"+a);
		lam5.la(5);
	}
}

//外部类；
class Lam1 implements Lam{
	@Override
	public void la(int a) {
		System.out.println("this is la1"+"-->"+a);
	}
}

//定义接口；
interface Lam{
	void la(int a);
}
