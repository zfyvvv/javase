package cn.zfy.chatD;
/**
 * Socket�����ܿͻ��˷��͹�������Ϣ��ָ��IP�Ͷ˿ڣ�
 * getInputStream()��Socket�����һ�������������������ڽ�����Ϣ��
 * getOutputStream()��Socket�����һ������������������ڷ�����Ϣ��
 */
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",8888);
		/*String msg="zfy"+"\r\n";// �����ַ�-->����ֽ�          �ַ��������������                        �ַ������                                    ��� λ�ã��ֽ������
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));//
		bw.write(msg);//����ʹ�ö�̬����ΪҪ���Լ��ķ��������ַ��������ֽڲ��洢��bw�������λ���У�����
		//bw.newLine();//�������������msg����������"\r\n",��ΪBufferedReader��ʹ����readLine(),û���н���������һֱ��������
		bw.flush();
		//client.getOutputStream() ��������һ���ֽ����������������ֱ���ã������½��ֽ������������������������������������������
		System.out.println("һ���������Ѿ�������....");*/
		String msg="�ܷ���";
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());//��dos����������ݶ�ȡ���ֽ�������ȥ��
		dos.writeUTF(msg);//dos����ʼ��ȡ��Ϣ��msg-->dos-->bos(client.getOutputStream()) �ַ��������������������浽�ֽ���������ȥ��
		                  //client.getOutputStream() ��������һ���ֽ����������������ֱ���ã������½��ֽ������������������������
		dos.flush();
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		
	}

}
