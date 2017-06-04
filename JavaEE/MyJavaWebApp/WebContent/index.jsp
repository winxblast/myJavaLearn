<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的个人页面</title>
</head>
<body>
	<h1>欢迎大家学习JavaEE课程！</h1>
	<hr />
	<!-- 我是HTML注释，在客户端可见 -->
	<%-- 我是jsp注释，在客户端不可见 --%>
	<%!
		String s = "张三"; // 声明了一个字符串变量
		int add(int x, int y) { //声明了一个返回整数的函数，实现两个整数求和
			return x+y;
		}
	%>
	<%
		//单行注释
		/*多行注释*/
		out.println("大家好！");
	%>
	<br>
	你好，<%=s %><br>
	x+y=<%=add(10, 5) %><br>
</body>
</html>