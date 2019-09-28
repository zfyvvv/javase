package cn.zhoufy.gof.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep1 implements Cloneable,Serializable{
	private String name;
	private Date birthday;
	
	public Sheep1() {
		super();
	}
	public Sheep1(String name, Date birthday) {
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
	Object obj=super.clone();//直接使用Object的clone()方法；
	return obj;
}
}
