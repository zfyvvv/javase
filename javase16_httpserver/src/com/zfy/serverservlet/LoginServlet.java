package com.zfy.serverservlet;

public class LoginServlet implements Servlet{
	@Override
	public void service(Request02 request, Respond respond) {
		// TODO Auto-generated method stub
		respond.print("<html><head><title>HTTP</title><head><body>"
				+"-->this is the servlet of login!<--"
				+request.getParameter("uname")
				+"</body></html>");
	}

}
