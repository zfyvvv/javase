package com.zfy.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1����װ����Э�飺��ȡmethod,uri��info��
 * 2����̬������ӦЭ�飺repsond;
 * @author DELL
 *
 */
public class Server03 {
	private ServerSocket serverSocket;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server03 server=new Server03();
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
			//����request�Ĳ����ŵ�һ�����У�
			Request request=new Request(client);
			
			//�����Ϣ���ͻ��ˣ���Ӧ�ͻ��ˣ�
			Respond respond=new Respond(client);
			//��ע���ݣ�
			respond.print("<html><head><title>HTTP</title>"+
			                      "<head><body>Hellow,LT,IOU</body></html>");
			//��ע״̬�룻
			respond.pushToClient(200);
			
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
