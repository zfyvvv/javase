package com.zfy.javase;

import java.util.Arrays;

/**
 * 1.�ַ����ĳ������������Խ�����ϣ��ﵽ���ַ����Ĳ�����
 * 2.��Щֻ�Ǽ򵥵Ĳ������ײ��ԭ���Ƕ�����Ĳ������������Ա�Ĳ��������õ����ݽṹ�����飻
 * 3.�ַ����ĵײ����ݽṹ�����飻���ϵĵײ����ݽṹ������|�������ݽṹ����Ǳ�̵Ļ�����
 * @author DELL
 *
 */
public class Test06 {
	
	public static void main(String[] args) {
		String str=new String("abcdefg/?ka?l");
		//1.�鿴�ַ������ַ����飩�ĳ��ȣ�
		System.out.println(str.length());
		//2.�鿴ָ���ַ�������λ�ã���������ڷ���-1��
		System.out.println(str.indexOf("?"));
		
		
		//ָ���������һ�γ��ֵ�λ�ã�
		System.out.println(str.lastIndexOf("?"));
		//3.�鿴ָ������λ�õ��ַ���������λ�ô�0��ʼ���㣩��
		System.out.println(str.charAt(3));
		//4.��һ���ַ������һ���ַ����飻����ֵΪ���飻
		char[] strByte=str.toCharArray();
		System.out.println(Arrays.toString(strByte));//��ӡ�����Ԫ�أ���Arrays���������в�����
		//5.�ַ�����Сд��ת����
		String str2=new String("abcd");
		System.out.println(str2.toUpperCase());
		String str3=new String("EFGH");
		System.out.println(str3.toLowerCase());
		//6.����������ʽ��ƥ��������ַ������γ�һ���µ�String���飻����������ʽ��$,*��ʶ�𲻳�����
		String str4=new String("abc:ef@g:hi:jkl");
		String[] arrStr1=str4.split(":");
		String[] arrStr2=str4.split("@");
		System.out.println(Arrays.toString(arrStr1));
		System.out.println(Arrays.toString(arrStr2));
		//7.�ַ�����ȱȽϣ�����ֵΪboolean��
		String str5="aab";
		String str6="aaB";
		System.out.println(str5.equals(str6));
		//Ҳ���ԱȽ��������Դ�Сд���ַ����Ƿ���ȣ�
		System.out.println(str5.equalsIgnoreCase(str6));
		//8.ȥ���ַ��������ҿո�
		String str7="    aabc    ";
		System.out.println(str7.trim());
		//ʹ��replace���Դﵽͬ����Ч����
		System.out.println(str7.replace("    ", ""));
		//9.��ȡ�ַ�����
		String str8="�ܷ���love�������ĭ";
		String newStr=str8.substring(3, 7);
		System.out.println(newStr);
		//10.�Ƿ����ָ�����ݵ��ַ�����
		String str9="�ܷ���";
		System.out.println(str8.contains(str9));
		//11.�Ƿ���ָ�����ַ�����ʼ���β��
		System.out.println(str8.startsWith("�ܷ�"));
		System.out.println(str8.endsWith("��"));
		//12.replace:���Խ�ĳ������ȫ���滻��ָ�����ݣ�Ҳ���Խ���һ�γ��ֵ�ĳ�������滻��ָ�������ݣ�
		System.out.println(str8.replaceAll("��", "��"));
		System.out.println(str8.replaceFirst("��", "��"));
	}
}
