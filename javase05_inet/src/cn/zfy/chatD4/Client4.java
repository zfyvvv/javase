package cn.zfy.chatD4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socc=new Socket("localhost",10000);//������ϵ��ָ���������˿ڣ��Լ��˿ڲ���ָ����
		String name=Client4.inputNmae();//�����Լ������֣�
		new Thread(new Send(socc,name)).start();//һ��·�����������ݣ�
		new Thread(new Recive(socc)).start();//��һ��·�����������ݣ�
	}
	public static String inputNmae() throws IOException {//�����Լ������֣�
		System.out.println("���������������");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if(name.equals("")) {
			System.out.println("��������ȷ�����֣�����");
		}
		return name;
	}

}
