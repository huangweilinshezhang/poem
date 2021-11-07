<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<form action="/javaweb/userLogin.mvc"> 
		username:<input name="name"/><br>
		password:<input name="pwd" type="password"/><br>
		<input name="answer"/><img src="code"><br>
		<input type="submit" value="login"/>
	</form>
</body>
</html>