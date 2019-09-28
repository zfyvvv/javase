package com.zfy.serverservlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Respond {
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	//头信息；
	private StringBuilder headInfo;
	//正文；
	private StringBuilder content;
	private BufferedWriter bw;
	private int len=0;
	
	
	//私有化，不传参数则不可用；
	private Respond() {
		headInfo=new StringBuilder();
		content=new StringBuilder();
		len=0;
	}
	public Respond(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	public Respond(Socket soc) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
		} catch (IOException e) {
			//e.printStackTrace();
			headInfo=null;
		}
	}
	
	private void creatHeadInfo(int code) {
	//HTTP协议版本，状态代码，概述；
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
	//响应头，
	headInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
	headInfo.append("Date:").append(new Date()).append(CRLF);
	headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
	//正文长度，字节长度；
	headInfo.append("Content-Length:").append(len).append(CRLF);
	//正文之前；
	headInfo.append(CRLF);
	}
	
	
	//对外只提供三个方法；
	//动态添加内容；采用流模式，不断的返回自身；
	public Respond print(String info) {
			content.append(info);
			//计算长度；
			len+=info.getBytes().length;
			return this;
		}
	//动态添加内容是，可以添加换行符；
	public Respond println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}
	void pushToClient(int code) throws IOException {
		if(headInfo==null) {
			code=500;
		}
		creatHeadInfo(code);
		//头信息+分隔符
		bw.append(headInfo.toString());//追加读取并写出；比write多一个功能；
		//正文
		bw.append(content.toString());//原有内容的基础上写出，而write()则是把数据流全部写出;
		bw.flush();
	}
	//停止方法；
	public void stop() {
		CloseUtil.closeIO(bw);
		
	}
	

}
