package cn.zhoufy.textjdbc;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Date;
/**
 * 1.Clob；文本大对象的使用 ；以流的方式进行处理；
 * 2.将文本，字符串插入到数据库的Clob字段中，以及从里面取出信息；
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

public class Dome9 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reader r=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			/*ps=conn.prepareStatement("insert into t_user (uname,pwd,userInfo) values (?,?,?)");
			ps.setString(1, "zfy1");
			ps.setString(2, "111");
			ps.setClob(3, new FileReader("E://java.txt"));//插入文件；
			ps.setClob(3, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaaaaaa".getBytes()))));
			ps.execute();*/
			ps=conn.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 41885);
			rs=ps.executeQuery();
			while(rs.next()) {
				Clob c=rs.getNClob("userInfo");
				r=c.getCharacterStream();
				int temp=0;
				while((temp=r.read())!=-1) {
					System.out.print((char)temp);//IO流，还需要多看看，多理解！
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(r!=null) {
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

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
