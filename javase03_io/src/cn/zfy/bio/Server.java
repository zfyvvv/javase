package cn.zfy.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO-serviceserver
 * @author DELL
 *
 */
public class Server {
	public static void main(String[] args) {
		int port=genPort(args);
		ServerSocket server=null;
		try {
			server=new ServerSocket(port);
			System.out.println("server start!");
			while(true) {
				Socket socket=server.accept();
				new Thread(new Handler(socket)).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	
	static class Handler implements Runnable{
		Socket socket=null;
		public Handler(Socket socket) {
			this.socket=socket;
		}
		@Override
		public void run() {
			BufferedReader reader=null;
			PrintWriter writer=null;
			try {
				reader=new BufferedReader(
						new InputStreamReader(socket.getInputStream(),"UTF-8"));
				writer=new PrintWriter(
						new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
				String readMessage=null;
				while(true) {
					System.out.println("server readding...");
					//读出客户端的数据；
					if((readMessage=reader.readLine())==null) {
						break;
					}
					System.out.println(readMessage);
					//向客户端发送数据；
					writer.println("server receive:"+readMessage);
					writer.flush();
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
	
	//启动的时候传不传请求参数；
	public static int genPort(String[] args) {
		if(args.length>0) {
			try {
				return Integer.parseInt(args[0]);
			} catch (Exception e) {
				return 9999;
			}
		}else {
			return 9999;
		}
	}
}
