package com.zfy.javase;


/**
 * 1.编译不通过，
 * @author DELL
 *
 */
public class Test03 {
	public static int plus(final int x) {
		//编译不通过，
		//return ++x;
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(plus(11));
	}
}
