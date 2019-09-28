package com.zfy.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 * 1、封装请求协议；
 * 2、实际是字符串的分隔；
 * @author DELL
 *
 */
public class Request {
	//请求协议；
	private String requestInfo;
	//请求方式；
	private String method;
	//请求URL；
	private String url;
	//请求信息；
	private String queryInfo;
	//换行符；
	private static final String CRLF="\r\n";
	
	public Request(Socket client) throws IOException {
		//有异常只能抛出去，this只能在首行；
		//构造器的相互调用；
		this(client.getInputStream());
	}
	
	//构造器2；
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
		//分解字符串；
		parseRequestInfo();
	}
	
	private void parseRequestInfo() {
		//获取请求方式：开头到第一个/的位置；
		this.method=this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		//获取url：第一个/到http/；
		int startidx=this.requestInfo.indexOf("/")+1;
		int endidx=this.requestInfo.indexOf("HTTP/");
		this.url=this.requestInfo.substring(startidx, endidx).trim();
		
		//请求参数可能包含？比如；abcd?uname=zhoufy&pwd=123456 前半部分为URL，后半部分为请求参数；
		//GET /abcd?uname=zhoufy&pwd=123456 HTTP/1.1
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			queryInfo=urlArray[1];
		}
		//System.out.println(this.url);
		//当为POST方式时，请求参数在后面；
		if(method.equals("post")) {
			//取最后一个空行后的信息；
			String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if(null==queryInfo) {
				queryInfo=qStr;
			}else {
				queryInfo+="&"+qStr;
			}
		}
		//防止空指针异常；
		queryInfo=null==queryInfo?"":queryInfo;
		System.out.println(method+"-->"+url+"-->"+queryInfo);
	}

}
