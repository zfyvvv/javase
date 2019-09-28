package cn.zhoufy.tsorm.po;

import java.sql.*;
import java.util.*;

public class Deparment {

	private String name;
	private String adress;
	private Integer department;


	public String getName(){
		return name;
	}
	public String getAdress(){
		return adress;
	}
	public Integer getDepartment(){
		return department;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAdress(String adress){
		this.adress=adress;
	}
	public void setDepartment(Integer department){
		this.department=department;
	}

}
