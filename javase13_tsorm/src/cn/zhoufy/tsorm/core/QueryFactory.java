package cn.zhoufy.tsorm.core;

public class QueryFactory {
	//public Query creatQuery();
	//通过反射&单例模式，获得query object;
	private static QueryFactory factory=new QueryFactory();//工厂类只有一个，单例模式
	//private static Query prototypeObj;//原型对象,可以通过克隆模式去new query object;
	private static Class c;
	static {
		try {
			c=Class.forName(DBManager.getConf().getQueryClass());//加载指定的query类；
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private QueryFactory() {//私有构造器
	}
	public static Query creatQuery() {
		try {
			return (Query) c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
