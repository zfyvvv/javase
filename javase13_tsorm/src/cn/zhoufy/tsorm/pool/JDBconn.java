package cn.zhoufy.tsorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zhoufy.tsorm.core.DBManager;

public class JDBconn {
	/**
	 * 连接池
	 */
	private  List<Connection> pool;
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE=DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE=DBManager.getConf().getPoolMinSize();
	/**
	 *初始化连接池，
	 */
	private void initPoll() {
		if(pool==null) {
			pool=new ArrayList<Connection>();
		}
		while(pool.size()<POOL_MIN_SIZE) {
			pool.add(DBManager.creatConnection());
			System.out.println("start Connection number:"+pool.size());
		}
		System.out.println("final Connection number:"+pool.size());
	}
	/**
	 * 获得Connection 连接
	 * @return
	 */
	public synchronized Connection getConnection() {//线程同步
		int last_index=pool.size()-1;
		Connection conn=pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	/**
	 * 将连接放回连接池中
	 * @param conn
	 */
	public synchronized void close(Connection conn) {
		if(pool.size()>POOL_MAX_SIZE) {
			try {
				if(conn!=null) {
				conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		pool.add(conn);
		}
	}
	
	
	
	
	/**
	 * 新建对象的时候，初始化！
	 */
	public JDBconn() {
		initPoll();
	}
	
	
	
	
}
