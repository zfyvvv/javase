package cn.zfy.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.crypto.Data;

/**
 * 字节数组流；实现图片的传输；
 * 1、图片文件->fileinputstream->程序->（ByteArrayOutputStream）->byteArray
 * 2、字节数组->ByteArrayInputStream->程序->FileOutputStream->图片文件；
 * 通过程序的这个中转站实现：文件->程序-字节数组->程序->文件
 * 
 * @author DELL
 *
 */
public class IOTest03 {
	public static void main(String[] args) {
		byte[] data=fileToByteArray("F:/mydesk.png");
		System.out.println(data.length);
		byteArayToFile(data, "F:/test/mydesk.png");
		
	}
	//1、图片文件->fileinputstream->程序->（ByteArrayOutputStream）->byteArray
	public static byte[] fileToByteArray(String filePath) {
		File file=new File(filePath);
		System.out.println(file.exists());
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
				is=new FileInputStream(file);
				baos=new ByteArrayOutputStream();
				byte[] flush=new byte[1024*10];
				int len=0;
				while(-1!=(len=is.read(flush))) {
					baos.write(flush, 0, len);
				}
				//写出到字节数组中；
				baos.flush();
				return baos.toByteArray();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			if(null!=is) {
				try {
					is.close();//9、关闭流！
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	//字节数组->ByteArrayInputStream->程序->FileOutputStream->图片文件；
	public static void byteArayToFile(byte[] src,String filePath) {
		File file=new File(filePath);
		System.out.println(file.exists());
		OutputStream os=null;
		InputStream is=null;
		try {
			os=new FileOutputStream(file,true);
			is=new ByteArrayInputStream(src);
			byte[] flush=new byte[1024*10];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null!=os) {
				try {
					os.close();//8、关闭流
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
