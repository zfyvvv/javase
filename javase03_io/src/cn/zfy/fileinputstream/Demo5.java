package cn.zfy.fileinputstream;

import java.io.UnsupportedEncodingException;

/**
 * 1:�����ļ������������ǽ��н��룺�������������룬���ж�ȡ��
 * �ļ����Ƕ����Ƶģ���byte[]--->char:���룬
 * 2:�����ļ�д��ȥ�����ǽ��б��룻����ɶ������룬����д����
 * д�����ļ����Ƕ������룬��char--->byte[]:����,
 * 2�����룺����ͱ����ַ�����ͬһ���ֽ�������������Ϣ��ʧ��
 */


public class Demo5 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="�ܷ���";
		byte[] data=str.getBytes();//���룬
		String str1=new String(data);//���룬����ͬһ�ַ�����GBK
		System.out.println(str1);
		
		byte[] data2=str.getBytes("utf-8");//���룬��utf-8��
		String str2=new String(data2);//���룬��GBK;
		System.out.println(str2);//����
		
		byte[] data3=str.getBytes("utf-8");//���룬��utf-8��
		String str3=new String(data3,"utf-8");//���룬��utf-8;
		System.out.println(str3);//
	}
	
}

