<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="exception.jsp"%>
<!-- 上面的errorPage指本页面出现异常时交给哪个页面处理 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>exception test</title>
</head>
<body>
	<h1>测试异常的页面</h1>
	<hr>
	<%
		out.println(100/0); //抛出运行时异常，算数异常
	%>
</body>
</html>