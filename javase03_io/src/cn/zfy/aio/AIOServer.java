package cn.zfy.aio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Timestamp;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.naming.InitialContext;

/**
 * NIO-server
 * 
 * 
 * @author DELL
 *
 */
public class AIOServer{
	//线程池，提高服务端效率；
	private ExecutorService service;
	
	//线程组
	private AsynchronousChannelGroup group;
	
	//服务端通道，针对服务器端定义的通道；
	private AsynchronousServerSocketChannel serverChannel;
	
	public AIOServer(int port) {
		init(9999);
	}
	
	private void init(int port) {
		try {
			System.out.println("server starting at port : "+port+"...");
			//定长线程池；
			service=Executors.newFixedThreadPool(2);
			
			//使用线程组；
		/*	group=AsynchronousChannelGroup.withThreadPool(service);
			serverChannel=AsynchronousServerSocketChannel.open(group);*/
			//开启服务通道;通过静态方法创建的；
			serverChannel=AsynchronousServerSocketChannel.open();
			//绑定监听端口;服务器启动成功，但是未监听请求；
			serverChannel.bind(new InetSocketAddress(port));
			System.out.println("server started.");
			//开始监听；
			//serverChannel.accept(attachment, handler);
			//accept(T attachment, CompletionHandler<AsynchronousSocketChannel,? super T>);
			//AIO开发中，监听是一个类似递归的监听操作；每次监听到客户端请求后，都需要处理开启下一次监听；
			//下一次的监听，需要服务器的资源继续支持；
			serverChannel.accept(this, new AIOServerHandler());
			
			TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//主函数new了一个对象；
		new AIOServer(9999);
	}

	public ExecutorService getService() {
		return service;
	}

	public void setService(ExecutorService service) {
		this.service = service;
	}

	public AsynchronousServerSocketChannel getServerChannel() {
		return serverChannel;
	}

	public void setServerChannel(AsynchronousServerSocketChannel serverChannel) {
		this.serverChannel = serverChannel;
	}
	
	
	
}
