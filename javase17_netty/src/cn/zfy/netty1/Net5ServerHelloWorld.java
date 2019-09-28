package cn.zfy.netty1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 双线程组；
 * @author DELL
 *
 */
public class Net5ServerHelloWorld {
	//监听线程组，监听客户端的请求；
	private EventLoopGroup acceptorGroup=null;
	//处理客户端相关操作线程组，负责处理与客户端的数据通讯；
	private EventLoopGroup clientGroup=null;
	//服务启动相关配置信息；
	private ServerBootstrap bootstrap=null;
	public Net5ServerHelloWorld() {
		init();
	}
	//初始化过程；上面属性对象都已经初始化完成；
	private void init() {
		//初始化线程组，构建线程组的时候，如果不传递参数，则默认构建的线程组线程数是CPU核心数量；
		//此处决定线程模型-->单线程模型，多线程模型，主从线程模型；
		acceptorGroup=new NioEventLoopGroup();
		clientGroup=new NioEventLoopGroup();
		bootstrap=new ServerBootstrap();
		//绑定线程组；
		bootstrap.group(acceptorGroup,clientGroup);
		//设置通讯模式为NIO;同步非阻塞；
		bootstrap.channel(NioServerSocketChannel.class);
		//设置缓冲区大小；缓冲区的单位是字节；
		bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
		//SO_SNDBU发送缓冲区；SO_RCVBUF接受缓冲区;SO_KEEPALIVE开启心跳监测（保证连接有效性）；
		bootstrap.option(ChannelOption.SO_SNDBUF, 1024)
				.option(ChannelOption.SO_RCVBUF, 16*1024)
				.option(ChannelOption.SO_KEEPALIVE, true);
	}
	
	/**
	 * 监听处理逻辑；
	 * @param port 监听端口；
	 * @param acceptorHandlers 处理器，如何处理客户端请求；
	 * @return
	 * @throws Exception
	 */
	public ChannelFuture doAccept(int port,final ChannelHandler... acceptorHandlers)throws Exception {
		/**
		 * childHandler是服务的bootstrap独有的方法，是用于提供处理对象的。
		 * 可以一次增加若干个处理逻辑，是类似责任链的处理方式；
		 * 增加A，B两个处理逻辑，在处理客户端请求数据时，根据A-->B顺序依次处理；
		 * 
		 * ChannelInitializer - 用于提供处理器的一个模型对象；
		 * 其中定义了一个方法；initChannel()方法；
		 * 方法是用于初始化处理逻辑责任链条的；
		 * 可以保证服务器端的bootstrap只初始化一次处理器，尽量提供处理逻辑的重用；
		 * 避免反复的创建处理器对象，节约资源开销；
		 */
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(acceptorHandlers);
			}
		});
		//bind方法， - 绑定监听端口，serverbootstrap可以绑定多个监听端口；多次调用bind方法即可；
		//sync() - 开始监听逻辑，返回一个ChannelFuture；返回结果代表的是监听成功后的一个对应的未来结果；
		//可以使用ChannelFuture实现后续的服务器和客户端的交互；
		ChannelFuture future=bootstrap.bind(port).sync();
		return future;
	}
	
	/**
	 * shutdownGracefully() - 是一个安全关闭的方法，可以保证不放弃任何一个已接受的客户端请求；
	 * 
	 */
	public void release() {
		this.acceptorGroup.shutdownGracefully();
		this.clientGroup.shutdownGracefully();
	}
	public static void main(String[] args) {
		ChannelFuture future=null;
		Net5ServerHelloWorld server=null;
		try {
			server=new Net5ServerHelloWorld();
			future=server.doAccept(9999,new Net5ServerHelloWorldHandler());
			System.out.println("server started...");
			//关闭连接的
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(null!=future) {
				try {
					future.channel().closeFuture().sync();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(null!=server) {
				server.release();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}
