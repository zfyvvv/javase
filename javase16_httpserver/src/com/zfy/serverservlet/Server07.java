package com.zfy.serverservlet;

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
 * 4��������servlet��������ҵ����룻
 * ����ʹ��new�ķ�ʽ���ܲ���
 * 5�����뷴���xml�ļ���
 * @author DELL
 *
 */
public class Server07 {
	private ServerSocket serverSocket;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server07 server=new Server07();
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
			Servlet servlet=null;
			if(request.getUrl().equals("login")) {
				servlet=new LoginServlet();
			}else if(request.getUrl().equals("regin")) {
				servlet=new ReginServlet();
			}else {
				//����ҳ�棻
			}
			
			
			servlet.service(request, respond);
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
