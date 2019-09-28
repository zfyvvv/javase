package cn.zhoufy.g.templatemethod;

public abstract class EatMeeting {
	
	void bookHotel() {
		System.out.println("bookhotel!");
	}
	
	abstract void eatsomething();//call method!!
	
	void payMoney() {
		System.out.println("paymoney!");
	}

}
