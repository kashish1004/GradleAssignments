<%@page import="com.phoenix.services.LoginServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session = "false" import="com.phoenix.services.LoginService, com.phoenix.services.LoginService, com.phoenix.data.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<% 
		HttpSession ss = request.getSession(false);
		if(ss!=null){
			String userName = (String)ss.getAttribute("user");
			LoginService ls = new LoginServiceImpl();
			User us = ls.findUserById(userName);
			ls.remove(us);
			ss.invalidate();
			response.sendRedirect("login.html");
			}
		else{
			out.println("<h3 style = 'color:red'>Session expired</h3>");
		}
	%>
</body>
</html>