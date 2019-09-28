package cn.zhoufy.g.state;
/*
 * 1.state:define different state by different class that implement the same interface override the same method;
 * 2.holding and operating  a object of state class by a set method to change different state;i
 *  in order to implement different function!
 */
public class Client {
	public static void main(String[] args) {
		LightContext lc=new LightContext();
		lc.setL(new Red());
		lc.setL(new Green());
		
	}

}
