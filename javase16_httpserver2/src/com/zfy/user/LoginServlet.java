package com.zfy.user;

import com.zfy.core.Request;
import com.zfy.core.Respond;
import com.zfy.core.Servlet;

public class LoginServlet implements Servlet{

	@Override
	public void service(Request request, Respond respond) {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println("��¼��:"+uname+"-->"+"��¼���룺"+pwd);
		
		respond.print("<html><head><title>HTTP</title><head><body>"
				+"-->this is the servlet of login!<--<br/>"
				+"��¼��:"+uname+"-->"+"��¼���룺"+pwd+"<br/>"
				+uname+"���Ѿ��ɹ���¼��"+"<br/>"
				+"</body></html>");
				
		
	}




}
