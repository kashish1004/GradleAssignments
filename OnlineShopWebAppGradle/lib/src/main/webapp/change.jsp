<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<% HttpSession session = request.getSession(false); %>
<body style = 'text-align: center;background-color: cyan'>
	<form action = "ChangePass" method = "post">
		New Password:<input type="password" name = "newpasswd" required><br><br>
		Confirm New Password:<input type = "password" name ="cfmnewpasswd" required><br><br>
		<input type = "submit" value = "Confirm">
	</form>
</body>
</html>