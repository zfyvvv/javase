package cn.zfy.fileinputstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * 1转换流：  字节--->字符
 * 输入流：InputStreamReadr:读取，解码，可指定编码集；
 * 输出流：OutputStreamWriter:输出，编码，可指定编码集；
 * 2、缓冲流：提高性能；
 * 
 * 
 * 
 */


public class Demo8 {
	public static void main(String[] args) throws IOException {
		File filey=new File("E:/04-java/Demo5.java");
		File filed=new File("E:/04-java/ccc.txt");
		
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
				new FileInputStream(filey),"GBK"));
		
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(filed),"UTF-8"));
		String flush=null;
		while(null!=(flush=br.readLine())) {
			bw.write(flush);
			bw.newLine();
			}
		bw.close();
		br.close();
	}
}

