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

public class MyServer {
	public static void main(String[] args) throws IOException {
		//创建服务器+指定端口  DatagramSocket
		DatagramSocket server=new DatagramSocket(8866);
		//准备接受容器，数据封装成包；
		byte[] con=new byte[1024];
		DatagramPacket pac=new DatagramPacket(con,con.length);
		server.receive(pac);
		//使用包接受数据；
		byte[] data=pac.getData();
		//分析数据；包里面的数据（以字节数组存在）；
		//包里面的数据大小
		int len=pac.getLength();
		
		System.out.println(len);
		//将字节数组转换成基本类型，输出流，
		//字节数组输入流，(data-->z字节数组输入流)
		ByteArrayInputStream bis=new ByteArrayInputStream(data);
		//把数组+类型输入进来；(字节数组输入流-->数据输入流)
		DataInputStream dis=new DataInputStream(bis);
		//(读出数据输入流数据，并打印)
		System.out.println(dis.readDouble());
		//释放资源
		dis.close();
		bis.close(); 
		server.close();
	}
}
