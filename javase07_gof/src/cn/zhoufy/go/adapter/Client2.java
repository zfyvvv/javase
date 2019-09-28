package cn.zhoufy.go.adapter;
/**
 * 1.以组合的方式进行，
 * Target-->Adapter-->Adaptee-->客户的方法！
 *      接口                        组合                  方法
 * @author DELL
 *
 */
public class Client2 {
	public void text(Target t) {
		t.handleRequest();
	}
	
	public static void main(String[] args) {
		Client2 c=new Client2();
		Target t=new Adapter2(new Adaptee());
		c.text(t);
		
	}
}
