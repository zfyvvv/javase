package cn.zhoufy.tsorm.util;

import java.lang.reflect.Method;

/**
 * 封装SQL常用的操作；
 * @author DELL
 *
 */
public class RefUtils {
	/**
	 * 调用obj对象对应属性fileName的get方法；
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
				columnValue.getClass());//调用obj类的set属性名()，
		m.invoke(obj, columnValue);//==obj.set(属性名)   反射的前一个为类的记号，后一个为传参；通过反射调用指定类的指定方法；
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
