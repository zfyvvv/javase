package cn.zfy.comparable;
/**
 * 1��ʵ��comparator�ӿڣ�����compare()���Լ������Լ����������
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
