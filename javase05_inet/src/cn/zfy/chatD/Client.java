package cn.zfy.chatD;
/**
 * Socket：接受客户端发送过来的消息；指定IP和端口；
 * getInputStream()：Socket对象的一个方法，输入流，用于接受信息；
 * getOutputStream()：Socket对象的一个方法，输出流，用于发送信息；
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
		/*String msg="zfy"+"\r\n";// 输入字符-->输出字节          字符缓冲流输出流；                        字符输出流                                    输出 位置：字节输出流
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));//
		bw.write(msg);//不能使用多态，因为要用自己的方法，把字符串读成字节并存储在bw的输出流位置中！！！
		//bw.newLine();//不加这个，但是msg后面必须加上"\r\n",因为BufferedReader中使用了readLine(),没有行结束符，会一直读不到；
		bw.flush();
		//client.getOutputStream() 本来就是一个字节数组输出流，可以直接用，不用新建字节数组输出流！！！！！！！！！！！！！！！！
		System.out.println("一个服务器已经连接中....");*/
		String msg="周方杨";
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());//把dos流里面的内容读取到字节数组中去，
		dos.writeUTF(msg);//dos流开始读取信息；msg-->dos-->bos(client.getOutputStream()) 字符串到数据流，数据流存到字节数组流中去！
		                  //client.getOutputStream() 本来就是一个字节数组输出流，可以直接用，不用新建字节数组输出流！！！！！！！
		dos.flush();
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		
	}

}
