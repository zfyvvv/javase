package cn.zhoufy.tsorm.javabean;
/**
 * ��װ����һ���ֶ� ����Ϣ��
 * @author DELL
 *
 */
public class ColumnInfo {
	/**
	 * �ֶ�����
	 */
	private String name;
	/**
	 * �ֶ���������
	 */
	private String dataType;
	/**
	 * �ֶμ����ͣ�0-->��ͨ����1-->������2-->�����
	 */
	private int keyType;
	
	public ColumnInfo() {
		
	}
	public ColumnInfo(String name, String dataType, int keyType) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.keyType = keyType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getKeyType() {
		return keyType;
	}
	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}
}
