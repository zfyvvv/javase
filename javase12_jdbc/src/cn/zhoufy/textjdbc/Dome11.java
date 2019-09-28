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
 * 1.Blob；使用JCBCUtil封装好的数操作数据库；
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

import cn.zhoufy.textjdbc.JDBCUtil;

public class Dome11 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCUtil.getMysqlConnection();
			ps=conn.prepareStatement("insert into t_user (id,uname,pwd) values (?,?,?)");
			ps.setObject(1, 1);
			ps.setObject(2, "zfy1");
			ps.setObject(3, 111);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JDBCUtil.close(conn, ps);
	}
	}
}

