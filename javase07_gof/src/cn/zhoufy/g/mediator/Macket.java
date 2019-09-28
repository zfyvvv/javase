package cn.zhoufy.g.mediator;


public class Macket implements Department{
	private Mediator m;
	
	
	
	public Macket(Mediator m) {
		super();
		this.m = m;
		m.register("Macket", this);//���Լ����н�������ע�᣻
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
