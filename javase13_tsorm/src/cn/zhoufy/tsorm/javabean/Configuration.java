package cn.zhoufy.tsorm.javabean;
/**
 * ����������Ϣ��
 * @author DELL
 *
 */
public class Configuration {
	/**
	 * ������
	 */
	private String driver;
	/**
	 * jdbc��url;
	 */
	private String url;
	/**
	 * ���ݿ��û���
	 */
	private String user;
	/**
	 * ���ݿ�����
	 */
	private String pwd;
	/**
	 * ����ʹ�õ����ݿ�
	 */
	private String usingDB;
	/**
	 * ��Ŀ��·��
	 */
	private String srcPath;
	/**
	 * ɨ������java��İ���po����˼��persistence object �־û�����
	 */
	private String poPackage;
	/**
	 * ��С���ӳ���
	 */
	private int poolMinSize;
	/**
	 * ������ӳ���
	 */
	private int poolMaxSize;
	/**
	 * ָ����ѯ����
	 */
	private String queryClass;
	
		public Configuration() {
		}

		public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
				String poPackage) {
			super();
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.pwd = pwd;
			this.usingDB = usingDB;
			this.srcPath = srcPath;
			this.poPackage = poPackage;
		}
		

		public int getPoolMinSize() {
			return poolMinSize;
		}

		public void setPoolMinSize(int poolMinSize) {
			this.poolMinSize = poolMinSize;
		}

		public int getPoolMaxSize() {
			return poolMaxSize;
		}

		public void setPoolMaxSize(int poolMaxSize) {
			this.poolMaxSize = poolMaxSize;
		}

		public String getDriver() {
			return driver;
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getUsingDB() {
			return usingDB;
		}

		public void setUsingDB(String usingDB) {
			this.usingDB = usingDB;
		}

		public String getSrcPath() {
			return srcPath;
		}

		public void setSrcPath(String srcPath) {
			this.srcPath = srcPath;
		}

		public String getPoPackage() {
			return poPackage;
		}

		public void setPoPackage(String poPackage) {
			this.poPackage = poPackage;
		}

		public String getQueryClass() {
			return queryClass;
		}

		public void setQueryClass(String queryClass) {
			this.queryClass = queryClass;
		}
		
		

}
