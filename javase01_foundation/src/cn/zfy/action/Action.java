package cn.zfy.action;
/**
 * 为了测试eclipse中常用的快捷键；
 * @author DELL
 *
 */
public class Action {
	private String name;
	private int age;

	
	public Action() {
		// TODO Auto-generated constructor stub
	}


	public Action(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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


	@Override
	public String toString() {
		return "Action [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}
