package cn.zhoufy.g.strategy;

public class Context {
	private Strategy s;

	public Context(Strategy s) {
		super();
		this.s = s;
	}

	public void setS(Strategy s) {
		this.s = s;
	}
	public void printPrice(double standardPrice) {
		System.out.println("price is:"+s.getPrice(standardPrice));
	}

}
