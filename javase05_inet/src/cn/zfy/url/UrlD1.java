package cn.zfy.url;
/**
 * URL:��������Դ��ָ�룻
 * 1-����������2�֣�����·��|���·����
 * 2���÷�����7�������Э��|����|�˿�|��Դ|ê��|����|���·��
 */
import java.net.MalformedURLException;
import java.net.URL;

public class UrlD1 {
	public static void main(String[] args) throws MalformedURLException {
		//����·��
		URL ur1=new URL("https://www.baidu.com:80/index.html#aa?uname=zhoufy");//��ê�㣺#aa
		//URL ur1=new URL("https://www.baidu.com:80/index.html?uname=zhoufy");//��ê�㣻
		System.out.println("Э��--->"+ur1.getProtocol());
		System.out.println("����--->"+ur1.getHost());
		System.out.println("��Դ--->"+ur1.getFile());
		System.out.println("���·��--->"+ur1.getPath());
		System.out.println("�˿�--->"+ur1.getPort());
		System.out.println("ê��--->"+ur1.getRef());
		System.out.println("����--->"+ur1.getQuery());//��ê�㣬��Ϊ�գ���ê�㣬�������ݣ�
		//���·��
		URL ur2=new URL("https://www.baidu.com/a/");
		URL ur3=new URL(ur2,"b.txt");
		System.out.println(ur3.toString());
		
		
	}

}
