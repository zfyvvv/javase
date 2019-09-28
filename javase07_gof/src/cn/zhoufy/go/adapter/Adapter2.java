package cn.zhoufy.go.adapter;
/**
 * 1.������������ϵķ�ʽ���䣬�½�Adaptee,����Adaptee.request(),��ÿͻ���������ʵ�ֿͻ��Ľӿڣ�
 * @author DELL
 *
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;
	
	public Adapter2() {
	}
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void handleRequest() {
		adaptee.request();
	}

}
