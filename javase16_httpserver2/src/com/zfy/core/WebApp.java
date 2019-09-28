package com.zfy.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * 1、里面放置解析xml文件的代码块
 * @author DELL
 *
 */
public class WebApp {
	private static WebContext context;
	//静态代码块里面的异常只能trycatch，不能throws;
	static {
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parse = factory.newSAXParser();
			WebHandler hander=new WebHandler();
			//5、解析
			//web.xml 在包内-->com/zfy/servlet/web.xml
			//web.xml 在src内；-->web.xml
			parse.parse(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("web.xml"),hander);
			//获取数据；
			context=new WebContext(hander.getEntitys(), hander.getMappings());
			
			
		} catch (Exception e) {
			System.out.println("解析配置文件错误！");
		}
	}
	
	/**
	 * 1、通过url获取配置文件对应的servlet；
	 * @param url
	 * @return
	 */
	public static Servlet getServletFromUrl(String url) {
		//假设你输入了/login;-->L;
		//String className=context.getClz("/login");
		//假设你输入了/regin;-->R;
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
