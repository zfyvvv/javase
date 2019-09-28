package cn.zfy.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InitialContext;

/**
 * NIO-server
 * 
 * 2.eclipse�в鵱ǰ��ķ�����
 * ctrl+o;
 * 
 * @author DELL
 *
 */
public class NIOServer implements Runnable{
	//��·��������ѡ����������ע��ͨ����
	private Selector selector;
	//�������������棬�ֱ����ڶ���д����ʼ���ռ��С��λΪ�ֽڣ�
	/**
	 * ��ʱ��buffer�ǲ���ȫ�ģ�����ͻ��˹���һ��buffer��
	 * �����Ҫ��ȫ�����Խ�buffer��װ��ÿһ�������߳��У���Ϊ�����Ŀռ䣻
	 * ����ʹ��threadlocal;
	 */
	private ByteBuffer readBuffer=ByteBuffer.allocate(1024);
	private ByteBuffer writeBuffer=ByteBuffer.allocate(1024);
	
	public static void main(String[] args) {
		new Thread(new NIOServer(9999)).start();
	}
	
	public NIOServer(int port) {
		init(port);
	}

	private void init(int port) {
		try {
			System.out.println("server starting at port"+port+"...");
			//������·����������̬������
			this.selector=Selector.open();
			//��������ͨ����
			ServerSocketChannel serverChannel=ServerSocketChannel.open();
			//��������������ݲ���Ϊtrue����Ϊ������
			serverChannel.configureBlocking(false);
			//�󶨶˿ڣ�
			serverChannel.bind(new InetSocketAddress(port));
			//ע�ᣬ����ǵ�ǰ����ͨ��״̬��
			/**
			 * register(Selector,int)
			 * int ״̬�룻
			 * OP_ACCEPT:���ӳɹ���ǣ�
			 * OP_READ�����Զ�ȡ���ݵı�ǣ�
			 * OP_WRITE������д�����ݵı�ǣ�
			 * OP_CONNEC�����ӽ�����ı�ǣ�
			 * server��������ע���ڶ�·�������ϵĵģ�
			 * 
			 */
			serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
			System.out.println("server started.");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				//����������������һ��ͨ����ѡ�У��˷����Żأ�
				//ͨ���Ƿ�ѡ����ע�ᵽ��·�������е�ͨ��������
				this.selector.select();
				//������ѡ�е�ͨ����Ǽ��ϣ������б�����Ǽ��ϵı�ǣ��൱����ͨ����ID��
				Iterator<SelectionKey> keys=this.selector.selectedKeys().iterator();
				while(keys.hasNext()) {
					SelectionKey key=keys.next();
					//������Ҫ�����ͨ���Ӽ�����ɾ�����´�ѭ�������µ�ͨ���б��ٴ�ִ�б�Ҫ��ҵ���߼���
					keys.remove();
					//ͨ���Ƿ���Ч��
					if(key.isValid()) {
						//����״̬��
						try {
							if(key.isAcceptable()) {
								accept(key);
							}
						} catch (Exception e) {
							// �Ͽ����ӣ������쳣��
							key.cancel();
						}
						//�ɶ�״̬��
						try {
							if(key.isReadable()) {
								read(key);
							}
						} catch (Exception e) {
							// �Ͽ����ӣ������쳣��
							key.cancel();
						}
						//��д״̬��
						try {
							if(key.isWritable()) {
								write(key);
							}
						} catch (Exception e) {
							// �Ͽ����ӣ������쳣��
							key.cancel();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private void write(SelectionKey key) {
		//д�Ͷ��Ĺ��̲�ࣻ
		//��ջ��棻
		this.writeBuffer.clear();
		SocketChannel channel=(SocketChannel) key.channel();
		Scanner reader=new Scanner(System.in);
		try {
			System.out.println("put message for send to client >");
			String line=reader.nextLine();
			//������̨������ַ���д��buffer�У�д���������һ���ֽ����ݣ�
			writeBuffer.put(line.getBytes("UTF-8"));
			writeBuffer.flip();
			channel.write(writeBuffer);
			//д��֮���ɶ�����������д֮�������ֻ���
			channel.register(this.selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void read(SelectionKey key) {
		try {
			//��ն����棻
			this.readBuffer.clear();
			//��ȡͨ����
			SocketChannel channel=(SocketChannel) key.channel();
			//��ͨ���е����ݶ�ȡ�������У�ͨ���е����ݾ��ǿͻ��˷��͸������������ݣ�
			int readLength=channel.read(readBuffer);
			//���ͻ����Ƿ�д�����ݣ�
			if(readLength==-1) {
				//�ر�ͨ����
				key.channel().close();
				//�ر����ӣ�
				key.cancel();
				return ;
			}
			/**
			 * NIO�У���ӵĲ�������buffer�Ŀ��ƣ���
			 * buffer����һ���α꣬�α���Ϣ�ڲ����󲻻���㣬���ֱ�ӷ���buffer�Ļ��������в�һ�µĿ��ܣ�
			 * flip�������α�ķ�����NIO����У�flip�����ǳ��õķ�����
			 */
			this.readBuffer.flip();
			//�ֽ����ݱ��棬����������ݵģ�readBuffer.remaining()->�ǻ�ȡbuffer����Ч���ݳ��ȵķ�����
			//ʵ�ʿ���ʱ��ע��ѭ��������
			byte[] datas=new byte[readBuffer.remaining()];
			//�ǽ�buffer�е���Ч���ݱ��浽�ֽ������У�
			readBuffer.get(datas);
			System.out.println("from"+channel.getRemoteAddress()+"cilent> "
					+new String(datas));
			//ע��ͨ���󣬱��Ϊд����״̬��
			channel.register(this.selector, SelectionKey.OP_WRITE);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				key.channel().close();
				key.cancel();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//����״̬��
	private void accept(SelectionKey key) {
		try {
			//��ͨ��Ϊinit������ע�ᵽSelector�ϵ�ServerSocketChannel��
			ServerSocketChannel serverChannel=(ServerSocketChannel) key.channel();
			//�������������ͻ��˷�������󷵻أ���ͨ���Ϳͻ���һһ��Ӧ��
			SocketChannel channel=serverChannel.accept();
			channel.configureBlocking(false);
			//���ö�Ӧ�ͻ��˵�ͨ����ǣ���ͨ��Ϊ��ȡ����ʹ�õģ�
			//accept֮����read״̬���ȿͻ��˵����ݣ�
			channel.register(this.selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
