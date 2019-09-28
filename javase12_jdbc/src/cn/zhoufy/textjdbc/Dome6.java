package cn.zhoufy.textjdbc;
/**
 * 1.事务的原子性；
 * 2.
 * 
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Dome6 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			conn.setAutoCommit(false);
			ps1=conn.prepareStatement("insert into t_user (uname,pwd) values (?,?)");
			ps1.setObject(1, "wangwu");
			ps1.setObject(2, 555);
			ps1.execute();
			System.out.println("wangwu is ok!");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//ps2=conn.prepareStatement("insert into t_user (uname,pwd) values (?,?)");
			ps2=conn.prepareStatement("insert into t_user (uname,pwd) values (?,?,?)");
			ps2.setObject(1, "zhaoliu");
			ps2.setObject(2, 666);
			ps2.execute();
			System.out.println("zhaoliu is ok!");
			conn.commit();
			
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
			if(ps2!=null) {
				try {
					ps2.close();
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
