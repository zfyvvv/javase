package cn.zhoufy.go.adapter;
/**
 * 1.����ϵķ�ʽ���У�
 * Target-->Adapter-->Adaptee-->�ͻ��ķ�����
 *      �ӿ�                        ���                  ����
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
