package com.zfy.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1、返回响应协议；
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
			System.out.println("一个客户端建立起连接！！");
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
			
			//输出信息给客户端，响应客户端；
			//正文！！
			StringBuilder responseContext=new StringBuilder();
			responseContext.append("<html><head><title>HTTP</title>"+
			                      "<head><body>Hellow,LT</body></html>");
			
			StringBuilder response=new StringBuilder();//
			//响应行；HTTP协议版本，状态代码，概述；
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//响应头，
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度，字节长度；必须为字节长度；
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//正文之前；
			response.append(CRLF);
			//正文补充进去；
			response.append(responseContext.toString());
			//输出给客户端的信息；一个字符输出流
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
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
