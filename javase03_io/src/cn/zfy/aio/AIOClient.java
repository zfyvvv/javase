package cn.zfy.aio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
/**
 * 1.AIO-clent
 * 
 * @author DELL
 *
 */
public class AIOClient {
	
	private AsynchronousSocketChannel channel;
	public AIOClient(String host,int port) {
		init(host,port);
	}
	
	private void init(String host, int port) {
		try {
			//开启通道；
			channel=AsynchronousSocketChannel.open();
			//发起请求，建立连接；
			channel.connect(new InetSocketAddress(host,port));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void write(String line) {
		try {
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			buffer.put(line.getBytes("UTF-8"));
			buffer.flip();
			channel.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		try {
			//read()方法时异步方法，OS实现的；get()方法是一个阻塞方法，会等待OS处理结束后再返回；
			//真实项目中，get方法可以不加；此时是为了测试有效；
			channel.read(buffer).get();
			//去掉之后，只会让OS系统等待，代码不会等待；
			//channel.read(buffer)
			buffer.flip();
			System.out.println("from server : "+new String(buffer.array(),"UTF-8"));
		} catch (Exception e) {
		}
	}
	
	public void doDestory() {
		if(null!=channel) {
			try {
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//AIOClient  client=new AIOClient("localhsot",9999);
		AIOClient  client=new AIOClient("localhost",9999);
		try {
			System.out.println("enter message send to server >");
			Scanner s=new Scanner(System.in);
			String line=s.next();
			client.write(line);
			client.read();
		}finally {
			client.doDestory();
		}
	}
	
	
	
	
	
	
	
}
