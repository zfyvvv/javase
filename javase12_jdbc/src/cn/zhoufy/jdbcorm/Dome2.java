package cn.zhoufy.jdbcorm;
/**
 * 1.使用Object[]数组封装一条数据；
 * 2.ArrayList<Map<String,Object>>();
 * 3.Map<String,<Map<String,Object>>()
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dome2 {
	public static void text1() {
	Connection conn=JDBCUtil.getMysqlConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	try {
		ps=conn.prepareStatement("select name,age,salary from emp where id>? ");
		ps.setObject(1, 1);
		rs=ps.executeQuery();
		while(rs.next()) {
			Map map=new HashMap<String,Object>();
			map.put("name", rs.getObject(1));
			map.put("age", rs.getObject(2));
			map.put("salary", rs.getObject(3));
			list.add(map);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, ps, rs);
	}
	for(Map<String,Object> map:list) {
		for(String key:map.keySet()) {//遍历MAP就是遍历这一行的信息；
		System.out.print(key+"--"+map.get(key)+"\t");
	}
		System.out.println();
	}
	
	/*Set set=map.keySet();
	Iterator iter=set.iterator();
	while(iter.hasNext()) {
		String key=(String)iter.next();
		System.out.print(map.get(key));
	}*/
		
	}
	public static void text2() {
		Connection conn=JDBCUtil.getMysqlConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String,Map<String,Object>> mapp=new HashMap<String,Map<String,Object>>();
		try {
			ps=conn.prepareStatement("select id,name,age,salary from emp where id>? ");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()) {
				Map map=new HashMap<String,Object>();
				map.put("name", rs.getObject(2));
				map.put("age", rs.getObject(3));
				map.put("salary", rs.getObject(4));
				mapp.put(rs.getObject(1).toString(), map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
		for(String keyp:mapp.keySet()) {
			for(String key:mapp.get(keyp).keySet()) {//遍历MAP就是遍历这一行的信息；
			System.out.print(key+"--"+mapp.get(keyp).get(key)+"\t");
		}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//text1();
		text2();
	}

}
