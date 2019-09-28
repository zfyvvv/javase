package cn.zfy.datainput;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 1、数据输出流
 * @author DELL
 *
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		String str="hello,zfy!";
		byte[] b=str.getBytes();
		int len=b.length;
		//写出的位置是文件；
		//可以在电脑的指定位置获取该字符串；
		/*DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(
								new File("F:/io.txt"))));
			//在指定文件中有指定字符串；
			dos.write(b, 0, len);
			dos.flush();*/
		
		
		
		//长度为什么是0？
		/*byte[] bb=new byte[1024];
		ByteArrayInputStream bais=new ByteArrayInputStream(bb);
		DataOutputStream dos2=new DataOutputStream(
				new BufferedOutputStream(bb));
		dos2.write(b, 0, len);
		
		byte[] desc=baos.toByteArray();
		System.out.println(desc.length);*/
		
		
		
		
	}

}


