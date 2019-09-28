package cn.zfy.url;
/**
 * openStream():把URL定位的资源拷贝出来；本质为字节输入流！！
 * 1-输入流打印到控制台
 * 2-字节输入流-->文件字符数据流
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlD2 {
	public static void main(String[] args) throws IOException {
		//URL ur1=new URL("https://www.baidu.com");
		URL ur1=new URL("https://www.163.com");
		//获取资源，网络流；
		/*InputStream is=ur1.openStream();//使用字节流，会有乱码存在！
		byte[] flush=new byte[1024];
		int len =0;
		while(-1!=(len=isr.read(flush))) {
			System.out.println(new String(flush,0,len));
		}*/
		BufferedReader br=new BufferedReader(new InputStreamReader(ur1.openStream(),"utf-8"));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/04-java/163.html"),"UTF-8"));
		String flush=null;//这是转换流！
		while(null!=(flush=br.readLine())) {
			//bw.write(flush);
			bw.append(flush);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
