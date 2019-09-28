package cn.zfy.server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Respond2 {
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	//ͷ��Ϣ��
	private StringBuilder headInfo;
	//���ģ�
	private StringBuilder content;
	private BufferedWriter bw;
	private int len=0;
	
	
	
	public Respond2() {
		headInfo=new StringBuilder();
		content=new StringBuilder();
		len=0;
	}
	public Respond2(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	public Respond2(Socket soc) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
		} catch (IOException e) {
			//e.printStackTrace();
			headInfo=null;
		}
	}
	
	private void creatHeadInfo(int code) {
	//HTTPЭ��汾��״̬���룬������
	headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
	switch(code) {
		case 200:  
			headInfo.append("OK");
			break;
		case 404:  
			headInfo.append("NOT FOUND");
			break;
		case 500:  
			headInfo.append("SERVER ERROR");
			break;
		}
	headInfo.append(CRLF);
	//��Ӧͷ��
	headInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
	headInfo.append("Date:").append(new Date()).append(CRLF);
	headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
	//���ĳ��ȣ��ֽڳ��ȣ�
	headInfo.append("Content-Length:").append(len).append(CRLF);
	//����֮ǰ��
	headInfo.append(CRLF);
	}
	//��̬������ݣ�������ģʽ�����ϵķ�������
	public Respond2 print(String info) {
			content.append(info);
			//���㳤�ȣ�
			len+=info.getBytes().length;
			return this;
		}
	//��̬��������ǣ�������ӻ��з���
	public Respond2 println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}
	void pushToClient(int code) throws IOException {
		if(headInfo==null) {
			code=500;
		}
		creatHeadInfo(code);
		//ͷ��Ϣ+�ָ���
		bw.append(headInfo.toString());//׷�Ӷ�ȡ��д������write��һ�����ܣ�
		//����
		bw.append(content.toString());//ԭ�����ݵĻ�����д������write()���ǰ�������ȫ��д��;
		bw.flush();
	}
	//ֹͣ������
	public void stop() {
			CloseUtil.closeIO(bw);
		
	}
	

}
