package com.zfy.serverservlet2;

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
 * 	根据配置文件动态的读取类名，再进行反射获取具体的Servlet类来处理业务，真正的以不变应万变；
 * 6、加入分发器，加入多线程，加上循环，不用每次重启服务器；
 * 7、加入处理页面；
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
	//server开启；
	public void start() {
		isRunning=true;
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
		while(isRunning) {
			try {
				Socket client= serverSocket.accept();
				//建立连接后，实现多线程的处理
				new Thread(new Dispatcher(client)).start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("客户端错误！！");
			}
		}
	}
	//停止服务；
	public void stop() {
		isRunning=false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已停止！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
