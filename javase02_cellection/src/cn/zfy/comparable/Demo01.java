package cn.zfy.comparable;
/**
 * 1��������ֵ��С�Ƚ�;
 * 2��java����Ԫ�ش�С�ıȽϣ�
 * 3��java������Ԫ�ض�ʵ����java.lang.comparable�ӿڣ�
 * 	    �ýӿ���ֻ��һ������public int compareTo(object obj),����ֵΪһ��int���ͣ�
 *    int=0����ʾthis=obj;int>0����ʾthis>obj;int<0����ʾthis<obj;
 * 4��ʵ�ֽӿڣ���ͨ��compareTo()�������򣬷��������ʵ�ֿ����Ǹ��ʶ����һ������;
 *    ���˵Ĺ��ʣ����ŵ��ȶȣ�ѧ���ķ�����
 * @author DELL
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int i=2;
		int j=3;//��ֵ��С
		Character ch='a';
		Character ch2='b';//Unicode
		String str1="abc";
		String str2="abd";
		String str3="abddefg";//�Ȱ�˳��Ƚ�Unicode�룬���Ϊ��ʼλ���Ӵ����򷵻س��Ȳ
		System.out.println(ch.compareTo(ch2));
		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str3));
	}

}
