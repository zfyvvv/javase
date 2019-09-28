package cn.zfy.udp;
/**
 * UDP��������Ϊ���ĵĴ��䣻��·�̶�������ȫ��Ч�ʸߣ�
 * 1-��һ���ͻ��ˣ�
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient2 {
	public static void main(String[] args) throws Exception {
		test2();
	
	}
		
	//һ�η��ͣ�
	public static void test1() throws Exception {
		DatagramSocket client=new DatagramSocket(8888);
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String msg=reader.readLine();
		byte[] data=msg.getBytes();
		DatagramPacket pac=new DatagramPacket(data,data.length,
				new InetSocketAddress("localhost",8889));
		client.send(pac);
		client.close();
	}
		
	//��η��ͣ�
	public static void test2() throws Exception {
		DatagramSocket client=new DatagramSocket(8888);
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		String msg=reader.readLine();
		byte[] data=msg.getBytes();
		DatagramPacket pac=new DatagramPacket(data,data.length,
				new InetSocketAddress("localhost",8889));
		client.send(pac);
		if("byb".equals(msg)) {
			break;
		}
		}
		client.close();
		
	}	

	
	
}
