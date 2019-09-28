package cn.zhoufy.tsorm.util;

import java.lang.reflect.Method;

/**
 * ��װSQL���õĲ�����
 * @author DELL
 *
 */
public class RefUtils {
	/**
	 * ����obj�����Ӧ����fileName��get������
	 * @param fileName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fileName,Object obj) {
		try {
			Class c=obj.getClass();
			Method m=c.getMethod("get"+StringUtils.fistChar2UpCase(fileName),null);
			return m.invoke(obj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	


public static void invokeSet(Object obj,String columnName,Object columnValue) {
	try {
		Method m = obj.getClass().getDeclaredMethod("set"+StringUtils.fistChar2UpCase(columnName),
				columnValue.getClass());//����obj���set������()��
		m.invoke(obj, columnValue);//==obj.set(������)   �����ǰһ��Ϊ��ļǺţ���һ��Ϊ���Σ�ͨ���������ָ�����ָ��������
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
