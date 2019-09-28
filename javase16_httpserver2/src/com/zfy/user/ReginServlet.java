package com.zfy.user;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.zfy.core.Request;
import com.zfy.core.Respond;
import com.zfy.core.Servlet;

public class ReginServlet implements Servlet{

	@Override
	public void service(Request request, Respond respond) {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		System.out.println("登录名:"+uname);
		respond.println("你喜欢的类型为：");
		
		String[] fav=request.getParameterValues("fav");
		System.out.println(Arrays.toString(fav));
		for(String s:fav) {
			if(s.equals("0")) {
				respond.println("温柔型");
			}
			if(s.equals("1")) {
				respond.println("强势型");
			}
			if(s.equals("2")) {
				respond.println("智慧型");
			}
		}

	}
}
