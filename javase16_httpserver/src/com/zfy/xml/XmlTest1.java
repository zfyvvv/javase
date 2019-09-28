package com.zfy.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 1、SAX解析，为流解析；
 * 2、了解初步的解析过程；
 * @author DELL
 *
 */
public class XmlTest1 {
	public static void main(String[] args) throws Exception {
		//1、获取解析工厂；
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器；
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器；新建一个类继承DefaultHandler
		//4、加载文档Document注册器；
		PHander hander=new PHander();
		//5、解析
		//从当前类加载器里面获取资源；
		//parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/zfy/xml/person.xml"),hander);
		//得到当前的classpath的绝对路径的URI表示法。
		/*
		 // 当前线程的类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 当前类的类加载器PersonsTest当前类对象
        System.out.println(PersonsTest.class.getClassLoader());
        // 系统初始的类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
                所以，
        //在代码中动态加载jar、资源文件的时候，首先应该是使用
		Thread.currentThread().getContextClassLoader()
		可能会导致和当前线程所运行的类加载器不一致（因为Java天生的多线程）。
		ClassHelper.class.getClassLoader()，
		//一般用在getResource，因为你想要获取某个资源文件的时候，这个资源文件的位置是相对固定的。
		ClassHelper.class.getClassLoader()
		*/
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml"),hander);
	}
}

class PHander extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("解析文档开始！");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println(qName+"-->解析开始");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
			String contens=new String(ch,start,length).trim();
			if(contens.length()>0) {
				System.out.println("解析内容为："+contens);
			}else {
				System.out.println("解析内容为："+"空");
			}
			
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->解析结束");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束！");
	}
	
}


