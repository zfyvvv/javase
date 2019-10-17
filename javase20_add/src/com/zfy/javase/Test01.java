package com.zfy.javase;


/**
 * 1.对于循环，一定要理解循环的过程；
 * 	for(int j=0;j<3;j++) {
			System.out.print(j);
	}
	注意循环的初始条件，执行，以及判断；
 * @author DELL
 *
 */
public class Test01 {
	public static boolean foo(char c) {
		System.out.print(c);
		return true;
	}
	
	public static void main(String[] args) {
		int i=0;
		for(foo('A');foo('B')&&(i<2);foo('C')) {
			i++;
			foo('D');
		}
		

	}


}
