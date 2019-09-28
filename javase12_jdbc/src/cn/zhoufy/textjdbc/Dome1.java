package cn.zhoufy.textjdbc;
/**
 * 1.establish and text the connection between java and database by a Socket,
 * 
 */
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Dome1 {
	public static void main(String[] args) {
		Connection conn=null;
		try {//加载驱动类；
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//建立连接(连接对象内部其实包含Socket对象，是一个远程连接，比较耗时，这是Connection兑现管理的一个要点)
			//真正开发中，为了提高效率，都会使用谅解吃来管理连接对象；
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			long end=System.currentTimeMillis();
			System.out.println(conn);
			System.out.println("timesuming-->"+(end-start));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
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
