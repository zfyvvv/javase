package cn.zfy.map2;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、班级对象，封装了班级，学生和总分数等班级的属性；
 * @author DELL
 *
 */
public class ClassRoom {
	private String no;
	private List<Student> stulist;
	private double total;
	
	public ClassRoom() {
		super();
		stulist=new ArrayList();
	}
	public ClassRoom(String no) {
		this();
		this.no=no;
	}
	public ClassRoom(String no, List<Student> stulist, double total) {
		super();
		this.no = no;
		this.stulist = stulist;
		this.total = total;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStulist() {
		return stulist;
	}
	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
