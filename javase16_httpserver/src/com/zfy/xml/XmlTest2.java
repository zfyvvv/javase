package com.zfy.xml;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.event.IIOReadUpdateListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 1��SAX������Ϊ��������
 * 2���˽�����Ľ������̣�
 * 3������persons���Ϻ�person�ࣻ
 * @author DELL
 *
 */
public class XmlTest2 {
	public static void main(String[] args) throws Exception {
		//1����ȡ����������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2���ӽ���������ȡ��������
		SAXParser parse = factory.newSAXParser();
		//3����д���������½�һ����̳�DefaultHandler
		//4�������ĵ�Documentע������
		PersonHander hander=new PersonHander();
		//5������
		parse.parse(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("person.xml"),hander);
		//��ȡ���ݣ�
		List<Person> persons=hander.getPersons();
		for(Person p:persons) {
			System.out.println(p.getName()+"-->"+p.getAge());
		}
	}
}

class PersonHander extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	//�洢������ǩ��
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		//�ڽ����ĵ���ʼʱ��������
		persons=new ArrayList<Person>();
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			//System.out.println(qName+"-->������ʼ");
			//�洢��ǩ������������ʱ������
			tag=qName;
			if(tag!=null) {
				if(tag.equals("person")) {
					//������person��ǩʱ����ʼ����
					person=new Person();
				}
			}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contens=new String(ch,start,length).trim();
		if(tag!=null) {//����յ����⣻
			if(tag.equals("name")) {
				person.setName(contens);
			}else if(tag.equals("age")){
				//��ֹ��������Ϊnull�������
				//if(contens>0) { person.setAge(Integer.valueOf(contens));}
				person.setAge(Integer.valueOf(contens));
			}	
		}	
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println(qName+"-->��������");
		//������null����ʱ����Ϊtag,����ΪqName��
		if(null!=qName) {
			if(qName.equals("person")) {
				//������ɺ󣬼����м���person;
				persons.add(person);
			}
		}
		//tag��������
		tag=null;
	}
	
	@Override
	public void endDocument() throws SAXException {
	
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}


