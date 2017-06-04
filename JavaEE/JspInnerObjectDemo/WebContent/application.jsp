<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application内置对象</title>
</head>
<body>
	<h1>application内置对象</h1>
	<hr>
	<%
		application.setAttribute("city", "上海");
		application.setAttribute("postcode", "200000");
		application.setAttribute("email", "lisi@163.com");
	%>
	所在城市是：<%=application.getAttribute("city") %><br>
	application中的属性有：<%
		Enumeration attributes = application.getAttributeNames();
		while (attributes.hasMoreElements()) {
			out.println(attributes.nextElement());
		}
	%><br>
	
	JSP(SERVLET)引擎名及版本号：<%=application.getServerInfo() %>
</body>
</html>