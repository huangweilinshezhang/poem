<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户登录</h1>
	<form action="/javaweb/userLogin.mvc" method="post"> 
		username:<input name="name"/><br>
		password:<input name="pwd" type="password"/><br>
		<input name="answer"/><img src="code"><br>
		<input type="submit" value="login"/>
</form>
<h1>查看用户界面</h1>
<form action="/javaweb/select.mvc">
		请输入你要查找的id:<input name="id"/><br>
		<input type="submit" value="springmvc查看用户"/>
</form>
<h1>查看所有用户界面</h1>
<form action="/javaweb/selectAllUser.mvc">
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="springmvc查看所有用户界面"/>
</form>
<h1>增加用户界面</h1>
<form action="/javaweb/reg.mvc" method="post">
		姓名:<input name="name"/><br>
		性别:<input name="sex"/><br>
		密码:<input name="pwd" type="password"/><br>
		年龄:<input name="age"/><br>
		Email:<input name="email"/><br>
		电话:<input name="number"/><br>
		地址:<input name="address"/><br>
		<input type="submit" value="springmvc注册"/>
</form>
<h1>删除用户界面</h1>
<form action="/javaweb/delete.mvc">
		请输入你要删除的id:<input name="id"/><br>
		<input type="submit" value="springmvc删除"/>
</form>
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