package cn.zhoufy.textjdbc;
/**
 *1.测试批处理；
 *2.Betch()!!
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Dome5 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			conn.setAutoCommit(false);//手动提交
			long start=System.currentTimeMillis();
			stmt=conn.createStatement();
			for(int i=0;i<20000;i++) {
				stmt.addBatch("insert into t_user (uname,pwd,regtime) values ('zhou"+i+"',666,now())");
			}
			stmt.executeBatch();
			conn.commit();//提交事务
			long end=System.currentTimeMillis();
			System.out.println("timesonsuming:"+(end-start));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
