package cn.zhoufy.textjdbc;
/**
 * 1.text the mysql language;
 * 2.PreparedStatement class;
 * 3.ps.executeUpdate();
 * 
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Dome3 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			
			String sql="insert into t_user (uname,pwd,regtime) values (?,?,?)";//占位符
			ps=conn.prepareStatement(sql);
			/*ps.setString(1, "张三");//索引系数从1开始计算，
			ps.setString(2, "111");
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			ps.execute();*/
			ps.setObject(1, "wangwu");//避免判断，直接使用Object;
			ps.setObject(2, 555);
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			//ps.execute();
			int count=ps.executeUpdate();
			System.out.println(count);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
