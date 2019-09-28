package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 1、文件节点输入流；外部文件->文件节点流->car->程序字符串->程序打印；；
 * 2、经典代码；
 * @author DELL
 *
 */
public class Demo1 {
	public static void main(String[] args) {
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
}
