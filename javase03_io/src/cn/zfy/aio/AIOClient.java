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
			//����ͨ����
			channel=AsynchronousSocketChannel.open();
			//�������󣬽������ӣ�
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
			//read()����ʱ�첽������OSʵ�ֵģ�get()������һ��������������ȴ�OS����������ٷ��أ�
			//��ʵ��Ŀ�У�get�������Բ��ӣ���ʱ��Ϊ�˲�����Ч��
			channel.read(buffer).get();
			//ȥ��֮��ֻ����OSϵͳ�ȴ������벻��ȴ���
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
