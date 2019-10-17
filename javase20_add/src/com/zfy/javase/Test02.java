package com.zfy.javase;


/**
 * 1.是Welcome，不是Welcome To Midea？？
 * changeStr(String str);没有返回值，str并没有改变；void void void！
 * changeStrReturn(String str)；有返回值，str指向已经改变；
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
