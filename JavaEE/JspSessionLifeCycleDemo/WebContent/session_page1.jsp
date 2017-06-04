<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session内置对象</title>
</head>
<body>
	<h1>session内置对象</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Date d = new Date(session.getCreationTime());
		session.setAttribute("username", "admin");
		session.setAttribute("password", "123456");
		session.setAttribute("age", "25");
		
		//设置当前页面session最大生存期限，单位是秒
		//session.setMaxInactiveInterval(10);//10秒
		
	%>
	session创建时间：<%=sdf.format(d) %><br>
	session的ID编号：<%=session.getId() %><br>
	从session中获取用户名：<%=session.getAttribute("username") %><br>
	<%
		session.invalidate();//销毁当前会话
	%>
	
	<a href="session_page2.jsp" target="_blank">跳转到session_page2.jsp</a>
</body>
</html>