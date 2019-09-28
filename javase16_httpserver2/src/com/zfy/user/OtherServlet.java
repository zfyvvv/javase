package com.zfy.user;

import com.zfy.core.Request;
import com.zfy.core.Respond;
import com.zfy.core.Servlet;

public class OtherServlet implements Servlet{

	@Override
	public void service(Request request, Respond respond) {
		// TODO Auto-generated method stub
		
		respond.print("<html><head><title>HTTP</title><head><body>"
				+"-->this is the servlet of other!!<--"
				+request.getParameter("uname")
				+"</body></html>");
	}
}
