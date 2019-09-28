package cn.zhoufy.tsorm.core;
/**
 * 负责数据库数据类型和java类型数据转换；
 * @author DELL
 *
 */
public interface TypeConvertor {
	/**
	 * 将数据库类型转换成java数据类型
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * 将java数据类型转换成数据库类型数据；
	 * @param javaType
	 * @return
	 */
	public String javaType2DatabaseType(String javaType);
}
