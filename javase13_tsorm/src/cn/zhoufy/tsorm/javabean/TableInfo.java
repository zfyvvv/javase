package cn.zhoufy.tsorm.javabean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息；
 * @author DELL
 *
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;
	/**
	 * 所有字段信息
	 */
	private Map<String,ColumnInfo> colums;
	/**
	 * 主键（有且只有一个）
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 如果联合主键，这储存在这里；
	 */
	private List<ColumnInfo> priKeys;
	
	
	public TableInfo() {
	}
	public TableInfo(String tname, Map<String, ColumnInfo> colums, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.colums = colums;
		this.onlyPriKey = onlyPriKey;
	}
	
	
	public TableInfo(String tname, List<ColumnInfo> priKeys,Map<String,ColumnInfo> colums) {
		super();
		this.tname = tname;
		this.priKeys = priKeys;
		this.colums=colums;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColums() {
		return colums;
	}
	public void setColums(Map<String, ColumnInfo> colums) {
		this.colums = colums;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
}
