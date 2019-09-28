package cn.zfy.lambda;

/**
 * 1.lambda表达式：labmdad推到+方法中有参数+返回值；
 * 2.应用；
 * 
 * @author DELL
 *
 */
public class Lamb5 {

	public static void main(String[] args) {
		//在jdk8以后的版本中经常出现；
		new Thread(()-> {
			System.out.println("111111");
		}).start();
	
	//当中只有一行时，可是省略大括号；
	new Thread(()-> System.out.println("22222")).start();
	
	//当中只有多行时，不可省略；
	new Thread(()-> {
		System.out.println("111111");
		for(int i=0;i<3;i++) {
			System.out.println("bukeugl-->"+i);
		}
	}).start();
	
	
}
}


