<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	String s = sdf.format(d);
	out.println(s);
%>