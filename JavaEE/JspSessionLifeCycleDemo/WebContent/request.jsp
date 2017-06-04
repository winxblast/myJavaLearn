<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request内置对象</title>
</head>
<body>
	<h1>request内置对象</h1>
	<hr>
	<%
		request.setCharacterEncoding("UTF-8");//解决中文乱码问题,无法解决URL传递中文乱码问题（但我自己测试没有问题）
		request.setAttribute("password", request.getParameter("password"));
	%>
	用户名：<%=request.getParameter("username") %><br>
	密码：<%=request.getAttribute("password") %><br>
	爱好：<%
		if (request.getParameterValues("favourite") != null) {
			String[] favourites = request.getParameterValues("favourite");
			for (int i = 0; i < favourites.length; i++) {
				out.println(favourites[i] + "&nbsp;&nbsp");
			}

		}
		%>
	<br>	
	请求体的MIME类型：<%=request.getContentType() %><br>
	协议类型及版本号：<%=request.getProtocol() %><br>
	接受请求的服务器主机号：<%=request.getServerName() %><br>
	接受请求的服务器端口号：<%=request.getServerPort() %><br>
	请求文件的长度（byte）：<%=request.getContentLength() %><br>
	请求客户端的IP地址：<%=request.getRemoteAddr() %><br>
	请求的真实路径：<%=request.getRealPath("request.jsp") %><br>
	请求的上下文路径：<%=request.getContextPath() %><br>
</body>
</html>