package cn.zfy.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * ת������
 * 1��ת������  �ֽ�--->�ַ�
 * ��������InputStreamReadr:��ȡ�����룬��ָ�����뼯��
 * �������OutputStreamWriter:��������룬��ָ�����뼯��
 * 
 * 
 */


public class IOTest07 {
	public static void main(String[] args) throws IOException {
		File file=new File("E:/04-java/Demo5.java");
		
		//ʹ���ֽ����������ж�ȡ��ȡ
		/*InputStream is=new FileInputStream(file);//
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			String str=new String(flush,0,flush.length);
			System.out.println(str);}*/
		
		//ʹ���ַ����������ж�ȡ��ȡ
		/*Reader r=new FileReader(file);//
		char[] flush=new char[1024];
		int len=0;
		while(-1!=(len=r.read(flush))) {
			System.out.println(flush);}*/
		
		//ʹ���ַ����������������ж�ȡ
		/*BufferedReader br=new BufferedReader(new FileReader(file));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
		
		//ʹ���ַ�����ת�������ж�ȡ����ָ�����뼯��GBK(javaĬ������ΪGBK)
/*		BufferedReader br=new BufferedReader(//
				new InputStreamReader(//
				new FileInputStream(file),"GBK"));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
		
		//ʹ���ַ�����ת�������ж�ȡ����ָ�����뼯��UTF-8��������֣�
		/*BufferedReader br=new BufferedReader(//
				new InputStreamReader(//
				new FileInputStream(file),"UTF-8"));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
	}
	
	/**
	 * 1������ͽ���Ľ��ͣ�
	 * @throws UnsupportedEncodingException
	 */
	public void test1() throws UnsupportedEncodingException {
		 /*1:�����ļ������������ǽ��н��룺�������������룬���ж�ȡ��
		 �ļ����Ƕ����Ƶģ���byte[]--->char:���룬
		 2:�����ļ�д��ȥ�����ǽ��б��룻����ɶ������룬����д����
		 д�����ļ����Ƕ������룬��char--->byte[]:����,
		 2�����룺����ͱ����ַ�����ͬһ���ֽ�������������Ϣ��ʧ��*/
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

