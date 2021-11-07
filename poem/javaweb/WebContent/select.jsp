<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看用户界面</h1>
<form action="/javaweb/select.mvc">
		请输入你要查找的id:<input name="id"/><br>
		<input type="submit" value="springmvc查看用户"/>
</form>
<h1>查看所有用户界面</h1>
<form action="/javaweb/selectAllUser.mvc">
		<input type="submit" value="springmvc查看所有用户界面"/>
</form>
</body>
</html>