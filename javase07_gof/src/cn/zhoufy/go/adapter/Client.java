package cn.zhoufy.go.adapter;
/**
 * 1.客户创建连接接口的方法，通过对象调用，接口（Target对象！）
 * Target-->Adapter-->Adaptee-->客户的方法！
 *      接口                        继承                   方法
 * @author DELL
 *
 */
public class Client {
	public void text(Target t) {
		t.handleRequest();
	}
	
	public static void main(String[] args) {
		Client c=new Client();
		Target t=new Adapter();
		
		c.text(t);
		
	}
}
