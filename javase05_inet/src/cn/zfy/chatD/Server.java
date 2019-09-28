package cn.zfy.chatD;
/**
 * ServerSocket:建立服务端；指定端口（本机就是服务器IP）；
 * Socket：接受客户端发送过来的消息；
 * getInputStream()：Socket对象的一个方法，输入流，用于接受信息；
 * getOutputStream()：Socket对象的一个方法，输出流，用于发送信息；
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
		System.out.println("一个客户端已经建立中...");
		//   字符缓冲输入流：输入字节-->输出字符      字符缓冲输入流     字符输入流       源数据： 字节输入流
		/*BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//使用字符缓冲流中的特定方法，将字节输入流读成字符并打印出来！！！！！！！
		System.out.println(br.readLine());
		br.close();*/
		//数据输入流；字节数组输入-->基本数据输出
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		String code=dis.readUTF();//读取字节数组，并转成成基本数据，
		System.out.println(code);//打印出来；
		
		String remsg="欢迎使用本服务器！！！";
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());//数据输出流：基本数据输入-->字节数组输出
		dos.writeUTF(remsg);//读取需要输出的基本数据类型，保存位置为dos的存储位置；
		dos.flush();//
		
		
	}

}
