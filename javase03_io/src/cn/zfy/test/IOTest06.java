package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
 * 文件字符流：处理字符在文件和程序之间的传输；+缓冲流；
 * 1、文件字符输入流：File->bufferReader(FileReader)->程序；
 *   创建源：
 *   选择流；
 *   操作；
 *   释放资源；
 *   
 *2、文件字符输出流：程序->bufferWriter(FileWriter)->File；
 *   创建源：
 *   选择流；
 *   操作；写出内容；
 *   释放资源；
 *   
 *  
 *   
 * @author DELL
 *
 */
public class IOTest06 {

	public static void main(String[] args) {
		test1();
	}
	
	//文件->程序； 
	public static void test1() {
		File file=new File("F:/aaa.txt");
		System.out.println(file.exists());
		//使用新增方法；不要使用多态；
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			//直接读取到String中；
			String line=null;
			//使用新增方法；逐行读取；
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件读取失败！");
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
			//不能使用多态，要使用新增方法；
			BufferedWriter writer=null;
			try {
				writer=new BufferedWriter(new FileWriter(file));
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
				//逐行写出；
				writer.append("Hellow,world! \\r\\n");
				writer.newLine();
				writer.append("add");
				writer.flush();
				
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

