package cn.zhoufy.g.memento;

public class Emp {
	private String name;
	private int age;
	private int salary;
	
	public EmpMemento memento() {//进行备忘录的操作，并返回备忘录的对象！
		return new EmpMemento(this);
	}
	public void recoverEmp(EmpMemento mmo) {//进行恢复操作，恢复指定备忘录对象的值
		this.name=mmo.getName();
		this.age=mmo.getAge();
		this.salary=mmo.getSalary();
	}
	public Emp(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	

}
