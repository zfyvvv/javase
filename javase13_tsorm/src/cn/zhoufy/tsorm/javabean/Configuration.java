package cn.zhoufy.tsorm.javabean;
/**
 * 管理配置信息；
 * @author DELL
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver;
	/**
	 * jdbc的url;
	 */
	private String url;
	/**
	 * 数据库用户名
	 */
	private String user;
	/**
	 * 数据库密码
	 */
	private String pwd;
	/**
	 * 正在使用的数据库
	 */
	private String usingDB;
	/**
	 * 项目的路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包（po的意思是persistence object 持久化对象）
	 */
	private String poPackage;
	/**
	 * 最小连接池数
	 */
	private int poolMinSize;
	/**
	 * 最大连接池数
	 */
	private int poolMaxSize;
	/**
	 * 指定查询的类
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
