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
 * @Sharableע�⣺
 * ����ǰHandler��һ�����Է���Ĵ�������Ҳ����ζ�ţ�������ע���handler�󣬿��Է��������ͻ���ͬʱʹ�ã�
 * �����ʹ��ע���������ͣ���ÿ�οͻ�������ʱ����������Ϊ�ͻ��˴���һ���µ�handler����
 * ���handler��һ��Sharable�ģ�һ�����ⶨ���д��ʵ��������
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
	//�м̳У���ʵ�֣��˴��̳У���д�ķ�����һЩ��
	
	/**
	 * �쳣�����߼������ͻ����쳣�˳���ʱ��Ҳ��رգ�
	 * ChannelHandlerContext�رգ�����ǰ��ͻ������ӵ���Դ�رգ�
	 * @param ctx
	 * @param cause
	 * @throws Exception
	 */
	/*public void exceptionCatch(ChannelHandlerContext ctx,Throwable cause) throws Exception{
		System.out.println("server exceptionCatch run...");
		ctx.close();
	}*/

	
	/**
	 * ҵ�����߼���
	 * ���ڴ����ȡ����������߼���
	 * @param ctx �����Ķ������а����ͻ��˽������ӵ�������Դ�������Ӧ����Դ��
	 * @param msg ��ȡ�������ݣ�Ĭ������ΪByteBuf��ByteBuf��netty�Զ���ģ�
	 * 			�ǵ�ByteBuffer�ķ�װ������Ҫ���Ǹ�λ���⣻
	 * @throws Exception
	 */
	/*public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ��ȡ�����ݣ���һ�����壻
				ByteBuf readBuffer=(ByteBuf) msg;
				//����һ���ֽ����飬���ڱ��滺���е����ݣ�
				byte[] tempDatas=new byte[readBuffer.readableBytes()];
				//�������е����ݶ�ȡ���ֽ������У�
				readBuffer.readBytes(tempDatas);
				String message=new String(tempDatas,"UTF-8");
				System.out.println("from client : "+message);
				if("exit".equals(message)) {
					ctx.close();
					return ;
				}
				String line="server message to client";
				//д�����Զ��ͷŻ��棬�����ڴ�������⣻
				ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
				//ע�⣬���ֻ����write����������ˢ�»��棻�����е����ݲ��ᷢ�͵��ͻ��ˣ������ٴε���flush������
				//ctx.write(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
				//ctx.flush();
	}*/

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf readBuffer=(ByteBuf) msg;
		//����һ���ֽ����飬���ڱ��滺���е����ݣ�
		byte[] tempDatas=new byte[readBuffer.readableBytes()];
		//�������е����ݶ�ȡ���ֽ������У�
		readBuffer.readBytes(tempDatas);
		String message=new String(tempDatas,"UTF-8");
		System.out.println("from client : "+message);
		if("exit".equals(message)) {
			ctx.close();
			return ;
		}
		String line="server message to client";
		//д�����Զ��ͷŻ��棬�����ڴ�������⣻
		ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
		//ע�⣬���ֻ����write����������ˢ�»��棻�����е����ݲ��ᷢ�͵��ͻ��ˣ������ٴε���flush������
		//ctx.write(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
		//ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
}
