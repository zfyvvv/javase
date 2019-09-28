package cn.zhoufy.g.strategy;
/**
 * 1.increse new strategy by incresing new class,not by modifying the original code!
 * 2.separate the algorithm and concrete class!
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		Strategy s=new OldBigSituation();
		Strategy s2=new NewBigSituation();
		Context c=new Context(s);
		Context c2=new Context(s2);
		double d=1000;
		
		c.printPrice(1000);
		c2.printPrice(1000);
		
		
	}

}
