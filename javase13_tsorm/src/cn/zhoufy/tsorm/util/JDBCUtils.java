package cn.zhoufy.tsorm.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装JDBC常用的操作；
 * @author DELL
 *
 */
public class JDBCUtils {
	/**
	 * 给sql设参
	 * @param ps
	 * @param params
	 */
	public static void handleParams(PreparedStatement ps,Object[] params) {
		try {
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
}
