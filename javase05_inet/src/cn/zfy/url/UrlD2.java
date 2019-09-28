package cn.zfy.url;
/**
 * openStream():��URL��λ����Դ��������������Ϊ�ֽ�����������
 * 1-��������ӡ������̨
 * 2-�ֽ�������-->�ļ��ַ�������
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
		//��ȡ��Դ����������
		/*InputStream is=ur1.openStream();//ʹ���ֽ���������������ڣ�
		byte[] flush=new byte[1024];
		int len =0;
		while(-1!=(len=isr.read(flush))) {
			System.out.println(new String(flush,0,len));
		}*/
		BufferedReader br=new BufferedReader(new InputStreamReader(ur1.openStream(),"utf-8"));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/04-java/163.html"),"UTF-8"));
		String flush=null;//����ת������
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
