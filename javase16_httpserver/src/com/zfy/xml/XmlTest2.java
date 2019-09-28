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
 * 1、SAX解析，为流解析；
 * 2、了解初步的解析过程；
 * 3、加入persons集合和person类；
 * @author DELL
 *
 */
public class XmlTest2 {
	public static void main(String[] args) throws Exception {
		//1、获取解析工厂；
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器；
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器；新建一个类继承DefaultHandler
		//4、加载文档Document注册器；
		PersonHander hander=new PersonHander();
		//5、解析
		parse.parse(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("person.xml"),hander);
		//获取数据；
		List<Person> persons=hander.getPersons();
		for(Person p:persons) {
			System.out.println(p.getName()+"-->"+p.getAge());
		}
	}
}

class PersonHander extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	//存储操作标签；
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		//在解析文档开始时创建集合
		persons=new ArrayList<Person>();
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			//System.out.println(qName+"-->解析开始");
			//存储标签，方便后存属性时操作；
			tag=qName;
			if(tag!=null) {
				if(tag.equals("person")) {
					//当出现person标签时，初始化；
					person=new Person();
				}
			}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contens=new String(ch,start,length).trim();
		if(tag!=null) {//处理空的问题；
			if(tag.equals("name")) {
				person.setName(contens);
			}else if(tag.equals("age")){
				//防止出现内容为null的情况；
				//if(contens>0) { person.setAge(Integer.valueOf(contens));}
				person.setAge(Integer.valueOf(contens));
			}	
		}	
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println(qName+"-->解析结束");
		//处理了null；此时不能为tag,必须为qName；
		if(null!=qName) {
			if(qName.equals("person")) {
				//解析完成后，集合中加入person;
				persons.add(person);
			}
		}
		//tag丢弃掉；
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


