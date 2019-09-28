package cn.zfy.chatD1;
/**
 * 把客户端输出过来的，反过来输出给客户端；
 * 封装
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
		Socket socs=ser.accept();//一个accept，一个客户端；
		//Receive sr=new Receive(socs);
		System.out.println("一个客户端已连接......");
		//DataInputStream dis=new DataInputStream(socs.getInputStream());
		//System.out.println(dis.readUTF());
		
		
		DataInputStream dis=new DataInputStream(socs.getInputStream());//数据输入流；字节数组输入-->基本数据输出
		String code=dis.readUTF();//读取字节数组，并转成成基本数据，
		System.out.println(code);//打印出来；
		
		//String code="服务器";
		new Send(socs).send();
		}
	}

}
