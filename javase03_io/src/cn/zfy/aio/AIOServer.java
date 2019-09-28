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
	//�̳߳أ���߷����Ч�ʣ�
	private ExecutorService service;
	
	//�߳���
	private AsynchronousChannelGroup group;
	
	//�����ͨ������Է������˶����ͨ����
	private AsynchronousServerSocketChannel serverChannel;
	
	public AIOServer(int port) {
		init(9999);
	}
	
	private void init(int port) {
		try {
			System.out.println("server starting at port : "+port+"...");
			//�����̳߳أ�
			service=Executors.newFixedThreadPool(2);
			
			//ʹ���߳��飻
		/*	group=AsynchronousChannelGroup.withThreadPool(service);
			serverChannel=AsynchronousServerSocketChannel.open(group);*/
			//��������ͨ��;ͨ����̬���������ģ�
			serverChannel=AsynchronousServerSocketChannel.open();
			//�󶨼����˿�;�����������ɹ�������δ��������
			serverChannel.bind(new InetSocketAddress(port));
			System.out.println("server started.");
			//��ʼ������
			//serverChannel.accept(attachment, handler);
			//accept(T attachment, CompletionHandler<AsynchronousSocketChannel,? super T>);
			//AIO�����У�������һ�����Ƶݹ�ļ���������ÿ�μ������ͻ�������󣬶���Ҫ��������һ�μ�����
			//��һ�εļ�������Ҫ����������Դ����֧�֣�
			serverChannel.accept(this, new AIOServerHandler());
			
			TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//������new��һ������
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
