package cn.zfy.chatD3;
/**
 * Thread():多线程，接受信息和发送信息顺序随意；
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
	public static void main(String[] args) throws IOException {
		ServerSocket ser=new ServerSocket(10000);
		while(true) {//多个客户端
		//接受数据
		Socket socs=ser.accept();//一个accept，一个客户端；
		
		DataInputStream dis=new DataInputStream(socs.getInputStream());
		DataOutputStream dos=new DataOutputStream(socs.getOutputStream());
		System.out.println("一个客户端已经建立连接.....");
		//发送数据
		while(true) {//多次接受数据；读入和写出
		String msgs=dis.readUTF();
		System.out.println(msgs);
		dos.writeUTF("服务器-->"+msgs);
		dos.flush();}
		}
		//new Thread(new Recive(ser.accept())).start();//另一条路径，接受数据；
		//new Thread(new Send(ser.accept())).start();//一条路径，发送数据；
		
		
		
		
		
	}

}
