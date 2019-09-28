package cn.zfy.ip;
/**
 *InetAddress:域名和地址的创建和常用方法；
 *1-创建对象：3种静态方法；本机|指定域名|指定IP；
 *2-常用方法：2个，获得对象的IP|主机名；
 * 
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetD1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr=InetAddress.getLocalHost();//使用getLocalHost静态方法创建InetAddress对象；InetAddress没有new方法；
		System.out.println(addr.getHostName());//返回计算机名
		System.out.println(addr.getHostAddress());//返回IP：192.168.1.103
		
		InetAddress addr2=InetAddress.getByName("www.163.com");//根据域名得到InetAddress对象；
		System.out.println(addr2.getHostName());//得到163服务器的名字：www.163.com
		System.out.println(addr2.getHostAddress());//返回163服务器IP：183.61.26.225
		
		InetAddress addr3=InetAddress.getByName("183.61.26.225");//根据IP得到InetAddress对象；
		System.out.println(addr3.getHostName());//得到163服务器的名字：www.163.com；如果不给解析，返回IP；
		System.out.println(addr3.getHostAddress());//返回163服务器IP：183.61.26.225
	}

}
