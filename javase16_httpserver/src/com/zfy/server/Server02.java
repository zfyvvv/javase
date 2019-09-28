package com.zfy.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1��������ӦЭ�飻
 * @author DELL
 *
 */
public class Server02 {
	private ServerSocket serverSocket;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server02 server=new Server02();
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
			
			//�����Ϣ���ͻ��ˣ���Ӧ�ͻ��ˣ�
			//���ģ���
			StringBuilder responseContext=new StringBuilder();
			responseContext.append("<html><head><title>HTTP</title>"+
			                      "<head><body>Hellow,LT</body></html>");
			
			StringBuilder response=new StringBuilder();//
			//��Ӧ�У�HTTPЭ��汾��״̬���룬������
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//��Ӧͷ��
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��ȣ��ֽڳ��ȣ�����Ϊ�ֽڳ��ȣ�
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//����֮ǰ��
			response.append(CRLF);
			//���Ĳ����ȥ��
			response.append(responseContext.toString());
			//������ͻ��˵���Ϣ��һ���ַ������
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
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
