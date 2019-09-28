package cn.zhoufy.g.state;

public class LightContext {
	private Light l;

	public void setL(Light l) {
		this.l = l;
		System.out.println("state is change!");
		l.action();
	}
	
	

}
