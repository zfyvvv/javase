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
 * 1.ʹ����Դ�����ļ�����������ݿ�ı�ʱ��ֻ��Ҫͨ���ı������ļ����ɣ�����Ҫ�ı�Դ�룻��
 * 2.
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
import java.util.Properties;
import java.util.Random;

import com.mysql.jdbc.Connection;

public class JDBCUtil {
	static Properties pros=null;//������ȡ�ʹ�����Դ�ļ��е���Ϣ��
	static {//����JDBCUtil���ʱ�����
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getMysqlConnection() {
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			Connection conn=(Connection) DriverManager.getConnection(((String)pros.get("mysqlURL")),
					((String)pros.get("mysqlUserName")),((String)pros.get("mysqlPWD")));
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null) {//ResultSet-->Statement-->Connection;
			try {
				rs.close();
			} catch (SQLException e) {
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
	
	public static void close(Connection conn,PreparedStatement ps) {
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
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
