package com.zfy.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 * 1����װ����Э�飻
 * 2��ʵ�����ַ����ķָ���
 * @author DELL
 *
 */
public class Request {
	//����Э�飻
	private String requestInfo;
	//����ʽ��
	private String method;
	//����URL��
	private String url;
	//������Ϣ��
	private String queryInfo;
	//���з���
	private static final String CRLF="\r\n";
	
	public Request(Socket client) throws IOException {
		//���쳣ֻ���׳�ȥ��thisֻ�������У�
		//���������໥���ã�
		this(client.getInputStream());
	}
	
	//������2��
	public Request(InputStream is) {
		byte[] datas=new byte[1024*1024];
		try {
			int len = is.read(datas);
			this.requestInfo=new String(datas,0,len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		//�ֽ��ַ�����
		parseRequestInfo();
	}
	
	private void parseRequestInfo() {
		//��ȡ����ʽ����ͷ����һ��/��λ�ã�
		this.method=this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		//��ȡurl����һ��/��http/��
		int startidx=this.requestInfo.indexOf("/")+1;
		int endidx=this.requestInfo.indexOf("HTTP/");
		this.url=this.requestInfo.substring(startidx, endidx).trim();
		
		//����������ܰ��������磻abcd?uname=zhoufy&pwd=123456 ǰ�벿��ΪURL����벿��Ϊ���������
		//GET /abcd?uname=zhoufy&pwd=123456 HTTP/1.1
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			queryInfo=urlArray[1];
		}
		//System.out.println(this.url);
		//��ΪPOST��ʽʱ����������ں��棻
		if(method.equals("post")) {
			//ȡ���һ�����к����Ϣ��
			String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if(null==queryInfo) {
				queryInfo=qStr;
			}else {
				queryInfo+="&"+qStr;
			}
		}
		//��ֹ��ָ���쳣��
		queryInfo=null==queryInfo?"":queryInfo;
		System.out.println(method+"-->"+url+"-->"+queryInfo);
	}

}
