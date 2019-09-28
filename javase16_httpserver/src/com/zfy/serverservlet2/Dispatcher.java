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
			//请求协议和响应协议；
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
				//错误页面；
				respond.println("这是404");
				//如果想加入图片等资源，值可以通过类加载器路径寻找资源；
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
				respond.println("这是500");
				respond.pushToClient(500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//此处采用的是短连接；效率高但是不能记住状态；
		this.release();
	}
	
	/**
	 * 1、释放资源；
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
