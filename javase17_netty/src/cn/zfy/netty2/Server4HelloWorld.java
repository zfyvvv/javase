package cn.zfy.netty2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.example.echo.EchoServerHandler;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 双线程组；
 * @author DELL
 *
 */
public class Server4HelloWorld {
	private EventLoopGroup acceptorGroup=null;
	private EventLoopGroup clientGroup=null;
	private ServerBootstrap bootstrap=null;
	public Server4HelloWorld() {
		init();
	}
	
	private void init() {
		acceptorGroup=new NioEventLoopGroup();
		clientGroup=new NioEventLoopGroup();
		bootstrap=new ServerBootstrap();
		bootstrap.group(acceptorGroup,clientGroup);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
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
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(acceptorHandlers);
			}
		});
		
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
		Server4HelloWorld server=null;
		try {
			server=new Server4HelloWorld();
			future=server.doAccept(9999,new Server4HelloWorldHandler());
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
