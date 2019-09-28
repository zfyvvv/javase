package cn.zhoufy.tsorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zhoufy.tsorm.core.DBManager;

public class JDBconn {
	/**
	 * ���ӳ�
	 */
	private  List<Connection> pool;
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE=DBManager.getConf().getPoolMaxSize();
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE=DBManager.getConf().getPoolMinSize();
	/**
	 *��ʼ�����ӳأ�
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
	 * ���Connection ����
	 * @return
	 */
	public synchronized Connection getConnection() {//�߳�ͬ��
		int last_index=pool.size()-1;
		Connection conn=pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	/**
	 * �����ӷŻ����ӳ���
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
	 * �½������ʱ�򣬳�ʼ����
	 */
	public JDBconn() {
		initPoll();
	}
	
	
	
	
}
