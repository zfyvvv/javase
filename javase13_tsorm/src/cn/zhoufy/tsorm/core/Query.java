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
	 * ģ�巽��ģʽ��������������ã�queryrows() and queryvalue()  jdbc�����ã�
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
	 * ֱ��ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql����Ӱ��ļ�¼����
	 */
	public int executeDML(String sql,Object[] params) {
		Connection conn=DBManager.getConnection();
		int count=0;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			//��sql��䴫��
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
	 * ��һ�����󴢴浽���ݿ��У�
	 * @param obj
	 */
	public void insert(Object obj){
		//obj-->���У�  insert into ���� ��id,name,pwd�� values (?,?,?)
		Class c=obj.getClass();
		List<Object> params=new ArrayList<Object>();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);//��ñ����Ϣ���������ֶ���Ϣ��emp��emp�е�id name age soso
		StringBuilder sql=new StringBuilder("insert into "+tableInfo.getTname()+" (");
		int conutNotNullFiled=0;
		Field[] fs=c.getDeclaredFields();
		for(Field f:fs) {
			String fieldName=f.getName();//�����������
			Object fieldValue=RefUtils.invokeGet(fieldName, obj);//ͨ�������ø�������Ե�ֵ���������sql����ռλ����ֵ��
			
			if(fieldValue!=null) {
				conutNotNullFiled++;
				sql.append(fieldName+",");//ƴ��sql���
				params.add(fieldValue);//���ֵ��
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
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼�����������ڵ����Ӧ�������������Ӧ����¼����
	 * @param obj
	 */
	public void delete(Object obj){
		Class c=obj.getClass();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);
		ColumnInfo onlyPriKey=tableInfo.getOnlyPriKey();//��ñ������������Ե����ݣ�
		//ͨ�����䣬������Ե�get() or set();
		Object priKeyValue=RefUtils.invokeGet(onlyPriKey.getName(), obj);//ͨ��������������������name�������ݣ�
		delete(c,priKeyValue);
		
	}
	
	/**
	 * ɾ��clazz�����Ӧ�ı��еļ�¼��ָ������id�ļ�¼��
	 * @param clazz
	 * @param id
	 */
	public void delete(Class clazz,Object obj){
		//Emp 2-->delete from emp where id=2;
		//ͨ��class������TableInfo
		TableInfo tableInfo=TableContext.poClassTableMAP.get(clazz);
		//�������
		ColumnInfo onlyPriKey=tableInfo.getOnlyPriKey();//��ø��ֶε�������     
		String sql="delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		executeDML(sql,new Object[] {obj});                      // ���������ƣ���������һ����id;��
	}
	
	/**
	 * ���¶����Ӧ�ļ�¼����ֻ����ָ���ֶε�ֵ��
	 * @param obj
	 * @param filedNames
	 * @return
	 */
	public int  update(Object obj,String[] fieldNames) {//update user set name=? and id=?;
		//objetc{"name","pwd"}-->update ���� set name=?,pwd=? where id=?;
		Class c=obj.getClass();
		List<Object> params=new ArrayList<Object>();
		TableInfo tableInfo=TableContext.poClassTableMAP.get(c);
		StringBuilder sql=new StringBuilder("update "+tableInfo.getTname()+" set ");
		ColumnInfo priKey=tableInfo.getOnlyPriKey();//Ψһ����
		for(String fname:fieldNames) {
			Object fvalue=RefUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName()+"=?");
		params.add(RefUtils.invokeGet(priKey.getName(), obj));//���������Ĳ�����
		return executeDML(sql.toString(),params.toArray());

	}
	
	/**
	 * ��ѯ�����¼��������¼��װ��ָ����clazz�����У�
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
					Object rowObj=clazz.newInstance();//����javabean���޲ι�������
					//����
					for(int i=0;i<metaData.getColumnCount();i++) {
						String columnName=metaData.getColumnLabel(i+1);//username
						Object columnValue=rs.getObject(i+1);//value!
						//����rowOBject�����setUsername(String name)��������columnValue��ֵ���ý�ȥ��
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
	 * ��ѯһ�м�¼�������ö����װ��clazz�����У���
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params){//����һ������
		List list=queryRows(sql,clazz,params);
		return (list==null||list.size()>0)?null:list.get(0);
	}
	
	/**
	 * ��ѯһ��ֵ��������ֵ���أ�һ��һ�У�
	 * @param sql
	 * @param params
	 * @return
	 */
	
	public Object queryValue(String sql,Object[] params){//���һ��ֵ��
		
		return executeQueryTemplate(sql,params,null,new CallBack() {

			@Override
			public Object doExecute(java.sql.Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value=null;
				try {
					while(rs.next()) {
						value=rs.getObject(1);//��ñ��е�һ�еĵ�һ�У�
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				return value;//ʵ����Ϊlist.size();
			}});	
	}
	
	/**
	 * ��ѯһ�����֣����������ֵ����һ��һ�У�
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql,Object[] params){//��ѯ����������ֵ�����ֶεĸ�����
		return (Number)queryValue(sql,params);//��ñ��е�һ�еĵ�һ�У������Ѿ�ת��Number���ͣ�
	}
	
	/**
	 * ��ҳ��ѯ����ͬ�����ݿ��з�ҳ��ѯ�ķ�ʽ��һ����
	 * @param pagNum
	 * @param size
	 * @return
	 */
	public abstract Object queryPagenate(int pagNum,int size);

}
