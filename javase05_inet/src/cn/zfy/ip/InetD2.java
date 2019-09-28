package cn.zfy.ip;
/**
 * InetSocketAddress：封装IP地址和端口号；
 * 1-创建对象：2种方式，指定IP|指定InetAddress对象；
 * 2-常用方法：3个，获得对象的InetAddress|端口|主机名
 */
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetD2 {
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress saddr=new InetSocketAddress("192.168.1.103",9999);
		
		InetSocketAddress saddr2=new InetSocketAddress(InetAddress.getByName("192.168.1.103"),9999);
		System.out.println(saddr2.getPort());
		System.out.println(saddr2.getHostName());
		System.out.println(saddr2.getAddress());
		
		InetAddress addr=saddr2.getAddress();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
	}

}
