package cn.zhoufy.tsorm.util;
/**
 * ��װ���䳣�õĲ�����
 * @author DELL
 *
 */
public class StringUtils {
	/**
	 * ������ĸ��ɴ�д,
	 * @param str
	 * @return
	 */
	public static String fistChar2UpCase(String str) {
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}

}
