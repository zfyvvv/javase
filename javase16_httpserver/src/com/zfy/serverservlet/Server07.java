package com.zfy.serverservlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1、封装请求协议：获取method,uri;
 * 2、动态返回响应协议：repsond;
 * 3、将请求信息封装成map；
 * 4、加入了servlet，解耦了业务代码；
 * 但是使用new的方式，很不灵活；
 * 5、加入反射和xml文件，
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

	//server开启；
	public void start() {
		try {
			//后期端口可以指定；
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("服务器启动失败！！");
		}
	}
	//接受请求信息；
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
				//其他页面；
			}
			
			
			servlet.service(request, respond);
			respond.pushToClient(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端错误！！");
		}
	}
	//停止服务；
	public void stop() {
		
	}
}
