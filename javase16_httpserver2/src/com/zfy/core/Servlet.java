package com.zfy.core;

/**
 * 1���½�servlet�࣬����������response������룻
 * ͨ��servlet������ҵ����룻
 * @author DELL
 *
 */
public interface Servlet {
	void service(Request request,Respond respond);
	//���Ը��ݾ����ʵ�����ѡ��
	//void doGet();
	//void doPost();

}
