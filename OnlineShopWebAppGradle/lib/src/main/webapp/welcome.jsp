<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body style = 'text-align: center;background-color: cyan' >
<%@ include file="header.html" %>
<h2 style='color:blue'>Hello <jsp:getProperty property="username" name="ob"/>, Shop the best products available</h2>
<% 	
	String uname = request.getParameter("username");
	session.setAttribute("user",uname);
	String url = response.encodeURL("ProductServlet");
%>
<h2 style='color:blue'>Session Expires in: <%=session.getMaxInactiveInterval()%> Seconds</h2>
<p style='color:blue'>To go to Shopping page <a href =<%=url %>>Click Here</a></p>
<a href ="change.jsp">Change Password</a><br><br>
<form action ="deleteAcc.jsp">
<input type = "submit" value = "delete your account">
</form>
</body>
</html>
<%@ include file="footer.html" %>