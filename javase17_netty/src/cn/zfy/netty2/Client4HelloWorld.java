package cn.zfy.netty2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.echo.EchoServerHandler;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * ��Ϊ�ͻ������������ߣ�����Ҫ������
 * ֻ��Ҫ����Ψһ��һ���߳��飻
 * @author DELL
 *
 */
public class Client4HelloWorld {
	//��������ʹ���������Ӧ���߳��飻
	private EventLoopGroup group=null;
	//�����������������Ϣ��
	private Bootstrap bootstrap=null;
	
	public Client4HelloWorld() {
		init();
	}

	private void init() {
		group=new NioEventLoopGroup();
		bootstrap=new Bootstrap();
		//���߳��飻
		bootstrap.group(group);
		//�趨ͨѶģʽΪNIO ;
		bootstrap.channel(NioSocketChannel.class);
	}
	
	public ChannelFuture doRequest(String host,int port,final ChannelHandler... handlers)throws Exception {
		/**
		 * �ͻ��˵�bootstrapû��childhandler������ֻ��handler������
		 * ���������ͬ��Serverbootstrap�е�childhandler������
		 * �ڿͻ��˱���󶨴�������Ҳ���Ǳ������handler������
		 * ����������󶨴��������������childhandler������
		 */
		this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(handlers);
			}
		});
		
		//�������ӣ�
		ChannelFuture future=this.bootstrap.connect(host,port).sync();
		return future;
	}
	
	public void release() {
		this.group.shutdownGracefully();
	}
	
	public static void main(String[] args) {
		Client4HelloWorld client=null;
		ChannelFuture future=null;
		try {
			client=new Client4HelloWorld();
			future=client.doRequest("localhost",9999, new Client4HelloWorldHandler());
			Scanner s=null;
			while(true) {
				s=new Scanner(System.in);
				System.out.println("enter message send to server (enter 'exit' for close)>");
				String line=s.nextLine();
				if("exit".equals(line)) {
					//addListener - ���Ӽ�������ĳ��������ʱ������������
					//ChannelFutureListener.CLOSE - �رռ���������channelfutureִ�з��غ󣬹ر����ӣ�
					future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("utf-8")))
					.addListener(ChannelFutureListener.CLOSE);
					break;
				}
				future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("utf-8")));
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	

}
