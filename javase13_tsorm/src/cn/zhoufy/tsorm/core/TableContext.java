package cn.zhoufy.tsorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.zhoufy.tsorm.javabean.ColumnInfo;
import cn.zhoufy.tsorm.javabean.TableInfo;
import cn.zhoufy.tsorm.util.JavaFilesUtils;
import cn.zhoufy.tsorm.util.StringUtils;

/**
 * ����������ݿ�ı�ṹ����ṹ�������ݱ�ṹ������ṹ��
 * @author DELL
 *
 */
public class TableContext {
	/**
	 * ����Ϊkey������Ϣ����Ϊvalue;
	 */
	public static Map<String,TableInfo> tables=new HashMap<String,TableInfo>();
	/**
	 * ��PO��class����ͱ���Ϣ�������������ڹ���
	 */
	public static  Map<Class,TableInfo> poClassTableMAP=new HashMap<Class,TableInfo>();
	
	private TableContext() {}
	static {
		try {
			Connection con=DBManager.getConnection();
			DatabaseMetaData dbmd=con.getMetaData();
			ResultSet tableRet=dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
			while(tableRet.next()) {
				String tableName=(String) tableRet.getObject("TABLE_NAME");//����-->emp
				TableInfo ti=new TableInfo(tableName,new ArrayList<ColumnInfo>()
						,new HashMap<String,ColumnInfo>());
				tables.put(tableName, ti);//tables �����
				
				ResultSet set=dbmd.getColumns(null, "%", tableName,"%");//����-->age id �Ƿ�Ϊ����
				while(set.next()) {
					ColumnInfo ci=new ColumnInfo(set.getString("COLUMN_NAME"),
							set.getString("TYPE_NAME"),0);
					ti.getColums().put(set.getString("COLUMN_NAME"), ci);
				}
				ResultSet set2=dbmd.getColumns(null, "%", tableName,"%");	
				while(set2.next()) {
					ColumnInfo ci2=ti.getColums().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPriKeys().add(ci2);
				}
				if(ti.getPriKeys().size()>0) {
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//������ṹ��
		updateJavaPOFile();
		//����PO�� ������࣬
		loadPOTables();
		
	}
	public static Map<String,TableInfo> getTableInfos(){
		return tables;
	}
	/**
	 * ���ݱ�ṹ������PO���µ�Java�࣬
	 * ʵ���˱�ṹת��Ϊ��ṹ��
	 */
	public static void updateJavaPOFile() {
		Map<String,TableInfo> map=TableContext.getTableInfos();
		for(TableInfo t:map.values()) {
		JavaFilesUtils.creatJavaPOFile(t,new MysqlTypeConvertor());
		}
	}
	/**
	 * ����PO�� ������࣬
	 */
	public static void loadPOTables() {
		for(TableInfo tableInfo:tables.values()) {//tables ����ʱ�����
			try {
				Class c=Class.forName(DBManager.getConf().getPoPackage()+"."
				 +StringUtils.fistChar2UpCase(tableInfo.getTname()));
				poClassTableMAP.put(c, tableInfo);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
	public static void main(String[] args) {
		Map<String,TableInfo> tables=getTableInfos();
		System.out.println(tables);
	}

}
