package cn.zhoufy.go.adapter;
/**
 * 1.�ͻ��������ӽӿڵķ�����ͨ��������ã��ӿڣ�Target���󣡣�
 * Target-->Adapter-->Adaptee-->�ͻ��ķ�����
 *      �ӿ�                        �̳�                   ����
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
