package cn.zfy.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.LineListener;

public class AIOServerHandler implements
				CompletionHandler<AsynchronousSocketChannel, AIOServer>{

	
	/**
	 * ҵ�����߼������������󣬼����ɹ���Ӧ����ʲô��
	 * һ��Ҫʵ�ֵ��߼���Ϊ��һ�οͻ���������������accept()�������ã�
	 * result���������ǺͿͻ���ֱ�ӽ���������ͨ����
	 * ������BIO��NIO��AIO��һ���������ӣ����˶���ƽ�ȣ�
	 * �ڽ�������֮ǰ������˱Ƚ��ر���Ҫһ�ֻ��Ʊ��ּ�����
	 * result����ͨ���е�����������ݣ��磺OS����ϵͳ׼���õĶ�ȡ���ݻ��棬��ȴ����ص����ݻ��棻 
	 */
	@Override
	public void completed(AsynchronousSocketChannel result, AIOServer attachment) {
		//������һ�εĿͻ����������Ƶݹ��߼���
		attachment.getServerChannel().accept(attachment,this);
		doRead(result);
	}

	/**
	 * �쳣�����߼������������˴�������쳣��ʱ����ʲô���飻
	 */
	@Override
	public void failed(Throwable exc, AIOServer attachment) {
		exc.printStackTrace();
		
	}
	
	private void doRead(final AsynchronousSocketChannel channel) {
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		/**
		 * �첽������read(buffer destination,A attachment,
		 * 				CompletionHandler<Integer, ? super A>handler)
		 * destination-Ŀ�ĵأ��Ǵ���ͻ��˴������ݵ���ת���棻���Բ�ʹ�ã�
		 * attachment-����ͻ��˴������ݵĶ���ͨ��ʹ��buffer����
		 * handler-�����߼���
		 * 
		 */
		
		channel.read(buffer,buffer, new CompletionHandler<Integer, ByteBuffer>() {

			/**
			 * ҵ���߼�����ȡ�ͻ��˴������ݣ�
			 * result-���ݵĳ��ȣ�
			 * attachment-��complete����ִ�е�ʱ��OS�Ѿ����ͻ������������д�뵽buffer�У�
			 * ����δ��λ��flip����ʹ��ǰһ��Ҫ��λ��
			 * 
			 * attachment.array()-���ֽڱ���ֽ����飻
			 * 
			 */
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				try {
					System.out.println(attachment.capacity());
					attachment.flip();
					System.out.println("from client : "+new String(attachment.array(), "UTF-8"));
					//����֮����д������
					doWrite(channel);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				
			}
			
		});
	}
	
	/**
	 * ��ʵ��Ŀ�У����������صĽ��Ӧ���Ǹ��ݿͻ��˵��������ݼ���õ��ģ����ǵȴ�����̨����ģ�
	 * @param result
	 */
	private void doWrite(AsynchronousSocketChannel result) {
		try {
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			System.out.println("enter message send to client > ");
			Scanner s=new Scanner(System.in);
			String line=s.next();
			buffer.put(line.getBytes("UTF-8"));
			//�ص㣺���븴λ�����븴λ�����븴λ��
			buffer.flip();
			//write()������һ���첽����������ʵ����OSʵ�֣�
			//��������get()������ʵ���������ȴ�OS�����Ľ�����
			result.write(buffer);
			//����get������������������߳��������ȴ�д������ɣ�
			//result.write(buffer).get();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
