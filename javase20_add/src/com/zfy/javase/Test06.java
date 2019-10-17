package com.zfy.javase;

import java.util.Arrays;

/**
 * 1.字符串的常见操作；可以进行组合，达到对字符串的操作；
 * 2.这些只是简单的操作，底层的原理是对数组的操作，即对线性表的操作，需用的数据结构是数组；
 * 3.字符串的底层数据结构是数组；集合的底层数据结构是数组|链表，数据结构真的是编程的基础；
 * @author DELL
 *
 */
public class Test06 {
	
	public static void main(String[] args) {
		String str=new String("abcdefg/?ka?l");
		//1.查看字符串（字符数组）的长度；
		System.out.println(str.length());
		//2.查看指定字符的索引位置；如果不存在返回-1；
		System.out.println(str.indexOf("?"));
		
		
		//指定内容最后一次出现的位置；
		System.out.println(str.lastIndexOf("?"));
		//3.查看指定索引位置的字符；（索引位置从0开始计算）；
		System.out.println(str.charAt(3));
		//4.将一个字符串变成一个字符数组；返回值为数组；
		char[] strByte=str.toCharArray();
		System.out.println(Arrays.toString(strByte));//打印数组的元素；有Arrays类对数组进行操作；
		//5.字符串大小写的转换；
		String str2=new String("abcd");
		System.out.println(str2.toUpperCase());
		String str3=new String("EFGH");
		System.out.println(str3.toLowerCase());
		//6.根据正则表达式的匹配来拆分字符串；形成一个新的String数组；但是正则表达式（$,*）识别不出来；
		String str4=new String("abc:ef@g:hi:jkl");
		String[] arrStr1=str4.split(":");
		String[] arrStr2=str4.split("@");
		System.out.println(Arrays.toString(arrStr1));
		System.out.println(Arrays.toString(arrStr2));
		//7.字符串相等比较；返回值为boolean；
		String str5="aab";
		String str6="aaB";
		System.out.println(str5.equals(str6));
		//也可以比较两个忽略大小写的字符串是否相等；
		System.out.println(str5.equalsIgnoreCase(str6));
		//8.去掉字符串的左右空格；
		String str7="    aabc    ";
		System.out.println(str7.trim());
		//使用replace可以达到同样的效果；
		System.out.println(str7.replace("    ", ""));
		//9.截取字符串；
		String str8="周方杨love编程周以沫";
		String newStr=str8.substring(3, 7);
		System.out.println(newStr);
		//10.是否包含指定内容的字符串；
		String str9="周方杨";
		System.out.println(str8.contains(str9));
		//11.是否以指定的字符串开始或结尾；
		System.out.println(str8.startsWith("周方"));
		System.out.println(str8.endsWith("杨"));
		//12.replace:可以将某个内容全部替换成指定内容；也可以将第一次出现的某个内容替换成指定的内容；
		System.out.println(str8.replaceAll("周", "刘"));
		System.out.println(str8.replaceFirst("周", "刘"));
	}
}
