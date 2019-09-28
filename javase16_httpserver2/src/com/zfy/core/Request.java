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
 * 1����װ����Э�飬ʵ�����ַ����ķָ���
 * 2����װ����Э��Ϊmap��
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
	//�洢������
	private Map<String, List<String>> parameterMap;
	
	public Request(Socket client) throws IOException {
		//���쳣ֻ���׳�ȥ��thisֻ�������У�
		//���������໥���ã�
		this(client.getInputStream());
	}
	
	//������2��
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
		//�ֽ��ַ�����
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
		//getû���⣬����post�������������⣻
		//queryInfo=decode(queryInfo, "gbk");
		//System.out.println(queryInfo);
		//System.out.println(method+"-->"+url+"-->"+queryInfo);
		//ת��map��queryInfoΪ��fav=1&fav=2&uname=zfy&age=18&others=
		convertMap();
		
	}
	//�����������Ϊmap��ʵ�ʾ��Ƿָ��ַ�����
	private void convertMap() {
		//�Ȱ�&�ָ���ȡ��fav=1������=�ָ���ȡ������ֵ��
		String[] keyValues=this.queryInfo.split("&");
		for(String queryStr:keyValues) {
			String[] kv=queryStr.split("=");
			//Ϊ�˷�ֹothers= ���������
			kv=Arrays.copyOf(kv, 2);
			//��ȡkey��value��
			String key=kv[0];
			String value=kv[1]==null?null:decode(kv[1],"UTF-8");
			System.out.println(value);
			//�洢��map�У�
			if(!parameterMap.containsKey(key)) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	
	/**
	 * �����������룬
	 * @param value ������ַ�����
	 * @param enc �ַ�����
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
	 * ͨ��name��ȡ������Ķ��ֵ��
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key) {
		List<String> values=this.parameterMap.get(key);
		if(null==values||values.size()<1) {
			return null;
		}
		//servlet��webѧϰ�ж��Ƿ������飻
		return values.toArray(new String[0]);
	}
	
	/**
	 * ͨ��name��ȡ�������һ��ֵ��
	 * @param key
	 * @return
	 */
	public String getParameter(String key) {
		//�Ȼ�ȡ���飬��ȡ����ĵ�һ��λ�õ�Ԫ�أ�
		String[] values=getParameterValues(key);
		return values==null?null:values[0];
	}

	//�ṩ�����set������
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
