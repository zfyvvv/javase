package cn.zhoufy.g.observer2;
/**
 * 1.TDk have implements this function by Observable class and Observer interface
 * 2. subject extends Observable class and add set();
 * 3.observer implements Observer interface;
 * @author DELL
 *
 */

public class Client {
	public static void main(String[] args) {
		ConcreteSubject sb=new ConcreteSubject();
      

		ObserverA ob1=new ObserverA();//
		ObserverA ob2=new ObserverA();
		ObserverA ob3=new ObserverA();
		sb.addObserver(ob1);
		sb.addObserver(ob2);
		sb.addObserver(ob3);
		
		sb.set(1000);
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		
		sb.set(800);
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
			}
}
