package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *文件字符流：处理字符在文件和程序之间的传输；
 * 1、文件字节输入流：File->bufferInputStream（FileInputStream)->程序；加入缓冲；
 *   创建源：
 *   选择流；
 *   操作；
 *   释放资源；关闭最外层即可；
 *   
 *2、文件字节输出流：程序->bufferoutputStream（FileOutputStream）->File；加入缓冲；
 *   创建源：
 *   选择流；
 *   操作；写出内容；
 *   释放资源；关闭最外层即可；
 *   
 *  多套基层，提升不大；
 *   
 * @author DELL
 *
 */
public class IOTest04 {

	public static void main(String[] args) {
		test1();
	}
	
	//文件->程序； BufferedInputStream
	public static void test1() {
		File file=new File("E:/04-java/aaa.txt");
		System.out.println(file.exists());
		InputStream is=null;
		try {
			is=new BufferedInputStream(new FileInputStream(file));
			byte[] car=new byte[1024];
			int len=0;
			try {
				while(-1!=(len=is.read(car))) {
					String str=new String(car,0,len);
					System.out.println(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件读取失败！");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在！");
		}finally {
			if(null!=is) {
				try {
					is.close();//9、关闭流！
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件关闭失败！");
				}
			}
		}
	}
	
	//字节数组->字符串；BufferedOutputStream
	public static void test2() {
			File file=new File("E:/04-java/ccc.txt");
			System.out.println(file.exists());
			OutputStream os=null;
			try {
				os=new BufferedOutputStream(new FileOutputStream(file));
				String str="Hellow,world! \r\n";
				byte[] data=str.getBytes();
				os.write(data, 0, data.length);
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

