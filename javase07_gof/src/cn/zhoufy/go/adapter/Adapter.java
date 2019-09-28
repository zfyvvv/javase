package cn.zhoufy.go.adapter;
/**
 * 1.适配器，以继承的方式适配，继承Adaptee,获得客户的需求，且实现客户的接口；
 * @author DELL
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void handleRequest() {
		super.request();
	}

}
