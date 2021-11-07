<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>修改页面</h1>
	<form action="/javaweb/update.mvc">
		请输入你要修改的id:<input name="id"/><br>
		姓名:<input name="name"/><br>
		性别:<input name="sex"/><br>
		密码:<input name="pwd" type="password"/><br>
		年龄:<input name="age"/><br>
		Email:<input name="email"/><br>
		电话:<input name="number"/><br>
		地址:<input name="address"/><br>
		<input type="submit" value="springmvc修改"/>
	</form>
</body>
</html>