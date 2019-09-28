package cn.zhoufy.g.mediator;


public class Finacial implements Department{
	private Mediator m;
	

	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("Finacial",this );//把自己在中介者哪里注册；
	}

	@Override
	public void selfAction() {
		System.out.println("finacial!");
	}

	@Override
	public void outAction() {
		System.out.println("give you money!");
		
	}

}
