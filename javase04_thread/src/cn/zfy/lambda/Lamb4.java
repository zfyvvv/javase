package cn.zfy.lambda;

/**
 * 1.lambda表达式：labmdad推到+方法中有参数+返回值；
 * 
 * @author DELL
 *
 */
public class Lamb4 {

	public static void main(String[] args) {
		//lambda表达式；
		Lambda lam=(int a,int c)->{
			return a+c;
		};
		System.out.println(lam.la(2, 3));
		//lambda表达式；类型可以省略，括号不可以省略，因为有两个参数；
		lam=(a,d)->{
			return a+d;
		};
		System.out.println(lam.la(4, 3));
		//lambda表达式；如果只有一行代码；大括号也可以省略；有返回值，return也可以省略；
		//如果是多行代码，必须加花括号，括号里面语句加分号；
		lam=(a,d)->a+d;
		System.out.println(lam.la(10, 10));
	}
}


//定义接口；
interface Lambda{
	int la(int a,int b);
}
