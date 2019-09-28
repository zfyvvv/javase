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
		try {//���������ࣻ
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//��������(���Ӷ����ڲ���ʵ����Socket������һ��Զ�����ӣ��ȽϺ�ʱ������Connection���ֹ����һ��Ҫ��)
			//���������У�Ϊ�����Ч�ʣ�����ʹ���½�����������Ӷ���
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
