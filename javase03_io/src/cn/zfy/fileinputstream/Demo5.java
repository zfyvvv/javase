package cn.zfy.fileinputstream;

import java.io.UnsupportedEncodingException;

/**
 * 1:程序将文件读进来，就是进行解码：（解析二进制码，进行读取）
 * 文件都是二进制的，故byte[]--->char:解码，
 * 2:程序将文件写出去，就是进行编码；（编成二进制码，进行写出）
 * 写出的文件都是二进制码，故char--->byte[]:编码,
 * 2、乱码：解码和编码字符集不同一；字节数不完整，信息丢失；
 */


public class Demo5 {
	public static void main(String[] args) throws UnsupportedEncodingException {
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

