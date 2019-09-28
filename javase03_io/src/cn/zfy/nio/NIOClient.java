package cn.zfy.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
/**
 * 1.NIO-clent
 * �ѵ���ʵ��buffer����
 * 
 * @author DELL
 *
 */
public class NIOClient {
	public static void main(String[] args) {
		//Զ�̵�ַ������
		InetSocketAddress remote=new InetSocketAddress("localhost",9999);
		SocketChannel channel=null;
		//���建�棻
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		
		try {
			//����ͨ����
			channel=SocketChannel.open();
			//����Զ�̷�������
			channel.connect(remote);
			Scanner reader=new Scanner(System.in);
			while(true) {
				System.out.println("put message for send to server>");
				String line=reader.nextLine();
				if("exit".equals(line)) {
					break;
				}
				//������̨����д�뵽���棻
				buffer.put(line.getBytes("UTF-8"));
				//���û����αꣻ
				buffer.flip();
				//�����ݷ��͸���������
				channel.write(buffer);
				//д��֮������������ݣ�
				buffer.clear();
				
				//��ȡ���������ص����ݣ�
				int readLength=channel.read(buffer);
				if(readLength==-1) {
					break;
				}
				//���û����αꣻ
				buffer.flip();
				byte[] datas=new byte[buffer.remaining()];
				//��ȡ���ݵ��ֽ����飻
				buffer.get(datas);
				System.out.println("from server:"+ new String(datas,"utf-8"));
				//������棻
				buffer.clear();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(channel!=null) {
				try {
					channel.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
