<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Forward动作</h1>
	<hr>
	<jsp:forward page="user.jsp">
		<jsp:param value="wxb@163.com" name="email"/>
		<jsp:param value="888888" name="password"/>
	</jsp:forward>
	<%--param动作可以派和forward动作一起使用，修改表单内容 --%>
	<%--
		//上面的forward与这句是一样的
		request.getRequestDispatcher("user.jsp").forward(request, response);
	--%>
</body>
</html>