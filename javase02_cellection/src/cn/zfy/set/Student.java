package cn.zfy.set;

public class Student {
	private String name;
	private int score;
	public Student() {
		super();
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		
		return "姓名："+this.name+";\t"+"学生分数"+this.score+"\n";
	}
	

}
