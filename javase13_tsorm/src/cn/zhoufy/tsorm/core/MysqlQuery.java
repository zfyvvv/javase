package cn.zhoufy.tsorm.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;


import cn.zhoufy.tsorm.javabean.ColumnInfo;
import cn.zhoufy.tsorm.javabean.TableInfo;
import cn.zhoufy.tsorm.po.Emp;
import cn.zhoufy.tsorm.util.JDBCUtils;
import cn.zhoufy.tsorm.util.RefUtils;
import cn.zhoufy.tsorm.util.StringUtils;

public class MysqlQuery extends Query{
	public static void textDML() {//执行DML语言，对数据库原始数据进行操作
		Emp e=new Emp();
		e.setId(4);
		e.setAge(10);
		e.setName("zhangsan!！！！！");
		e.setSalary(300.0);//
		//new MysqlQuery().delete(e);
		new MysqlQuery().update(e, new String[] {"name","age","salary"});
		
	}
	public static void test1() {//查询多个对象的多个属性，
		List<Emp> list=new MysqlQuery().queryRows("select id,name,salary from emp where age>?",
				Emp.class,new Object[] {15});
		System.out.println(list);
		for(Emp e:list) {
			System.out.println(e.getName());
		}
	}
	public static void test2() {//查询符合条件字段的个数；list.size();
		Object obj=new MysqlQuery().queryValue("select count(*) from emp where id>?", new Object[] {1});
		System.out.println(obj);//查询符合条件字段的个数；
	}
	public static void test3() {//查询符合条件字段的对象；list.size();直接给出int
		Object obj=new MysqlQuery().queryNumber("select * from emp where id=?", new Object[] {1});
		System.out.println(obj);
	}
	public static void main(String[] args) {
		test2();
	}
	
	
	
	@Override
	public Object queryPagenate(int pagNum, int size) {//不同数据库中的分页查询方式不一样，
		// TODO Auto-generated method stub
		return null;
	}
}