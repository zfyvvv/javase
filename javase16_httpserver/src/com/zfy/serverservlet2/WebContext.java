package com.zfy.serverservlet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1、将entity和mapping联系起来；
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
		
		//entity的list转换成对应的map；
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		
		//mapping的list转换成对应的map；
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}
	
	/**
	 * 通过URL的路径找到对应的class；
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
