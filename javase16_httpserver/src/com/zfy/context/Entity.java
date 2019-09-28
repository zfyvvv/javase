package com.zfy.context;
/**
 *1¡¢name-->com.zfy.xml.LoginServlet
 * 
 * <servlet>
    <servlet-name>login</servlet-name>
    <servlet-class>com.zfy.xml.LoginServlet</servlet-class>
  </servlet>

 * @author DELL
 *
 */
public class Entity {
	private String name;
	private String clz;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}

}
