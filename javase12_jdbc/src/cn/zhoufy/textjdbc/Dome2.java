package cn.zhoufy.textjdbc;
/**
 * 1.text the mysql language;
 * 2.Statement class;
 * 
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Dome2 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接(连接对象内部其实包含Socket对象，是一个远程连接，比较耗时，这是Connection兑现管理的一个要点)
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象；
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			
			/*Statement stmt=conn.createStatement();
			String sql="insert into t_user (uname,pwd,regtime) values ('赵六',666,now())";
			stmt.execute(sql);*/
			
			/*Statement stmt=conn.createStatement();
			String name="杨七";
			String sql="insert into t_user (uname,pwd,regtime) values ('"+name+"',777,now())";
			stmt.execute(sql);*/
			
			//测试sql注入，以及危险；不推荐使用Statement!!
			stmt=conn.createStatement();
			//String id=4+"";/delete the id=4;
			String id="5 or 1=1";
			String sql="delete from t_user where id="+id;
			stmt.execute(sql);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
