package cn.zhoufy.tsorm.core;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import cn.zhoufy.tsorm.javabean.ColumnInfo;
import cn.zhoufy.tsorm.javabean.TableInfo;
import cn.zhoufy.tsorm.util.JDBCUtils;
import cn.zhoufy.tsorm.util.RefUtils;

public abstract class Query {
	/**
	 * 模板方法模式，将代码进行重用；queryrows() and queryvalue()  jdbc的重用！
	 * @param sql
	 * @param params
	 * @param clazz
	 * @param back
	 * @return
	 */
	public Object executeQueryTemplate(String sql,Object[] params,Class clazz,CallBack back) {
		Connection conn=DBManager.getConnection();
		List list=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs=ps.executeQuery();
			return back.doExecute(conn, ps, rs);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBManager.close(conn, ps);
		}
		
		
	}
	
	/**
	 * 直接执行一个DML语句
	 * @param sql
	 * @param params
	 * @return 执行sql语句后影响的记录行数
	 */
	public int executeDML(String sql,Object[] params) {
		Connection conn=DBManager.getConnection();
		int count=0;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			//给sql语句传参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		return count;
		
	};
	/**
	 * 将一个对象储存到数据库中，
	 * @param obj
	 */
	public void insert(Object obj){
		//obj-->表中，  insert into 表名 （id,name,pwd） values (?,?,?)
		Class c=obj.getClass();
		List<Object> params=new ArrayList<Object>();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);//获得表的信息，表名和字段信息：emp和emp中的id name age soso
		StringBuilder sql=new StringBuilder("insert into "+tableInfo.getTname()+" (");
		int conutNotNullFiled=0;
		Field[] fs=c.getDeclaredFields();
		for(Field f:fs) {
			String fieldName=f.getName();//类的属性名字
			Object fieldValue=RefUtils.invokeGet(fieldName, obj);//通过反射获得该类该属性的值，方面后续sql语句给占位符赋值；
			
			if(fieldValue!=null) {
				conutNotNullFiled++;
				sql.append(fieldName+",");//拼接sql语句
				params.add(fieldValue);//添加值；
			}
		}
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values (");
		for(int i=0;i<conutNotNullFiled;i++) {
			sql.append("?,");//,,,,,,
		}
		sql.setCharAt(sql.length()-1, ')');
		
		executeDML(sql.toString(),params.toArray());
		
	}
	
	/**
	 * 删除对象在数据库中对应的记录，（对象所在的类对应表，对象的主键对应到记录！）
	 * @param obj
	 */
	public void delete(Object obj){
		Class c=obj.getClass();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);
		ColumnInfo onlyPriKey=tableInfo.getOnlyPriKey();//获得表对象的主键属性的内容；
		//通过反射，获得属性的get() or set();
		Object priKeyValue=RefUtils.invokeGet(onlyPriKey.getName(), obj);//通过反射获得主键这个对象的name属性内容；
		delete(c,priKeyValue);
		
	}
	
	/**
	 * 删除clazz对象对应的表中的记录（指定主键id的记录）
	 * @param clazz
	 * @param id
	 */
	public void delete(Class clazz,Object obj){
		//Emp 2-->delete from emp where id=2;
		//通过class对象找TableInfo
		TableInfo tableInfo=TableContext.poClassTableMAP.get(clazz);
		//获得主键
		ColumnInfo onlyPriKey=tableInfo.getOnlyPriKey();//获得该字段的主键；     
		String sql="delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		executeDML(sql,new Object[] {obj});                      // 主键的名称；（主键不一定是id;）
	}
	
	/**
	 * 更新对象对应的记录，并只更新指定字段的值；
	 * @param obj
	 * @param filedNames
	 * @return
	 */
	public int  update(Object obj,String[] fieldNames) {//update user set name=? and id=?;
		//objetc{"name","pwd"}-->update 表名 set name=?,pwd=? where id=?;
		Class c=obj.getClass();
		List<Object> params=new ArrayList<Object>();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);
		StringBuilder sql=new StringBuilder("update "+tableInfo.getTname()+" set ");
		ColumnInfo priKey=tableInfo.getOnlyPriKey();//唯一主键
		for(String fname:fieldNames) {
			Object fvalue=RefUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName()+"=?");
		params.add(RefUtils.invokeGet(priKey.getName(), obj));//设置主键的参数！
		return executeDML(sql.toString(),params.toArray());

	}
	
	/**
	 * 查询多项记录，并将记录封装到指定的clazz对象中，
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List queryRows(String sql,Class clazz,Object[] params){
		
		return (List) executeQueryTemplate(sql,params,clazz,new CallBack() {
			@Override
			public Object doExecute(java.sql.Connection conn, PreparedStatement ps, ResultSet rs) {
				ResultSetMetaData metaData=null;
				List list=null;
				try {
					metaData = rs.getMetaData();
				while(rs.next()) {
					if(list==null) {
						list=new ArrayList();
					}
					Object rowObj=clazz.newInstance();//调用javabean的无参构造器；
					//多列
					for(int i=0;i<metaData.getColumnCount();i++) {
						String columnName=metaData.getColumnLabel(i+1);//username
						Object columnValue=rs.getObject(i+1);//value!
						//调用rowOBject对象的setUsername(String name)方法，将columnValue的值设置进去；
						RefUtils.invokeSet(rowObj, columnName, columnValue);
					}
					list.add(rowObj);
					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				return list;
			}
		});
		
		
	}
	
	/**
	 * 查询一行记录，并将该对象封装到clazz对象中（）
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params){//返回一个对象；
		List list=queryRows(sql,clazz,params);
		return (list==null||list.size()>0)?null:list.get(0);
	}
	
	/**
	 * 查询一个值，并将该值返回（一行一列）
	 * @param sql
	 * @param params
	 * @return
	 */
	
	public Object queryValue(String sql,Object[] params){//获得一个值；
		
		return executeQueryTemplate(sql,params,null,new CallBack() {

			@Override
			public Object doExecute(java.sql.Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value=null;
				try {
					while(rs.next()) {
						value=rs.getObject(1);//获得表中第一行的第一列！
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				return value;//实际上为list.size();
			}});	
	}
	
	/**
	 * 查询一个数字，并返回这个值；（一行一列）
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql,Object[] params){//查询符合条件的值，即字段的个数；
		return (Number)queryValue(sql,params);//获得表中第一行的第一列！并且已经转成Number类型；
	}
	
	/**
	 * 分页查询，不同的数据库中分页查询的方式不一样；
	 * @param pagNum
	 * @param size
	 * @return
	 */
	public abstract Object queryPagenate(int pagNum,int size);

}
