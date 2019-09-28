package cn.zfy.ip;
/**
 * InetSocketAddress����װIP��ַ�Ͷ˿ںţ�
 * 1-��������2�ַ�ʽ��ָ��IP|ָ��InetAddress����
 * 2-���÷�����3������ö����InetAddress|�˿�|������
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
