package com.zfy.serverservlet2;

/**
 * 1���½�servlet�࣬����������response������룻
 * ͨ��servlet������ҵ����룻
 * @author DELL
 *
 */
public interface Servlet {
	void service(Request02 request,Respond respond);
	//���Ը��ݾ����ʵ�����ѡ��
	//void doGet();
	//void doPost();

}
