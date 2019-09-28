package cn.zfy.udp;
/**
 * UDP��������Ϊ���ĵĴ��䣻��·�̶�������ȫ��Ч�ʸߣ�
 * 1-��һ���ͻ��ˣ�
 */
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket client=new DatagramSocket(6666);//���������+ָ���˿ڣ�DatagramSocket
		/*String msg="UDP-zfy";//׼�����ݣ��ֽ�����
		byte[] data=msg.getBytes();*/
		double d=3.33;//����Դ
		//Ŀ��Դ
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//������������bosԴ�У�
		DataOutputStream dos=new DataOutputStream(bos);
		//����������ת�����ֽ����飻bos.writeXXX����ʼд��
		dos.writeDouble(d);
		//ʹ���������bos�ֽ���������ֽ����飨��--->���飩
		byte[] data=bos.toByteArray();
		//������ͣ����͵���������ַ�Ͷ˿ڣ�������Ϣ����ȷ��λ�úͶ˿ڣ��������ݣ������������ӣ���
		DatagramPacket pac=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8866));
		//�ͻ��˷������������ݣ��԰�����ʽ���ͣ�
		client.send(pac);
		bos.close();
		dos.close();
		//�ͷ���Դ��
		client.close();
	}

}
