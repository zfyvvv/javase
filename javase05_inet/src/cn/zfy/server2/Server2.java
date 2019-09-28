package cn.zfy.server2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server2 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server2 server=new Server2();
		server.start();
		
	}
	//启动方法；
	public void start() {
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	//接受客户端；
	private void receive() {
		try {
			Socket client=server.accept();
			/*String msg=null;?
			//StringBuilder sb=new StringBuilder();
			//BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));*/
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data);
			String requestinfo=new String(data,0,len).trim();//打印客户端请求的信息；
			System.out.println(requestinfo);
			
			//输出信息给客户端，响应客户端；
			
			Respond2 rep=new Respond2(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应</title>");
			rep.println("<head><body>Hellow,LTTTTTT</body></html>");
			rep.pushToClient(200);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}
	
}
