<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");//设置响应的MIME类型

	out.println("<h1>response内置对象</h1>");
	out.println("<hr>");
	//out.flush();//清空缓冲区，使得out的输出内容在outer之前
	
	PrintWriter outer = response.getWriter();//获得输出流对象，注意与内置的out对象的区别
	outer.println("大家好，我是response对象生成的输出流outer对象");
	//response.sendRedirect("register.jsp");//请求重定向
	
	//请求重定向
	//response.sendRedirect("request.jsp");//从本质上讲等同于两次请求，前一个页面的对象如用户名等不会保存，地址栏的URL会变
	
	//请求转发,是一次请求，转发后请求对象会保存，地址栏的URL不会改变
	request.getRequestDispatcher("request.jsp").forward(request, response);
	
%>