package cn.zfy.chatD3;
/**
 * Thread():���̣߳�������Ϣ�ͷ�����Ϣ˳�����⣻
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
	public static void main(String[] args) throws IOException {
		ServerSocket ser=new ServerSocket(10000);
		while(true) {//����ͻ���
		//��������
		Socket socs=ser.accept();//һ��accept��һ���ͻ��ˣ�
		
		DataInputStream dis=new DataInputStream(socs.getInputStream());
		DataOutputStream dos=new DataOutputStream(socs.getOutputStream());
		System.out.println("һ���ͻ����Ѿ���������.....");
		//��������
		while(true) {//��ν������ݣ������д��
		String msgs=dis.readUTF();
		System.out.println(msgs);
		dos.writeUTF("������-->"+msgs);
		dos.flush();}
		}
		//new Thread(new Recive(ser.accept())).start();//��һ��·�����������ݣ�
		//new Thread(new Send(ser.accept())).start();//һ��·�����������ݣ�
		
		
		
		
		
	}

}
