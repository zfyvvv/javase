package com.zfy.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1����װ����Э�飺��ȡmethod,uri;
 * 2����̬������ӦЭ�飺repsond;
 * 3����������Ϣ��װ��map��
 * @author DELL
 *
 */
public class Server05 {
	private ServerSocket serverSocket;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server05 server=new Server05();
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
			Request02 request=new Request02(client);
			Respond respond=new Respond(client);
			respond.print("<html><head><title>HTTP</title><head><body>"
			+"Hellow,LT,IOU,-->"
			+request.getParameter("uname")
			+"<--"
			+"</body></html>");
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
