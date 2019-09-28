package cn.zhoufy.textjdbc;
import java.sql.Date;
/**
 * 1.事务的原子性；
 * 2.
 * 
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;

import com.mysql.jdbc.Connection;

public class Dome7 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps1=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			for(int i=0;i<100;i++) {
			ps1=conn.prepareStatement("insert into t_user (uname,pwd,regTime,lastLoginTime) values (?,?,?,?)");
			ps1.setObject(1, "wangwu"+i);
			ps1.setObject(2, 555);
			int random=100000000+new Random().nextInt(100000000);
			Date date=new java.sql.Date(System.currentTimeMillis()-random);
			Timestamp stamp=new Timestamp(System.currentTimeMillis()-random);
			ps1.setObject(3, date);
			ps1.setObject(4, stamp);
			ps1.execute();
			}
			System.out.println("wangwu is ok!");
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(ps1!=null) {
				try {
					ps1.close();
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
