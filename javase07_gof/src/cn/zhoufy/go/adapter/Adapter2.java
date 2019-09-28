package cn.zhoufy.go.adapter;
/**
 * 1.适配器，以组合的方式适配，新建Adaptee,调用Adaptee.request(),获得客户的需求，且实现客户的接口；
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
