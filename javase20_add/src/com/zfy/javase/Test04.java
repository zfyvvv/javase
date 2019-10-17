package com.zfy.javase;


/**
 * 1.字节数组和String对象之间的转换；
 * @author DELL
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		String msg="周方杨";
		byte[] bt=msg.getBytes();
		System.out.println(bt.length);
		
		String code=new String(bt);
		System.out.println(code);
		
	}
}
