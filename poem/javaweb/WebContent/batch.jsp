<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 多个数据的时候才考虑这个（比如批量清空购物车） -->
	<!-- 1.首先先建立一个表单 -->
	<form action="/javaweb/ctrl/delete.mvc">
		<input name="ids" value="1"/><br>
		<input name="ids" value="2"/><br>
		<input name="ids" value="3"/><br>
		<input name="ids" value="4"/><br>
		<input type="submit" value="批量删除"/>
	</form>
	
	<!-- 
	1.新建一个表单
	2.去新建java类，封装一个学生对象（Score.java）
	3.封装了对象有一个好处，就是在UserCtrl使用对象作为参数，方法内可以调用对象的属性
	4.返回这里，修改name下的数组，
	5.静茹UserCtrl中增加model方法
	-->
	<form action="/javaweb/ctrl/score.mvc">
		<input name="data[0].studentId" value="1"/>
		<input name="data[0].chinese" value="90"/>
		<input name="data[0].maths" value="80"/>
		<input name="data[0].english" value="70"/>
		<input name="data[1].studentId" value="21"/>
		<input name="data[1].chinese" value="91"/>
		<input name="data[1].maths" value="81"/>
		<input name="data[1].english" value="71"/>
		<input type="submit" value="录入成绩"/>
	</form>
	
</body>
</html>