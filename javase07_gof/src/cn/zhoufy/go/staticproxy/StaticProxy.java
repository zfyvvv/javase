package cn.zhoufy.go.staticproxy;

public class StaticProxy implements Star{
	private RealStar realStar;
	public StaticProxy() {
		// TODO Auto-generated constructor stub
	}
	public StaticProxy(RealStar realStar) {
		super();
		this.realStar = realStar;
	}



	@Override
	public void confer() {
		System.out.println("staticproxyconfer");		
	}

	@Override
	public void bookTicket() {
		System.out.println("staticproxybookTicket");	
		
	}

	@Override
	public void sing() {
		realStar.sing();
	}

	@Override
	public void bookHotel() {
		System.out.println("staticproxybookHotel");	
		
	}

}
