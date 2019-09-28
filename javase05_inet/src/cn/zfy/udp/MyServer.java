package cn.zfy.udp;
/**
 * UDP��������Ϊ���ĵĴ��䣻��·�̶�������ȫ��Ч�ʸߣ�
 * 1-��һ������ˣ�
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {
	public static void main(String[] args) throws IOException {
		//����������+ָ���˿�  DatagramSocket
		DatagramSocket server=new DatagramSocket(8866);
		//׼���������������ݷ�װ�ɰ���
		byte[] con=new byte[1024];
		DatagramPacket pac=new DatagramPacket(con,con.length);
		server.receive(pac);
		//ʹ�ð��������ݣ�
		byte[] data=pac.getData();
		//�������ݣ�����������ݣ����ֽ�������ڣ���
		//����������ݴ�С
		int len=pac.getLength();
		
		System.out.println(len);
		//���ֽ�����ת���ɻ������ͣ��������
		//�ֽ�������������(data-->z�ֽ�����������)
		ByteArrayInputStream bis=new ByteArrayInputStream(data);
		//������+�������������(�ֽ�����������-->����������)
		DataInputStream dis=new DataInputStream(bis);
		//(�����������������ݣ�����ӡ)
		System.out.println(dis.readDouble());
		//�ͷ���Դ
		dis.close();
		bis.close(); 
		server.close();
	}
}
