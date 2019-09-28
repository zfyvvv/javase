package cn.zfy.comparable;
/**
 * 1、实现comparator接口，重新compare()，自己定义自己的排序规则；
 * @author DELL
 *
 */
public class StringComp implements java.util.Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int len1=o1.length();
		int len2=o2.length();
		return len1-len2;
	}

}
