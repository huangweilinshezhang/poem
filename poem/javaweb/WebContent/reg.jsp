<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.Date,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#cal").calendar({border:false,width:300
    		,onSelect: function(date){
    			alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
    		}
    	});
    	$('#cal').calendar('moveTo', new Date(2012, 6, 1));
    });
    </script>
</head>
<body>
	<form action="/javaweb/reg.mvc">
		姓名:<input name="name"/><br>
		性别:<input name="sex"/><br>
		密码:<input name="pwd" type="password"/><br>
		年龄:<input name="age"/><br>
		Email:<input name="email"/><br>
		电话:<input name="number"/><br>
		地址:<input name="address"/><br>
		<input type="submit" value="springmvc注册"/>
	</form>
	<br>
	<%!int a=0; //jsp声明中定义的变量a ,成员变量%>
	<%! void test(){} //jsp声明中定义成员方法%>
	<% int a=0; //jsp脚本片段中定义的变量a，_jspService方法中的局部变量 %>
	<%=new java.util.Date() %><%--是java中的java.util.Date类 --%><!-- html风格的注释 -->
</body>
</html>