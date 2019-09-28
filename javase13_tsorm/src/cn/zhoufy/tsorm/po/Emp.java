package cn.zhoufy.tsorm.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private java.sql.Date birthday;
	private String name;
	private Integer id;
	private Double salary;
	private String department;
	private Integer age;


	public java.sql.Date getBirthday(){
		return birthday;
	}
	public String getName(){
		return name;
	}
	public Integer getId(){
		return id;
	}
	public Double getSalary(){
		return salary;
	}
	public String getDepartment(){
		return department;
	}
	public Integer getAge(){
		return age;
	}
	public void setBirthday(java.sql.Date birthday){
		this.birthday=birthday;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setSalary(Double salary){
		this.salary=salary;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public void setAge(Integer age){
		this.age=age;
	}

}
