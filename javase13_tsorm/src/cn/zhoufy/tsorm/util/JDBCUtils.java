package cn.zhoufy.tsorm.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��װJDBC���õĲ�����
 * @author DELL
 *
 */
public class JDBCUtils {
	/**
	 * ��sql���
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
