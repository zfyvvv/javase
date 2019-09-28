package cn.zhoufy.g.mediator;


public class Developement implements Department{
	private Mediator m;

	public Developement(Mediator m) {
		super();
		this.m = m;
		m.register("Developement", this);//把自己在中介者哪里注册；
	}

	@Override
	public void selfAction() {
		System.out.println("developementing!");
	}

	@Override
	public void outAction() {
		System.out.println("nomoney! needmoney!");
		m.command("Finacial");
	}

}
