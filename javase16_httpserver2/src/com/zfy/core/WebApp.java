package com.zfy.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * 1��������ý���xml�ļ��Ĵ����
 * @author DELL
 *
 */
public class WebApp {
	private static WebContext context;
	//��̬�����������쳣ֻ��trycatch������throws;
	static {
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parse = factory.newSAXParser();
			WebHandler hander=new WebHandler();
			//5������
			//web.xml �ڰ���-->com/zfy/servlet/web.xml
			//web.xml ��src�ڣ�-->web.xml
			parse.parse(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("web.xml"),hander);
			//��ȡ���ݣ�
			context=new WebContext(hander.getEntitys(), hander.getMappings());
			
			
		} catch (Exception e) {
			System.out.println("���������ļ�����");
		}
	}
	
	/**
	 * 1��ͨ��url��ȡ�����ļ���Ӧ��servlet��
	 * @param url
	 * @return
	 */
	public static Servlet getServletFromUrl(String url) {
		//������������/login;-->L;
		//String className=context.getClz("/login");
		//������������/regin;-->R;
		String className=context.getClz("/"+url);
		Class clz;
		try {
			clz = Class.forName(className);
			Servlet servlet=(Servlet) clz.newInstance();
			return servlet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}
	
}
