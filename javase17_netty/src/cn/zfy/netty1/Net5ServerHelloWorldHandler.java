package cn.zfy.netty1;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;

/**
 * @Sharable注解：
 * 代表当前Handler是一个可以分享的处理器，也就意味着，服务器注册此handler后，可以分享给多个客户端同时使用；
 * 如果不使用注解描述类型，则每次客户端请求时，必须重新为客户端创建一个新的handler对象。
 * 如果handler是一个Sharable的，一定避免定义可写的实例变量；
 * 	bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(XxxHandlers);
			}
		});
 * 
 * @author DELL
 *
 */
@Sharable
public class Net5ServerHelloWorldHandler extends ChannelInboundHandlerAdapter{
	//有继承，有实现；此处继承，重写的方法少一些；
	
	/**
	 * 异常处理逻辑；当客户端异常退出的时候，也会关闭；
	 * ChannelHandlerContext关闭，代表当前与客户端连接的资源关闭；
	 * @param ctx
	 * @param cause
	 * @throws Exception
	 */
	/*public void exceptionCatch(ChannelHandlerContext ctx,Throwable cause) throws Exception{
		System.out.println("server exceptionCatch run...");
		ctx.close();
	}*/

	
	/**
	 * 业务处理逻辑；
	 * 用于处理读取数据请求的逻辑；
	 * @param ctx 上下文对象，其中包含客户端建立连接的所有资源，比如对应的资源；
	 * @param msg 读取到的数据，默认类型为ByteBuf；ByteBuf是netty自定义的，
	 * 			是的ByteBuffer的封装；不需要考虑复位问题；
	 * @throws Exception
	 */
	/*public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
		// TODO Auto-generated method stub
		//获取读取的数据，是一个缓冲；
				ByteBuf readBuffer=(ByteBuf) msg;
				//创建一个字节数组，用于保存缓存中的数据；
				byte[] tempDatas=new byte[readBuffer.readableBytes()];
				//将缓冲中的数据读取到字节数组中，
				readBuffer.readBytes(tempDatas);
				String message=new String(tempDatas,"UTF-8");
				System.out.println("from client : "+message);
				if("exit".equals(message)) {
					ctx.close();
					return ;
				}
				String line="server message to client";
				//写操作自动释放缓存，避免内存溢出问题；
				ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
				//注意，如果只调用write方法，不会刷新缓存；缓存中的数据不会发送到客户端，必须再次调用flush方法；
				//ctx.write(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
				//ctx.flush();
	}*/

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf readBuffer=(ByteBuf) msg;
		//创建一个字节数组，用于保存缓存中的数据；
		byte[] tempDatas=new byte[readBuffer.readableBytes()];
		//将缓冲中的数据读取到字节数组中，
		readBuffer.readBytes(tempDatas);
		String message=new String(tempDatas,"UTF-8");
		System.out.println("from client : "+message);
		if("exit".equals(message)) {
			ctx.close();
			return ;
		}
		String line="server message to client";
		//写操作自动释放缓存，避免内存溢出问题；
		ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
		//注意，如果只调用write方法，不会刷新缓存；缓存中的数据不会发送到客户端，必须再次调用flush方法；
		//ctx.write(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
		//ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
}
