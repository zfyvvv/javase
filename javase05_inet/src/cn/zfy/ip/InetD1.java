package cn.zfy.ip;
/**
 *InetAddress:�����͵�ַ�Ĵ����ͳ��÷�����
 *1-��������3�־�̬����������|ָ������|ָ��IP��
 *2-���÷�����2������ö����IP|��������
 * 
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetD1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr=InetAddress.getLocalHost();//ʹ��getLocalHost��̬��������InetAddress����InetAddressû��new������
		System.out.println(addr.getHostName());//���ؼ������
		System.out.println(addr.getHostAddress());//����IP��192.168.1.103
		
		InetAddress addr2=InetAddress.getByName("www.163.com");//���������õ�InetAddress����
		System.out.println(addr2.getHostName());//�õ�163�����������֣�www.163.com
		System.out.println(addr2.getHostAddress());//����163������IP��183.61.26.225
		
		InetAddress addr3=InetAddress.getByName("183.61.26.225");//����IP�õ�InetAddress����
		System.out.println(addr3.getHostName());//�õ�163�����������֣�www.163.com�������������������IP��
		System.out.println(addr3.getHostAddress());//����163������IP��183.61.26.225
	}

}
