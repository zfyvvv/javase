package cn.zhoufy.gof.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	
	public Sheep2() {
		super();
	}
	public Sheep2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
@Override
protected Object clone() throws CloneNotSupportedException {
	Object obj=super.clone();
	Sheep2 s=(Sheep2) obj;
	s.birthday=(Date) s.birthday.clone();//Sheep2的属性值也跟着克隆一份！
	return obj;
}
}
