<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//此页面配合pageContext.jsp页面使用
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	String s = sdf.format(date);
	out.println(s+"<br>");
%>