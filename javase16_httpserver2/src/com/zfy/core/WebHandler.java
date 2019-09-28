package com.zfy.core;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 1����������࣬
 * @author DELL
 *
 */
public class WebHandler extends DefaultHandler{
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
