package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 *��������
 *1����д�����ȡ��
 *2��д��˳��Ͷ�ȡ˳��һ�£�  
 *3�����Բ鿴һ���ļ����ֽڴ�С���ַ����Ĵ�С��
 *   
 * @author DELL
 *
 */
public class IOTest08 {

	public static void main(String[] args) throws IOException {
		test1();
	}
	
	// ������
	public static void test1() throws IOException {
		//д��
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		//������������+���ݣ�
		//����ͨ��DataOutputStreamд���ֽ�����baos�У�
		//����+����->dos->baos->datas->dis->��ӡ������
		dos.writeUTF("�ܷ���");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChars("c");
		dos.flush();
		byte[] datas=baos.toByteArray();
		//��ȡ��
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
		//��ȡ��д��˳��һ�£�
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
	}
	
	//������+��������һ����һ�㣻
	public static void test2() throws IOException {
		//д��
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		//������������+���ݣ�
		//����ͨ��DataOutputStreamд���ֽ�����baos�У�
		//����+����->dos->baos->datas->dis->��ӡ������
		dos.writeUTF("�ܷ���");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChars("c");
		dos.flush();
		byte[] datas=baos.toByteArray();
		//��ȡ��
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(datas)));
		//��ȡ��д��˳��һ�£�
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
	}
}

