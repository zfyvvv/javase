package com.zfy.serverservlet2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatcher implements Runnable{
	private Socket client;
	private Request02 request;
	private Respond respond;
	
	public Dispatcher(Socket client) {
		this.client=client;
		try {
			//����Э�����ӦЭ�飻
			request=new Request02(client);
			respond=new Respond(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.release();
		}
	}

	@Override
	public void run() {
		try {
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if(null==request.getUrl()||request.getUrl().equals("")) {
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] datas=new byte[1024*1024];
				int len=is.read(datas);
				respond.println(new String(datas,0,len));
				is.close();
				respond.pushToClient(200);
				return ;
			}
			
			if(null!=servlet) {
				servlet.service(request, respond);
				respond.pushToClient(200);
			}else {
				//����ҳ�棻
				respond.println("����404");
				//��������ͼƬ����Դ��ֵ����ͨ���������·��Ѱ����Դ��
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] datas=new byte[1024*1024];
				int len=is.read(datas);
				respond.println(new String(datas,0,len));
				is.close();
				respond.pushToClient(404);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				respond.println("����500");
				respond.pushToClient(500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//�˴����õ��Ƕ����ӣ�Ч�ʸߵ��ǲ��ܼ�ס״̬��
		this.release();
	}
	
	/**
	 * 1���ͷ���Դ��
	 */
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
