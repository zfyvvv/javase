package cn.zfy.nio;

import java.nio.ByteBuffer;
/**
 * bufferӦ�õĹ̶��߼���
 * д����˳��
 * 1.clear()��
 * 2.put() ->��д������
 * 3.flip() ->�����αꣻ
 * 4.SocketChannel.write(buffer)->���������ݷ��͵��������һ�ˣ�\
 * 5.clear()
 * 
 * ������˳��
 * 1.clear()��
 * 2.SocketChannel.read(buffer)->���������ݷ��͵��������һ�ˣ�\
 * 3.buffer.flip() ->�����αꣻ
 * 4.buffer.get() ->��ȡ���ݣ�
 * 5.buffer.clear();
 * 
 * 2.NIO�����еĲ������ǽ�����buffer�еģ�channel�Ķ�д���ǽ���buffer�Ĳٲ�����
 * 
 *
 */
public class TestBuffer {
	
	public static void main(String[] args) {
		ByteBuffer buffer=ByteBuffer.allocate(8);
		byte[] temp=new byte[] {3,2,1};
		
		//д������֮ǰ�� java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
		//�α�Ϊ0������Ϊ8������Ϊ8��
		System.out.println("д������֮ǰ�� "+buffer);
		
		//���ֽ�����д�뵽���棻
		buffer.put(temp);
		
		//д������֮�� java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
		//�α�Ϊ3������Ϊ8������Ϊ8��
		System.out.println("д������֮�� "+buffer);
		
		//�����αꣻʵ���ǣ�lim=pos;pos=0;
		buffer.flip();
		
		//�����α�֮�� java.nio.HeapByteBuffer[pos=0 lim=3 cap=8]
		//�α�Ϊ0������Ϊ3������Ϊ8��
		System.out.println("�����α�֮�� "+buffer);
		
		//��ջ��棻ʵ���ǣ�lim=cap;pos=0;
		buffer.clear();
		
/*		//get()->��ȡ��ǰ�α�ָ���λ�õ����ݣ�
		System.out.println(buffer.get());*/
		
		//remaining()-> 
		for(int i=0;i<buffer.remaining();i++) {
			//get(index i)->��ȡָ��λ�õ����ݣ�
			int data=buffer.get(i);
			System.out.println(i+" - "+data);
		}
		
	}

}
