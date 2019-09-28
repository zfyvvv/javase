package cn.zfy.bio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 * BIO-clent
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		String host=null;
		int port=0;
		if(args.length>2) {
			host=args[0];
			port=Integer.parseInt(args[1]);
		}else {
			host="127.0.0.1";
			port=9999;
		}
		
		Socket socket=null;
		BufferedReader reader=null;
		PrintWriter writer=null;
		Scanner s=new Scanner(System.in);
		try {
			socket=new Socket(host, port);
			String message=null;
			reader=new BufferedReader(
					new InputStreamReader(socket.getInputStream(),"UTF-8"));
			writer=new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				message=s.nextLine();
				if("exit".equals(message)) {
					break;
				}
				//把数据发送到服务器；
				writer.println(message);
				writer.flush();
				//把接收回来的数据读出来；
				System.out.println(reader.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(socket!=null) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			socket=null;
			if(reader!=null) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			reader=null;
			if(writer!=null) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			writer=null;
		}
	}
}
