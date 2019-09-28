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
 * ˫�߳��飻
 * @author DELL
 *
 */
public class Net5ServerHelloWorld {
	//�����߳��飬�����ͻ��˵�����
	private EventLoopGroup acceptorGroup=null;
	//����ͻ�����ز����߳��飬��������ͻ��˵�����ͨѶ��
	private EventLoopGroup clientGroup=null;
	//�����������������Ϣ��
	private ServerBootstrap bootstrap=null;
	public Net5ServerHelloWorld() {
		init();
	}
	//��ʼ�����̣��������Զ����Ѿ���ʼ����ɣ�
	private void init() {
		//��ʼ���߳��飬�����߳����ʱ����������ݲ�������Ĭ�Ϲ������߳����߳�����CPU����������
		//�˴������߳�ģ��-->���߳�ģ�ͣ����߳�ģ�ͣ������߳�ģ�ͣ�
		acceptorGroup=new NioEventLoopGroup();
		clientGroup=new NioEventLoopGroup();
		bootstrap=new ServerBootstrap();
		//���߳��飻
		bootstrap.group(acceptorGroup,clientGroup);
		//����ͨѶģʽΪNIO;ͬ����������
		bootstrap.channel(NioServerSocketChannel.class);
		//���û�������С���������ĵ�λ���ֽڣ�
		bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
		//SO_SNDBU���ͻ�������SO_RCVBUF���ܻ�����;SO_KEEPALIVE����������⣨��֤������Ч�ԣ���
		bootstrap.option(ChannelOption.SO_SNDBUF, 1024)
				.option(ChannelOption.SO_RCVBUF, 16*1024)
				.option(ChannelOption.SO_KEEPALIVE, true);
	}
	
	/**
	 * ���������߼���
	 * @param port �����˿ڣ�
	 * @param acceptorHandlers ����������δ���ͻ�������
	 * @return
	 * @throws Exception
	 */
	public ChannelFuture doAccept(int port,final ChannelHandler... acceptorHandlers)throws Exception {
		/**
		 * childHandler�Ƿ����bootstrap���еķ������������ṩ�������ġ�
		 * ����һ���������ɸ������߼����������������Ĵ���ʽ��
		 * ����A��B���������߼����ڴ���ͻ�����������ʱ������A-->B˳�����δ���
		 * 
		 * ChannelInitializer - �����ṩ��������һ��ģ�Ͷ���
		 * ���ж�����һ��������initChannel()������
		 * ���������ڳ�ʼ�������߼����������ģ�
		 * ���Ա�֤�������˵�bootstrapֻ��ʼ��һ�δ������������ṩ�����߼������ã�
		 * ���ⷴ���Ĵ������������󣬽�Լ��Դ������
		 */
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(acceptorHandlers);
			}
		});
		//bind������ - �󶨼����˿ڣ�serverbootstrap���԰󶨶�������˿ڣ���ε���bind�������ɣ�
		//sync() - ��ʼ�����߼�������һ��ChannelFuture�����ؽ��������Ǽ����ɹ����һ����Ӧ��δ�������
		//����ʹ��ChannelFutureʵ�ֺ����ķ������Ϳͻ��˵Ľ�����
		ChannelFuture future=bootstrap.bind(port).sync();
		return future;
	}
	
	/**
	 * shutdownGracefully() - ��һ����ȫ�رյķ��������Ա�֤�������κ�һ���ѽ��ܵĿͻ�������
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
			//�ر����ӵ�
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
