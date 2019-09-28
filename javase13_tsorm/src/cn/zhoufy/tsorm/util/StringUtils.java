package cn.zhoufy.tsorm.util;
/**
 * 封装反射常用的操作；
 * @author DELL
 *
 */
public class StringUtils {
	/**
	 * 将首字母变成大写,
	 * @param str
	 * @return
	 */
	public static String fistChar2UpCase(String str) {
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}

}
