package com.zfy.serverservlet2;

/**
 * 1、新建servlet类，将服务器和response代码分离；
 * 通过servlet解耦了业务代码；
 * @author DELL
 *
 */
public interface Servlet {
	void service(Request02 request,Respond respond);
	//可以根据具体的实际情况选择；
	//void doGet();
	//void doPost();

}
