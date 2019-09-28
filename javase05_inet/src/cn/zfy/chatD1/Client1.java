package cn.zfy.chatD1;
/**
 * System.in:新增键盘输入功能，升级版，
 * 	/*Scanner sca=new Scanner(System.in);
		String msgs=sca.next();
 * 封装
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socc=new Socket("localhost",10000);
		
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msgs=br.readLine();*/
		/*String msg="周方杨";
		DataOutputStream dos=new DataOutputStream(socc.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();*/
		
		new Send(socc).send();
		Receive r=new Receive(socc);
	}

}
