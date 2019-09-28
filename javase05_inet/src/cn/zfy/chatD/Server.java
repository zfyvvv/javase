package cn.zfy.chatD;
/**
 * ServerSocket:��������ˣ�ָ���˿ڣ��������Ƿ�����IP����
 * Socket�����ܿͻ��˷��͹�������Ϣ��
 * getInputStream()��Socket�����һ�������������������ڽ�����Ϣ��
 * getOutputStream()��Socket�����һ������������������ڷ�����Ϣ��
 * 
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket sersoc=new ServerSocket(8888);
		Socket socket=sersoc.accept();
		System.out.println("һ���ͻ����Ѿ�������...");
		//   �ַ������������������ֽ�-->����ַ�      �ַ�����������     �ַ�������       Դ���ݣ� �ֽ�������
		/*BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//ʹ���ַ��������е��ض����������ֽ������������ַ�����ӡ������������������
		System.out.println(br.readLine());
		br.close();*/
		//�������������ֽ���������-->�����������
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		String code=dis.readUTF();//��ȡ�ֽ����飬��ת�ɳɻ������ݣ�
		System.out.println(code);//��ӡ������
		
		String remsg="��ӭʹ�ñ�������������";
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());//�����������������������-->�ֽ��������
		dos.writeUTF(remsg);//��ȡ��Ҫ����Ļ����������ͣ�����λ��Ϊdos�Ĵ洢λ�ã�
		dos.flush();//
		
		
	}

}
