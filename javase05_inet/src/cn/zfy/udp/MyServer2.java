package cn.zfy.udp;
/**
 * UDP，以数据为中心的传输；套路固定，不安全，效率高；
 * 1-建一个服务端；
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer2 {
	public static void main(String[] args) throws Exception {
		test2();
	}
	//一次接受；
	public static void test1() throws Exception {
		DatagramSocket server=new DatagramSocket(8889);
		byte[] con=new byte[1024*64];
		DatagramPacket pac=new DatagramPacket(con, 0, con.length);
		server.receive(pac);
		byte[] data=pac.getData();
		int len=pac.getLength();
		System.out.println(new String(data,0,len));
		server.close();
	}
	
	//多次接受；
	public static void test2() throws Exception {
		DatagramSocket server=new DatagramSocket(8889);
		while(true) {
		byte[] con=new byte[1024*64];
		DatagramPacket pac=new DatagramPacket(con, 0, con.length);
		server.receive(pac);
		byte[] data=pac.getData();
		int len=pac.getLength();
		String msg=new String(data,0,len);
		System.out.println(msg);
		if(msg.equals("byb")) {
			break;
			}
		
		}
		server.close();
	}
	
}
