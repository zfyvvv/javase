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
		try {//���������ࣻ
			Class.forName("com.mysql.jdbc.Driver");
			//��������(���Ӷ����ڲ���ʵ����Socket������һ��Զ�����ӣ��ȽϺ�ʱ������Connection���ֹ����һ��Ҫ��)
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			
			/*Statement stmt=conn.createStatement();
			String sql="insert into t_user (uname,pwd,regtime) values ('����',666,now())";
			stmt.execute(sql);*/
			
			/*Statement stmt=conn.createStatement();
			String name="����";
			String sql="insert into t_user (uname,pwd,regtime) values ('"+name+"',777,now())";
			stmt.execute(sql);*/
			
			//����sqlע�룬�Լ�Σ�գ����Ƽ�ʹ��Statement!!
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
