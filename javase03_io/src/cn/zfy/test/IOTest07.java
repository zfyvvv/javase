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
 * 转换流；
 * 1、转换流：  字节--->字符
 * 输入流：InputStreamReadr:读取，解码，可指定编码集；
 * 输出流：OutputStreamWriter:输出，编码，可指定编码集；
 * 
 * 
 */


public class IOTest07 {
	public static void main(String[] args) throws IOException {
		File file=new File("E:/04-java/Demo5.java");
		
		//使用字节输入流进行读取读取
		/*InputStream is=new FileInputStream(file);//
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			String str=new String(flush,0,flush.length);
			System.out.println(str);}*/
		
		//使用字符输入流进行读取读取
		/*Reader r=new FileReader(file);//
		char[] flush=new char[1024];
		int len=0;
		while(-1!=(len=r.read(flush))) {
			System.out.println(flush);}*/
		
		//使用字符缓冲流输入流进行读取
		/*BufferedReader br=new BufferedReader(new FileReader(file));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
		
		//使用字符输入转换流进行读取，可指定解码集！GBK(java默认设置为GBK)
/*		BufferedReader br=new BufferedReader(//
				new InputStreamReader(//
				new FileInputStream(file),"GBK"));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
		
		//使用字符输入转换流进行读取，可指定解码集！UTF-8（乱码出现）
		/*BufferedReader br=new BufferedReader(//
				new InputStreamReader(//
				new FileInputStream(file),"UTF-8"));//
		String flush=null;
		while(null!=(flush=br.readLine())) {
			System.out.println(flush);}*/
	}
	
	/**
	 * 1、编码和解码的解释；
	 * @throws UnsupportedEncodingException
	 */
	public void test1() throws UnsupportedEncodingException {
		 /*1:程序将文件读进来，就是进行解码：（解析二进制码，进行读取）
		 文件都是二进制的，故byte[]--->char:解码，
		 2:程序将文件写出去，就是进行编码；（编成二进制码，进行写出）
		 写出的文件都是二进制码，故char--->byte[]:编码,
		 2、乱码：解码和编码字符集不同一；字节数不完整，信息丢失；*/
		String str="周方杨";
		byte[] data=str.getBytes();//编码，
		String str1=new String(data);//解码，都在同一字符集；GBK
		System.out.println(str1);
		
		byte[] data2=str.getBytes("utf-8");//编码，在utf-8，
		String str2=new String(data2);//解码，在GBK;
		System.out.println(str2);//乱码
		
		byte[] data3=str.getBytes("utf-8");//编码，在utf-8，
		String str3=new String(data3,"utf-8");//解码，在utf-8;
		System.out.println(str3);//
			
	}
	
}

