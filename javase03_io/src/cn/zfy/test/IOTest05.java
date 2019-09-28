package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 1、文件字符输入流：File->FileReader->程序；
 *   创建源：
 *   选择流；
 *   操作；
 *   释放资源；
 *   
 *2、文件字符输出流：程序->FileWriter->File；
 *   创建源：
 *   选择流；
 *   操作；写出内容；
 *   释放资源；
 *   
 *  多套基层，提升不大；
 *   
 * @author DELL
 *
 */
public class IOTest05 {

	public static void main(String[] args) {
		test1();
	}
	
	//文件->程序； 
	public static void test1() {
		File file=new File("F:/aaa.txt");
		System.out.println(file.exists());
		Reader reader=null;
		try {
			reader=new FileReader(file);
			//缓冲容器；
			char[] flush=new char[1024];
			int len=-1;
			try {
				while(-1!=(len=reader.read(flush))) {
					String str=new String(flush,0,len);
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
			if(null!=reader) {
				try {
					reader.close();//9、关闭流！
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件关闭失败！");
				}
			}
		}
	}
	
	//程序->文件；
	public static void test2() {
			File file=new File("F:/aaa.txt");
			System.out.println(file.exists());
			Writer writer=null;
			try {
				writer=new FileWriter(file);
				//操作；
				//写法1
/*				String msg="Hellow,world! \r\n";
				char[] datas=msg.toCharArray();
				writer.write(datas, 0, datas.length);*/
				
				//写法二；
				/*String msg="Hellow,world! \r\n";
				writer.write(msg);
				writer.write("add");
				writer.flush();*/
				
				//写法三；
				/*writer.append("Hellow,world! \\r\\n").append("add");
				writer.flush();*/
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(null!=writer) {
					try {
						writer.close();//8、关闭流
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}

