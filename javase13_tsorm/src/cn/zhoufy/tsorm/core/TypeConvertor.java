package cn.zhoufy.tsorm.core;
/**
 * �������ݿ��������ͺ�java��������ת����
 * @author DELL
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ�����ת����java��������
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * ��java��������ת�������ݿ��������ݣ�
	 * @param javaType
	 * @return
	 */
	public String javaType2DatabaseType(String javaType);
}
