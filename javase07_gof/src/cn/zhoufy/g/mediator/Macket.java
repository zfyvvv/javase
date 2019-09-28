package cn.zhoufy.g.mediator;


public class Macket implements Department{
	private Mediator m;
	
	
	
	public Macket(Mediator m) {
		super();
		this.m = m;
		m.register("Macket", this);//把自己在中介者哪里注册；
	}

	@Override
	public void selfAction() {
		System.out.println("macket!");
		m.command("dname");
	}

	@Override
	public void outAction() {
		
	}

}
