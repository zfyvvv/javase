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
		System.out.println("��¼��:"+uname);
		respond.println("��ϲ��������Ϊ��");
		
		String[] fav=request.getParameterValues("fav");
		System.out.println(Arrays.toString(fav));
		for(String s:fav) {
			if(s.equals("0")) {
				respond.println("������");
			}
			if(s.equals("1")) {
				respond.println("ǿ����");
			}
			if(s.equals("2")) {
				respond.println("�ǻ���");
			}
		}

	}
}
