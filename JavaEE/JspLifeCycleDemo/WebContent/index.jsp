<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp生命周期</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String s = sdf.format(new Date());
	%>
	今天是：<%=s %>
</body>
</html>