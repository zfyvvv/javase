package cn.zfy.nio;

import java.nio.ByteBuffer;
/**
 * buffer应用的固定逻辑；
 * 写操作顺序；
 * 1.clear()；
 * 2.put() ->读写操作；
 * 3.flip() ->重置游标；
 * 4.SocketChannel.write(buffer)->将缓存数据发送到网络的另一端；\
 * 5.clear()
 * 
 * 读操作顺序；
 * 1.clear()；
 * 2.SocketChannel.read(buffer)->将缓存数据发送到网络的另一端；\
 * 3.buffer.flip() ->重置游标；
 * 4.buffer.get() ->读取数据；
 * 5.buffer.clear();
 * 
 * 2.NIO中所有的操作都是建立在buffer中的；channel的读写都是借助buffer的操操作；
 * 
 *
 */
public class TestBuffer {
	
	public static void main(String[] args) {
		ByteBuffer buffer=ByteBuffer.allocate(8);
		byte[] temp=new byte[] {3,2,1};
		
		//写入数据之前： java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
		//游标为0；限制为8；容量为8；
		System.out.println("写入数据之前： "+buffer);
		
		//将字节数组写入到缓存；
		buffer.put(temp);
		
		//写入数据之后： java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
		//游标为3；限制为8；容量为8；
		System.out.println("写入数据之后： "+buffer);
		
		//重置游标；实际是：lim=pos;pos=0;
		buffer.flip();
		
		//重置游标之后： java.nio.HeapByteBuffer[pos=0 lim=3 cap=8]
		//游标为0；限制为3；容量为8；
		System.out.println("重置游标之后： "+buffer);
		
		//清空缓存；实际是：lim=cap;pos=0;
		buffer.clear();
		
/*		//get()->获取当前游标指向的位置的数据；
		System.out.println(buffer.get());*/
		
		//remaining()-> 
		for(int i=0;i<buffer.remaining();i++) {
			//get(index i)->获取指定位置的数据；
			int data=buffer.get(i);
			System.out.println(i+" - "+data);
		}
		
	}

}
