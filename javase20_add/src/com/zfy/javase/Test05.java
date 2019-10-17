package com.zfy.javase;


/**
 * 1.×Ö·û´®µÄÆ´½Ó²Ù×÷£»
 * @author DELL
 *
 */
public class Test05 {
	
	public static String conetact(String[] arr ) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			if(i<arr.length-1) {
				sb.append(arr[i]).append(",");
			}else {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] arr= {"AA","BB","CC"};
		String result=conetact(arr);
		System.out.println(result);
	}
}
