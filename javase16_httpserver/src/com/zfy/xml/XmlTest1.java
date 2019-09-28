package com.zfy.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 1��SAX������Ϊ��������
 * 2���˽�����Ľ������̣�
 * @author DELL
 *
 */
public class XmlTest1 {
	public static void main(String[] args) throws Exception {
		//1����ȡ����������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2���ӽ���������ȡ��������
		SAXParser parse = factory.newSAXParser();
		//3����д���������½�һ����̳�DefaultHandler
		//4�������ĵ�Documentע������
		PHander hander=new PHander();
		//5������
		//�ӵ�ǰ������������ȡ��Դ��
		//parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/zfy/xml/person.xml"),hander);
		//�õ���ǰ��classpath�ľ���·����URI��ʾ����
		/*
		 // ��ǰ�̵߳��������
        System.out.println(Thread.currentThread().getContextClassLoader());
        // ��ǰ����������PersonsTest��ǰ�����
        System.out.println(PersonsTest.class.getClassLoader());
        // ϵͳ��ʼ���������
        System.out.println(ClassLoader.getSystemClassLoader());
                ���ԣ�
        //�ڴ����ж�̬����jar����Դ�ļ���ʱ������Ӧ����ʹ��
		Thread.currentThread().getContextClassLoader()
		���ܻᵼ�º͵�ǰ�߳������е����������һ�£���ΪJava�����Ķ��̣߳���
		ClassHelper.class.getClassLoader()��
		//һ������getResource����Ϊ����Ҫ��ȡĳ����Դ�ļ���ʱ�������Դ�ļ���λ������Թ̶��ġ�
		ClassHelper.class.getClassLoader()
		*/
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml"),hander);
	}
}

class PHander extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�����ĵ���ʼ��");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println(qName+"-->������ʼ");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
			String contens=new String(ch,start,length).trim();
			if(contens.length()>0) {
				System.out.println("��������Ϊ��"+contens);
			}else {
				System.out.println("��������Ϊ��"+"��");
			}
			
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->��������");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�������");
	}
	
}


