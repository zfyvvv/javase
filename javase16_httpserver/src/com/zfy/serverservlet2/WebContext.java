package com.zfy.serverservlet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1����entity��mapping��ϵ������
 * @author DELL
 *
 */
public class WebContext {
	private List<Entity> entitys=null;
	private List<Mapping> mappings=null;
	
	//name-->servlet-class
	private Map<String, String> entityMap=new HashMap<String, String>();
	//url-pattern-->name
	private Map<String, String> mappingMap=new HashMap<String, String>();
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		
		//entity��listת���ɶ�Ӧ��map��
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		
		//mapping��listת���ɶ�Ӧ��map��
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}
	
	/**
	 * ͨ��URL��·���ҵ���Ӧ��class��
	 * @param pattern
	 * @return
	 */
	public String getClz(String pattern) {
		//pattern-->name;
		String name=mappingMap.get(pattern);
		//System.out.println(name);
		//name-->class
		return entityMap.get(name);
	}
}
