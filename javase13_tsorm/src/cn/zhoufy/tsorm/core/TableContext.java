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
 * 负责管理数据库的表结构和类结构，并根据表结构生成类结构；
 * @author DELL
 *
 */
public class TableContext {
	/**
	 * 表名为key，表信息对象为value;
	 */
	public static Map<String,TableInfo> tables=new HashMap<String,TableInfo>();
	/**
	 * 将PO的class对象和表信息关联起来，便于管理；
	 */
	public static  Map<Class,TableInfo> poClassTableMAP=new HashMap<Class,TableInfo>();
	
	private TableContext() {}
	static {
		try {
			Connection con=DBManager.getConnection();
			DatabaseMetaData dbmd=con.getMetaData();
			ResultSet tableRet=dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
			while(tableRet.next()) {
				String tableName=(String) tableRet.getObject("TABLE_NAME");//表名-->emp
				TableInfo ti=new TableInfo(tableName,new ArrayList<ColumnInfo>()
						,new HashMap<String,ColumnInfo>());
				tables.put(tableName, ti);//tables 已填充
				
				ResultSet set=dbmd.getColumns(null, "%", tableName,"%");//列名-->age id 是否为主键
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
		
		//更新类结构；
		updateJavaPOFile();
		//加载PO包 下面的类，
		loadPOTables();
		
	}
	public static Map<String,TableInfo> getTableInfos(){
		return tables;
	}
	/**
	 * 根据表结构，更新PO包下的Java类，
	 * 实现了表结构转化为类结构；
	 */
	public static void updateJavaPOFile() {
		Map<String,TableInfo> map=TableContext.getTableInfos();
		for(TableInfo t:map.values()) {
		JavaFilesUtils.creatJavaPOFile(t,new MysqlTypeConvertor());
		}
	}
	/**
	 * 加载PO包 下面的类，
	 */
	public static void loadPOTables() {
		for(TableInfo tableInfo:tables.values()) {//tables 启动时已填充
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
