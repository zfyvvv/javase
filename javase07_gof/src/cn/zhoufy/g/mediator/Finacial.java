package cn.zhoufy.g.mediator;


public class Finacial implements Department{
	private Mediator m;
	

	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("Finacial",this );//���Լ����н�������ע�᣻
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
