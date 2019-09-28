package cn.zhoufy.jdbcorm;
/**
 * 1.使用javabeam封装一条数据；
 * 2.ArrayList<javabean>();
 * 3.使用的较多！！！1
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dome3 {
	public static void text1() {
	Connection conn=JDBCUtil.getMysqlConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	Emp emp=null;
	try {
		ps=conn.prepareStatement("select id,name,age,salary from emp where id=? ");
		ps.setObject(1, 1);
		rs=ps.executeQuery();
		while(rs.next()) {
			emp=new Emp(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getDouble("salary"));
		}
		System.out.println(emp.getId()+"--"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, ps, rs);
	}
	
	
	}
	public static void text2() {
		Connection conn=JDBCUtil.getMysqlConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Emp> list=new ArrayList<Emp>();
		Emp emp=null;
		try {
			ps=conn.prepareStatement("select id,name,age,salary from emp where id>? ");
			ps.setObject(1, 0);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp=new Emp(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getDouble("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
		for(Emp temp:list) {
			System.out.println(temp.getId()+"--"+temp.getName()+"--"+temp.getAge()+"--"+temp.getSalary());
		}
	}
	
	public static void main(String[] args) {
		//text1();
		text2();
	}

}
