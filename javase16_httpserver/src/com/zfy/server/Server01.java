package com.zfy.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1�������ͻ������ӣ���ȡ����Э�飻
 * @author DELL
 *
 */
public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server=new Server01();
		server.start();
	}
	//server������
	public void start() {
		try {
			//���ڶ˿ڿ���ָ����
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����������ʧ�ܣ���");
		}
	}
	//����������Ϣ��
	public  void receive() {
		try {
			Socket client= serverSocket.accept();
			System.out.println("һ���ͻ��˽��������ӣ���");
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ��˴��󣡣�");
		}
	}
	//ֹͣ����
	public void stop() {
		
	}
}
