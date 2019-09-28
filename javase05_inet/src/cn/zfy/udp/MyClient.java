package cn.zfy.udp;
/**
 * UDP，以数据为中心的传输；套路固定，不安全，效率高；
 * 1-建一个客户端；
 */
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket client=new DatagramSocket(6666);//创建服务端+指定端口，DatagramSocket
		/*String msg="UDP-zfy";//准备数据，字节数组
		byte[] data=msg.getBytes();*/
		double d=3.33;//数据源
		//目标源
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//输出流，输出到bos源中，
		DataOutputStream dos=new DataOutputStream(bos);
		//将基本类型转换成字节数组；bos.writeXXX，开始写入
		dos.writeDouble(d);
		//使用数组接受bos字节输出流中字节数组（流--->数组）
		byte[] data=bos.toByteArray();
		//打包发送，发送到服务器地址和端口；（在信息里面确定位置和端口，面向内容，不是面向连接！）
		DatagramPacket pac=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8866));
		//客户端服务器发送数据，以包的形式发送；
		client.send(pac);
		bos.close();
		dos.close();
		//释放资源；
		client.close();
	}

}
