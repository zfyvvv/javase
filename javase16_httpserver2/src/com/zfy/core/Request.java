package com.zfy.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
/**
 * 1、封装请求协议，实际是字符串的分隔；
 * 2、封装请求协议为map；
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
	//存储参数；
	private Map<String, List<String>> parameterMap;
	
	public Request(Socket client) throws IOException {
		//有异常只能抛出去，this只能在首行；
		//构造器的相互调用；
		this(client.getInputStream());
	}
	
	//构造器2；
	public Request(InputStream is) {
		parameterMap=new HashMap<String, List<String>>();
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
		//GET /abcd?uname=zhoufy&pwd=123456 HTTP/1.1
		//http://localhost:8888/aaa?uname=zhoufy2&pwd=123456&fav=0&fav=1&others=
		parseRequestInfo();
	}
	
	private void parseRequestInfo() {
		//GET /abcd?uname=zhoufy&pwd=123456 HTTP/1.1
		//http://localhost:8888/aaa?uname=zhoufy2&pwd=123456&fav=0&fav=1&others=
		//-->  method=get  url=aaa    queryInfo= 
		//GET 
		this.method=this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		
		
		int startidx=this.requestInfo.indexOf("/")+1;
		int endidx=this.requestInfo.indexOf("HTTP/");
		this.url=this.requestInfo.substring(startidx, endidx).trim();
		
		//abcd?uname=zhoufy&pwd=123456
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			queryInfo=urlArray[1];
		}
		if(method.equals("post")) {
			String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if(null==queryInfo) {
				queryInfo=qStr;
			}else {
				queryInfo+="&"+qStr;
			}
		}
		queryInfo=null==queryInfo?"":queryInfo;
		//get没问题，但是post有中文乱码问题；
		//queryInfo=decode(queryInfo, "gbk");
		//System.out.println(queryInfo);
		//System.out.println(method+"-->"+url+"-->"+queryInfo);
		//转成map；queryInfo为：fav=1&fav=2&uname=zfy&age=18&others=
		convertMap();
		
	}
	//处理请求参数为map；实际就是分隔字符串；
	private void convertMap() {
		//先按&分隔，取出fav=1；后按照=分隔，取出键和值；
		String[] keyValues=this.queryInfo.split("&");
		for(String queryStr:keyValues) {
			String[] kv=queryStr.split("=");
			//为了防止others= 这种情况；
			kv=Arrays.copyOf(kv, 2);
			//获取key和value；
			String key=kv[0];
			String value=kv[1]==null?null:decode(kv[1],"UTF-8");
			System.out.println(value);
			//存储到map中；
			if(!parameterMap.containsKey(key)) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	
	/**
	 * 处理中文乱码，
	 * @param value 传入的字符串；
	 * @param enc 字符集；
	 * @return
	 */
	public String decode(String value,String enc) {
		try {
			return java.net.URLDecoder.decode(value, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过name获取表单里面的多个值；
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key) {
		List<String> values=this.parameterMap.get(key);
		if(null==values||values.size()<1) {
			return null;
		}
		//servlet和web学习中都是返回数组；
		return values.toArray(new String[0]);
	}
	
	/**
	 * 通过name获取表单里面的一个值；
	 * @param key
	 * @return
	 */
	public String getParameter(String key) {
		//先获取数组，后取数组的第一个位置的元素；
		String[] values=getParameterValues(key);
		return values==null?null:values[0];
	}

	//提供对外的set方法；
	public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public String getQueryInfo() {
		return queryInfo;
	}
	

}
