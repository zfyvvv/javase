package cn.zhoufy.g.state;

public class Green implements Light {

	@Override
	public void action() {
		System.out.println("light is green,going");
	}

}
