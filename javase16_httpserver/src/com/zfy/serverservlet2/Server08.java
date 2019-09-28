package com.zfy.serverservlet2;

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
 * 	���������ļ���̬�Ķ�ȡ�������ٽ��з����ȡ�����Servlet��������ҵ���������Բ���Ӧ��䣻
 * 6������ַ�����������̣߳�����ѭ��������ÿ��������������
 * 7�����봦��ҳ�棻
 * @author DELL
 *
 */
public class Server08 {
	private ServerSocket serverSocket;
	private boolean isRunning;
	public static void main(String[] args) {
		Server08 server=new Server08();
		server.start();
	}
	//server������
	public void start() {
		isRunning=true;
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
		while(isRunning) {
			try {
				Socket client= serverSocket.accept();
				//�������Ӻ�ʵ�ֶ��̵߳Ĵ���
				new Thread(new Dispatcher(client)).start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ͻ��˴��󣡣�");
			}
		}
	}
	//ֹͣ����
	public void stop() {
		isRunning=false;
		try {
			this.serverSocket.close();
			System.out.println("��������ֹͣ��");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
