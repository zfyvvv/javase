package cn.zfy.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件字节流：字节流的多态，方式是字节，目的地是文件和程序；
 * 1、文件字节输入流：File->（FileInputStream)->程序；
 *   创建源：
 *   选择流；
 *   操作；
 *   释放资源；
 *   
 *2、文件字节输出流：程序->（FileOutputStream）->File
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
public class IOTest01 {

	public static void main(String[] args) {
		test1();
	}
	
	//
	public static void test1() {
         //1、选择外面来的文件位置；in
		File file=new File("E:/04-java/aaa.txt");
		System.out.println(file.exists());
		//2、选择流；（选择搬家公司）
		InputStream is=null;
		try {
			//3、建立联系：位置和流（目的地）
			is=new FileInputStream(file);
			//4、如何读入：一字节的方式读入；一次读取1024个字节；一直读读读读读取
			byte[] car=new byte[2];
			int len=0;
			try {
				//程序一直读取外来文件的字节，读到没有为止，此时is.read为-1；（可以规定长度的读取！）
				//读取的文件内容放到car里面去，然后car里面通过二进制转换成字符方法，转成字符串；
				while(-1!=(len=is.read(car))) {
					//5、将读取的字节转成字符；
					String str=new String(car,0,len);
					//输出；6、在程序里面显示出来；
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
	
	//字节数组->字符串；
	public static void test2() {
			//1、建立写出的目的地；
			File file=new File("E:/04-java/ccc.txt");
			System.out.println(file.exists());
			//2、选择流；
			OutputStream os=null;
			try {
				//3、建立联系：位置和流
				os=new FileOutputStream(file,true);
				//4、写出什么；
				String str="Hellow,world! \r\n";
				//5、将需要写出 的字符转成字节，一次性读完，
				byte[] data=str.getBytes();
				//6、使用字节流写出；
				os.write(data, 0, data.length);
				//7、刷新，
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

