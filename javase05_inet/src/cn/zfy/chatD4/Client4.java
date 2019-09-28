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
		Socket socc=new Socket("localhost",10000);//建立联系，指定服务器端口，自己端口不可指定；
		String name=Client4.inputNmae();//输入自己的名字；
		new Thread(new Send(socc,name)).start();//一条路径，发送数据；
		new Thread(new Recive(socc)).start();//另一条路径，接受数据；
	}
	public static String inputNmae() throws IOException {//输入自己的名字，
		System.out.println("请输入你的姓名：");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if(name.equals("")) {
			System.out.println("请输入正确的名字！！！");
		}
		return name;
	}

}
