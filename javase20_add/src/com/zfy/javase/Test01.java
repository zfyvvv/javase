package com.zfy.javase;


/**
 * 1.����ѭ����һ��Ҫ���ѭ���Ĺ��̣�
 * 	for(int j=0;j<3;j++) {
			System.out.print(j);
	}
	ע��ѭ���ĳ�ʼ������ִ�У��Լ��жϣ�
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
