package cn.zfy.chatD3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socc=new Socket("localhost",10000);
		new Thread(new Send(socc)).start();//һ��·�����������ݣ�
		new Thread(new Recive(socc)).start();//��һ��·�����������ݣ�
	}

}
