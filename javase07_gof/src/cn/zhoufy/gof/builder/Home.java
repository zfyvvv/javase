package cn.zhoufy.gof.builder;

public class Home {//��Ҫ��õĶ���
	private Money mon;
	private House hou;
	private Car car;
	
	public Money getMon() {
		return mon;
	}
	public void setMon(Money mon) {
		this.mon = mon;
	}
	public House getHou() {
		return hou;
	}
	public void setHou(House hou) {
		this.hou = hou;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

}
class Car{//�������
	private String name;

	public Car(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
class House{//�������
	private String name;

	public House(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
class Money{//�������
	private String name;

	public Money(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

