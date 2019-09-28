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
 * 因为客户端是请求发起者，不需要监听；
 * 只需要定义唯一的一个线程组；
 * @author DELL
 *
 */
public class Client4HelloWorld {
	//处理请求和处理服务端响应的线程组；
	private EventLoopGroup group=null;
	//服务启动相关配置信息；
	private Bootstrap bootstrap=null;
	
	public Client4HelloWorld() {
		init();
	}

	private void init() {
		group=new NioEventLoopGroup();
		bootstrap=new Bootstrap();
		//绑定线程组；
		bootstrap.group(group);
		//设定通讯模式为NIO ;
		bootstrap.channel(NioSocketChannel.class);
	}
	
	public ChannelFuture doRequest(String host,int port,final ChannelHandler... handlers)throws Exception {
		/**
		 * 客户端的bootstrap没有childhandler方法，只有handler方法；
		 * 方法含义等同于Serverbootstrap中的childhandler方法；
		 * 在客户端必须绑定处理器，也就是必须调用handler方法；
		 * 服务器必须绑定处理器，必须调用childhandler方法；
		 */
		this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(handlers);
			}
		});
		
		//建立连接；
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
					//addListener - 增加监听，当某条件满足时，触发监听；
					//ChannelFutureListener.CLOSE - 关闭监听，代表channelfuture执行返回后，关闭连接；
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
