package cn.zhoufy.g.state;

public class Red implements Light {

	@Override
	public void action() {
		System.out.println("light is red,stop!");
	}

}
