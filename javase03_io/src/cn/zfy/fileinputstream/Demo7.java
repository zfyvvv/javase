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
 * 1转换流：  字节--->字符
 * 输入流：InputStreamReadr:读取，解码，可指定编码集；
 * 输出流：OutputStreamWriter:输出，编码，可指定编码集；
 * 2、调用该new InputStreamReader(in, dec)方法时，可以指定字符集；
 * 
 * 
 */


public class Demo7 {
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
}

