package cn.zfy.chatD1;
/**
 * �ѿͻ�����������ģ�������������ͻ��ˣ�
 * ��װ
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket ser=new ServerSocket(10000);
		
		while(true) {
		Socket socs=ser.accept();//һ��accept��һ���ͻ��ˣ�
		//Receive sr=new Receive(socs);
		System.out.println("һ���ͻ���������......");
		//DataInputStream dis=new DataInputStream(socs.getInputStream());
		//System.out.println(dis.readUTF());
		
		
		DataInputStream dis=new DataInputStream(socs.getInputStream());//�������������ֽ���������-->�����������
		String code=dis.readUTF();//��ȡ�ֽ����飬��ת�ɳɻ������ݣ�
		System.out.println(code);//��ӡ������
		
		//String code="������";
		new Send(socs).send();
		}
	}

}
