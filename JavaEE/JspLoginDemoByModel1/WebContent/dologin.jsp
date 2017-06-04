<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");//防止中文乱码
%>
<jsp:useBean id="loginUser" class="com.po.User" scope="page"></jsp:useBean>
<jsp:useBean id="userDAO" class="com.dao.UserDAO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="loginUser"/>


<%
		

	//如果用户名和密码都等于admin，则登录成功
	if (userDAO.userLogin(loginUser)) {
		session.setAttribute("username", loginUser.getUsername());
		//登录成功则服务器内部转发到login_success.jsp
		request.getRequestDispatcher("login_success.jsp").forward(request, response);
	} else {
		//登录失败则重定向到login_failure.jsp
		response.sendRedirect("login_failure.jsp");
	}
%>
