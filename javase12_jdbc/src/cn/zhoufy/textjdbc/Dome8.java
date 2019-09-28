package cn.zhoufy.textjdbc;
import java.sql.Date;
/**
 * 1.按时间段查数据；
 * 2.
 * 
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.mysql.jdbc.Connection;

public class Dome8 {
	public static long str2Date(String dateStr) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			ps=conn.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime <?");
			ps.setObject(1, new java.sql.Timestamp(str2Date("2019-2-22 08:00:00")));
			ps.setObject(2, new java.sql.Timestamp(str2Date("2019-2-22 10:00:00")));
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getTimestamp("lastLoginTime"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(ps!=null) {
				try {
					ps.close();
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
