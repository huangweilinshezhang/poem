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
	
<table width="100%" border=1>
<tr>
	<td>标题</td>
	<td>朝代</td>
	<td>诗人</td>
	<td>诗歌</td>
	<td>用户</td>
</tr>
<c:forEach items="${msg }" var="data">
<tr>
	<td>${data.title}</td>
	<td>${data.dynasty}</td>
	<td>${data.auther}</td>
	<td>${data.content}</td>
	<td>${data.user_id}</td>
</tr>
</c:forEach>
</table>
</body>
</html>