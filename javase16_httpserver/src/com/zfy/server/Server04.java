package com.zfy.server;

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
 * @author DELL
 *
 */
public class Server04 {
	private ServerSocket serverSocket;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server04 server=new Server04();
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
			//将对request的操作放到一个类中；
			Request request=new Request(client);
			
			//输出信息给客户端，响应客户端；
			Respond respond=new Respond(client);
			//关注内容；
			respond.print("<html><head><title>HTTP</title>"+
			                      "<head><body>Hellow,LT,IOU</body></html>");
			//关注状态码；
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
