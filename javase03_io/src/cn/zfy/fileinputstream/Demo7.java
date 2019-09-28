package cn.zfy.fileinputstream;

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
 * 1ת������  �ֽ�--->�ַ�
 * ��������InputStreamReadr:��ȡ�����룬��ָ�����뼯��
 * �������OutputStreamWriter:��������룬��ָ�����뼯��
 * 2�����ø�new InputStreamReader(in, dec)����ʱ������ָ���ַ�����
 * 
 * 
 */


public class Demo7 {
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
}

