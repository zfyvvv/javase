package cn.zhoufy.tsorm.core;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

import cn.zhoufy.tsorm.javabean.Configuration;
import cn.zhoufy.tsorm.pool.JDBconn;

/**
 * 根据配置信息，完成连接对象的管理（增加连接池功能）
 * @author DELL
 *
 */
public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf;
	private static JDBconn pool=null;
	static {
		Properties pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conf=new  Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setPoPackage(pros.getProperty("poPackagePath"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		
		System.out.println(TableContext.class);
		
	}
	/**
	 * 获得connection对象；
	 * @return
	 */
	public static Connection getConnection() {
		if(pool==null) {
			pool=new JDBconn();
		}
		return (Connection) pool.getConnection();
	}
	/**
	 * 创建新的connection对象；
	 * @return
	 */
	public static Connection creatConnection() {
		//Connection conn=null;
		try {
			Class.forName(conf.getDriver());
			Connection conn=(Connection) DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());//目前直接连接，后期添连接池；
			return conn;
			/*Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
			return conn;*/
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭Connection对象；
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null) {
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
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			pool.close(conn);
		}
	}
	
	/**
	 * 关闭connection 对象
	 * @param conn
	 * @param ps
	 */
	public static void close(Connection conn,PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			pool.close(conn);
		}
	}
	/**
	 * 关闭connection 对象；
	 * @param conn
	 */
	public static void close(Connection conn) {
		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			pool.close(conn);
		}
	}
	public static Configuration getConf() {
		return conf;
	}
	public static void setConf(Configuration conf) {
		DBManager.conf = conf;
	}
	
	

}
