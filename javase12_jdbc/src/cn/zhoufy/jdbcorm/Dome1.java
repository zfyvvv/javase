package cn.zhoufy.jdbcorm;
/**
 * 1.使用Object[]数组封装一条数据；
 * 2.new ArrayList<Object[]>()
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dome1 {
	public static void main(String[] args) {
		Connection conn=JDBCUtil.getMysqlConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			ps=conn.prepareStatement("select * from emp where id>? ");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Object[] objs=new Object[4];
				objs[0]=rs.getObject(1);
				objs[1]=rs.getObject(2);
				objs[2]=rs.getObject(3);
				objs[3]=rs.getObject(4);
				list.add(objs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
		
		for(Object[] temp:list) {
			System.out.println("iformation:"+temp[0]+"--"+temp[1]+"--"+temp[2]+"--"+temp[3]);
		}
		
	}

}
