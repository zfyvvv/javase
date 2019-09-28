package cn.zfy.fileinputstream;
/**
 * 1、纯文本文件的拷贝
 * 2、字符输出流和输入流；
 * 3、装饰设计模式；
 */
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
import java.io.FileInputStream;

public class Demo6 {
	public static void main(String[] args) {
		String ystr="E:/04-java/aaa.txt";
		String dstr="E:/04-java/ccc.txt";
		try {
			charCopy(ystr,dstr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void charCopy(String stry,String strd) throws IOException{
		charCopy(new File(stry),new File(strd));
	}
	
	/**
	 * 
	 * @param filey
	 * @param filed
	 * @throws IOException
	 */
	public static void charCopy(File filey,File filed) throws IOException{
		Reader r=new FileReader(filey);
		Writer w=new FileWriter(filed,true);//可以在后面追加文字
		char[] flush=new char[100];
		int len=0;
		while(-1!=(len=r.read(flush))) {
			w.write(flush, 0, len);
			w.flush();
		}
		w.close();
		r.close();
	}
}

