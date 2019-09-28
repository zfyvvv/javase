package cn.zfy.netty1;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NetServer {
	
	private final int port;

    public  NetServer(int port) {
        this.port = port;
    }
        public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(
                    "Usage: " +  NetServer.class.getSimpleName() +
                    " <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);        
        new  NetServer(port).start();                
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup(); 
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)                                
             .channel(NioServerSocketChannel.class)       
             .localAddress(new InetSocketAddress(port))    
             .childHandler(new ChannelInitializer<SocketChannel>() { 
                 @Override
                 public void initChannel(SocketChannel ch) 
                     throws Exception {
                     ch.pipeline().addLast(
                             new  NetServerHandler());
                 }
             });

            ChannelFuture f = b.bind().sync();            
            System.out.println( NetServer.class.getName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();           
        } finally {
            group.shutdownGracefully().sync();            
        }
    }

}
