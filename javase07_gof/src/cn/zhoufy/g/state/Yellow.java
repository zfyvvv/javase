package cn.zhoufy.g.state;

public class Yellow implements Light {

	@Override
	public void action() {
		System.out.println("light is yellow,wait!");
	}

}
