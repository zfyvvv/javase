package cn.zfy.chatD1;
/**
 * System.in:�����������빦�ܣ������棬
 * 	/*Scanner sca=new Scanner(System.in);
		String msgs=sca.next();
 * ��װ
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
		/*String msg="�ܷ���";
		DataOutputStream dos=new DataOutputStream(socc.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();*/
		
		new Send(socc).send();
		Receive r=new Receive(socc);
	}

}
