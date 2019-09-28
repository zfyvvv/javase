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
		System.out.println("登录名:"+uname+"-->"+"登录密码："+pwd);
		
		respond.print("<html><head><title>HTTP</title><head><body>"
				+"-->this is the servlet of login!<--<br/>"
				+"登录名:"+uname+"-->"+"登录密码："+pwd+"<br/>"
				+uname+"您已经成功登录！"+"<br/>"
				+"</body></html>");
				
		
	}




}
