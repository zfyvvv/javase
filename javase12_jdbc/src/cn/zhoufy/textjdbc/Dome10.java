package cn.zhoufy.textjdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
/**
 * 1.Blob；二进制大对象的使用 ；以流的方式进行处理；
 * 2.将图片插入到数据库的Clob字段中，以及从里面取出信息；
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

public class Dome10 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		InputStream is=null;
		FileOutputStream fos=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			/*ps=conn.prepareStatement("insert into t_user (uname,pwd,headImg) values (?,?,?)");
			ps.setString(1, "zfy2");
			ps.setString(2, "222");
			ps.setBlob(3, new FileInputStream("E://aaa.jpg"));
			ps.execute();*/
			ps=conn.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 41886);
			rs=ps.executeQuery();
			while(rs.next()) {
				Blob b=rs.getBlob("headImg");
				is=b.getBinaryStream();
				fos=new FileOutputStream("E://bbb.jpg");
				int temp=0;
				while((temp=is.read())!=-1) {
					fos.write(temp);
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
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					is.close();
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
