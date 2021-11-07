<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>显示所有诗词</h1>
	${msg}<br>
	
<table border=1>
<tr>
	<td>用户</td>
	<td>密码</td>
	<td>年龄</td>
	<td>Email</td>
	<td>性别</td>
	<td>电话</td>
	<td>地址</td>
</tr>
<c:forEach items="${msg }" var="data">
<tr>
	<td>${data.name}</td>
	<td>${data.pwd}</td>
	<td>${data.age}</td>
	<td>${data.email}</td>
	<td>${data.sex}</td>
	<td>${data.number}</td>
	<td>${data.address}</td>
</tr>
</c:forEach>
</table>
</body>
</html>