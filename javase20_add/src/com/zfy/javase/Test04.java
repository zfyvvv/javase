package com.zfy.javase;


/**
 * 1.�ֽ������String����֮���ת����
 * @author DELL
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		String msg="�ܷ���";
		byte[] bt=msg.getBytes();
		System.out.println(bt.length);
		
		String code=new String(bt);
		System.out.println(code);
		
	}
}
