package cn.zhoufy.tsorm.javabean;
/**
 * ��װ��Java�����Լ����Ե�set()��get()������
 * @author DELL
 *
 */
public class JavaFileSetGet {
	/**
	 * ���Ե�Դ�룺private int userId;
	 */
	private String fileInfo;
	/**
	 * get()��Դ�룺public void  getuserId(){}
	 */
	private String setInfo;
	/**
	 * set()��Դ�룺public void  setuserId(int id){this.id=id;}
	 */
	private String getInfo;
	@Override
	public String toString() {
		System.out.println(fileInfo);
		System.out.println(getInfo);
		System.out.println(setInfo);
		return super.toString();
	}
	public JavaFileSetGet() {
	}
	public JavaFileSetGet(String fileInfo, String setInfo, String getInfo) {
		super();
		this.fileInfo = fileInfo;
		this.setInfo = setInfo;
		this.getInfo = getInfo;
	}
	public String getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}

}
