package com.zfy.javase;


/**
 * 1.��Welcome������Welcome To Midea����
 * changeStr(String str);û�з���ֵ��str��û�иı䣻void void void��
 * changeStrReturn(String str)���з���ֵ��strָ���Ѿ��ı䣻
 * 
 * @author DELL
 *
 */
public class Test02 {
	public static void changeStr(String str) {
		str="Welcome To Midea";
	}
	
	public static String changeStrReturn(String str) {
		str="Welcome To Midea";
		return str;
	}
	public static void main(String[] args) {
		String str="Welcome";
		//changeStr(str);
		str=changeStrReturn(str);
		System.out.println(str);
	}
}
