package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1、文件字节输出流；程序字符串->data->输出流节点流写出（文件位置和流）->外部文件；
 * 2、经典代码；
 * @author DELL
 *
 */
public class Demo2 {
	public static void main(String[] args) {
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
