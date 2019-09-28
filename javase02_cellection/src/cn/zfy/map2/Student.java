package cn.zfy.map2;
/**
 * 1、学生对象，封装学生相关的姓名，班级，分数等属性；
 * @author DELL
 *
 */
public class Student {
	private String name;
	private String no;
	private double score;
	
	
	public Student() {
		super();
	}
	public Student(String name, String no, double score) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
} 
