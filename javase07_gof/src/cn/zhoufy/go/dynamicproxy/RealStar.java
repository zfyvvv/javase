package cn.zhoufy.go.dynamicproxy;

public class RealStar implements Star{

	@Override
	public void confer() {
		
	}

	@Override
	public void bookTicket() {
		System.out.println("zfybookTicketS!!");
	}

	@Override
	public void sing() {
		System.out.println("zfysing!!");
	}

	@Override
	public void bookHotel() {
		
	}

}
