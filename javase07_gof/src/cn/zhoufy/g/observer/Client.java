package cn.zhoufy.g.observer;
/**
 * 1.observer:the list and the method of notifyAllObserver() in Subject class is important!
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		ConcreteSubserver sb=new ConcreteSubserver();//in order to useing specific method 
		                                               //   object  new by subclass
		
		ObserverA ob1=new ObserverA();//
		ObserverA ob2=new ObserverA();
		ObserverA ob3=new ObserverA();
		sb.addObserver(ob1);
		sb.addObserver(ob2);
		sb.addObserver(ob3);
		
		sb.setSate(800);
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		System.out.println("-------------");
		sb.setSate(1000);
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
	}

}
