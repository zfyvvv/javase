package cn.zhoufy.tsorm.core;

public class QueryFactory {
	//public Query creatQuery();
	//ͨ������&����ģʽ�����query object;
	private static QueryFactory factory=new QueryFactory();//������ֻ��һ��������ģʽ
	//private static Query prototypeObj;//ԭ�Ͷ���,����ͨ����¡ģʽȥnew query object;
	private static Class c;
	static {
		try {
			c=Class.forName(DBManager.getConf().getQueryClass());//����ָ����query�ࣻ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private QueryFactory() {//˽�й�����
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
