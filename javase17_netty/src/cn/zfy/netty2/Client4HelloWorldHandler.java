package cn.zfy.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;

public class Client4HelloWorldHandler extends ChannelInboundHandlerAdapter{
	
	//这是netty5的内容！！！！！！！！！！！！！！！！！！！！！！！！！
	//不是netty4的内容！！！！！！！！！！！！！！！！！！！！！！！！！！
	/*public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception {
		try {
			ByteBuf readBuffer=(ByteBuf) msg;
			byte[] tempDatas=new byte[readBuffer.readableBytes()];
			readBuffer.readBytes(tempDatas);
			System.out.println("from server : "+new String(tempDatas,"UTF-8"));
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	public void exceptionCatch(ChannelHandlerContext ctx,Throwable cause) throws Exception{
		System.out.println("client exceptionCatch run...");
		ctx.close();
		
	}*/
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			ByteBuf readBuffer=(ByteBuf) msg;
			byte[] tempDatas=new byte[readBuffer.readableBytes()];
			readBuffer.readBytes(tempDatas);
			System.out.println("from server : "+new String(tempDatas,"UTF-8"));
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	
}
