package com.zfy.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.event.IIOReadUpdateListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.zfy.xml.Person;
/**
 * 1、解析web.xml文件；
 * 2、entitys,entity
 * 		entity:name-->servlet-class
 * 	       login       com.zfy.xml.LoginServlet			
 * 2、mappings,mapping;
 * 		mapping:name-->url-pattern
 * 			  login     /login
 * @author DELL
 *
 */
public class XmlTest {
	public static void main(String[] args) throws Exception {
		//1、获取解析工厂；
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器；
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器；新建一个类继承DefaultHandler
		//4、加载文档Document注册器；
		WebHander hander=new WebHander();
		//5、解析
		//web.xml 在包内-->com/zfy/servlet/web.xml
		//web.xml 在src内；-->web.xml
		parse.parse(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("com/zfy/servlet/web.xml"),hander);
		//获取数据；
		List<Entity> entitys=hander.getEntitys();
		for(Entity e:entitys) {
			System.out.println(e.getName()+"-->"+e.getClz());
		}
		System.out.println(entitys.size());
		List<Mapping> mappings=hander.getMappings();
		for(Mapping m:mappings) {
			System.out.println(m.getName()+"-->"+m.getPatterns());
		}
		System.out.println(entitys.size());
	}
}

class WebHander extends DefaultHandler{
	private List<Entity> entitys=new ArrayList<Entity>();
	private List<Mapping> mappings=new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private boolean isMapping=false;
	
	//存储操作标签；
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		//在解析文档开始时创建集合
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			//System.out.println(qName+"-->解析开始");
			//存储标签，方便后存属性时操作；
			tag=qName;
			if(tag!=null) {
				if(tag.equals("servlet")) {
					entity=new Entity();
					isMapping=false;
				}else if(tag.equals("servlet-mapping")) {
					mapping=new Mapping();
					isMapping=true;
				}
			}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contens=new String(ch,start,length).trim();
		if(tag!=null) {//处理空的问题；
			if(isMapping) {//操作servlet-mapping
				if(tag.equals("servlet-name")) {
					mapping.setName(contens);
				}else if(tag.equals("url-pattern")){
					mapping.addPattern(contens);
				}
			}else {//操作servlet
				if(tag.equals("servlet-name")) {
					entity.setName(contens);
				}else if(tag.equals("servlet-class")){
					entity.setClz(contens);
				}
			}
		}	
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println(qName+"-->解析结束");
		//处理了null；此时不能为tag,必须为qName；
		if(null!=qName) {
			if(qName.equals("servlet")) {
				entitys.add(entity);
			}else if(qName.equals("servlet-mapping")) {
				mappings.add(mapping);
				
			}
		}
		//tag丢弃掉；
		tag=null;
	}
	
	@Override
	public void endDocument() throws SAXException {
	
	}

	public List<Entity> getEntitys() {
		return entitys;
	}

	public void setEntitys(List<Entity> entitys) {
		this.entitys = entitys;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	
	
	
}


