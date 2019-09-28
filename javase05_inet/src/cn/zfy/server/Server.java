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
	//����������
	public void start() {
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	//���ܿͻ��ˣ�
	private void receive() {
		try {
			Socket client=server.accept();
			/*String msg=null;?
			//StringBuilder sb=new StringBuilder();
			//BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));*/
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data);
			String requestinfo=new String(data,0,len).trim();//��ӡ�ͻ����������Ϣ��
			System.out.println(requestinfo);
			
			//�����Ϣ���ͻ��ˣ���Ӧ�ͻ��ˣ�
			//���ģ���
			StringBuilder responseContext=new StringBuilder();
			responseContext.append("<html><head><title>HTTP��Ӧ</title>"+
			                      "<head><body>Hellow,LT</body></html>");
			
			StringBuilder response=new StringBuilder();//
			//��Ӧ�У�HTTPЭ��汾��״̬���룬������
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//��Ӧͷ��
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��ȣ��ֽڳ��ȣ�
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//����֮ǰ��
			response.append(CRLF);
			//���Ĳ����ȥ��
			response.append(responseContext.toString());
			//������ͻ��˵���Ϣ��һ���ַ������
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}
	//ֹͣ������
	public void stop() {
	
}
}
