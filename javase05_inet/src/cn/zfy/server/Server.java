package cn.zfy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	
	public static void main(String[] args) {
		Server server=new Server();
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
			//正文！！
			StringBuilder responseContext=new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应</title>"+
			                      "<head><body>Hellow,LT</body></html>");
			
			StringBuilder response=new StringBuilder();//
			//响应行；HTTP协议版本，状态代码，概述；
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//响应头，
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度，字节长度；
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//正文之前；
			response.append(CRLF);
			//正文补充进去；
			response.append(responseContext.toString());
			//输出给客户端的信息；一个字符输出流
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}
	//停止方法；
	public void stop() {
	
}
}
