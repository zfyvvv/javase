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
 * 1������web.xml�ļ���
 * 2��entitys,entity
 * 		entity:name-->servlet-class
 * 	       login       com.zfy.xml.LoginServlet			
 * 2��mappings,mapping;
 * 		mapping:name-->url-pattern
 * 			  login     /login
 * @author DELL
 *
 */
public class XmlTest {
	public static void main(String[] args) throws Exception {
		//1����ȡ����������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2���ӽ���������ȡ��������
		SAXParser parse = factory.newSAXParser();
		//3����д���������½�һ����̳�DefaultHandler
		//4�������ĵ�Documentע������
		WebHander hander=new WebHander();
		//5������
		//web.xml �ڰ���-->com/zfy/servlet/web.xml
		//web.xml ��src�ڣ�-->web.xml
		parse.parse(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("com/zfy/servlet/web.xml"),hander);
		//��ȡ���ݣ�
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
	
	//�洢������ǩ��
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		//�ڽ����ĵ���ʼʱ��������
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			//System.out.println(qName+"-->������ʼ");
			//�洢��ǩ������������ʱ������
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
		if(tag!=null) {//����յ����⣻
			if(isMapping) {//����servlet-mapping
				if(tag.equals("servlet-name")) {
					mapping.setName(contens);
				}else if(tag.equals("url-pattern")){
					mapping.addPattern(contens);
				}
			}else {//����servlet
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
		//System.out.println(qName+"-->��������");
		//������null����ʱ����Ϊtag,����ΪqName��
		if(null!=qName) {
			if(qName.equals("servlet")) {
				entitys.add(entity);
			}else if(qName.equals("servlet-mapping")) {
				mappings.add(mapping);
				
			}
		}
		//tag��������
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


