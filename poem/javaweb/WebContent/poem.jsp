<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>诗词界面</title>
</head>
<body>
<br>
	<h1>超级特殊分类查询</h1>
	<form action="/javaweb/ctrl/superGame2.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		诗人名字:<input name="poet"/><br>
		诗人朝代:<input name="dynasty"/><br>
		诗歌类型:<input name="type"/><br>
		<input type="submit" value="game2升级版:吟诗作词（根据类型作者朝代获取古诗）"/>
		
	</form>
	<br>
	<hr>
	<hr>
	<h1>1.查看所有诗词</h1>
	<form action="/javaweb/ctrl/selectAllPoem.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="查看所有诗词">
	</form>	
	<br>
	<hr>
	<h1>2.分类查询</h1>
	<form action="/javaweb/ctrl/selectAllType.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="获取所有类型">
		
	</form>
	<br>
	<hr>
	<form action="/javaweb/ctrl/selectAllAuther.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="获取所有作者">
		
	</form>
	<br>
	<hr>
	<form action="/javaweb/ctrl/selectAllDynasty.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="获取所有朝代">
		
	</form>
	<br>
	<hr>
	<form action="/javaweb/ctrl/classified_Query.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		请输入查找诗词类型:<input name="type"/><br>
		<input type="submit" value="根据类型查找古诗">
	</form>	
	<br>
	<hr>
	<form action="/javaweb/ctrl/selectPoemByAuther.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		请输入作者查找古诗:<input name="auther"/><br>
		<input type="submit" value="根据作者查找古诗">
	</form>	
	<br>
	<hr>
	<form action="/javaweb/ctrl/selectPoemByDynasty.mvc" >
	请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		请输入朝代查找古诗 :<input name="dynasty"/><br>
		<input type="submit" value="根据朝代查找古诗 ">
	</form>	
	<br>
	<hr>
	<h1>6.查看诗词界面</h1>
	<form action="/javaweb/ctrl/selectPoem.mvc" >
		请输入查看的诗词id:<input name="id"/><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<hr>
	<h1>7.增加诗词界面</h1>
	<form action="/javaweb/ctrl/addPoem.mvc" >
		诗名:<input name="title"/><br>
		朝代:<input name="dynasty"/><br>
		作者:<input name="auther"/><br>
		内容:<input name="content"/><br>
		类型:<input name="type"/><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<hr>
	<h1>8.删除诗词界面</h1>
	<form action="/javaweb/ctrl/deletePoem.mvc" >
		请输入删除的诗词:<input name="id"/><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<hr>
	<h1>9.修改诗词界面</h1>
	<form action="/javaweb/ctrl/updatePoem.mvc" >
		诗词id:<input name="id"/><br>
		诗名:<input name="title"/><br>
		朝代:<input name="dynasty"/><br>
		作者:<input name="auther"/><br>
		内容:<input name="content"/><br>
		类型:<input name="type"/><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<hr>
<h1>10.查看作者界面</h1>
<form action="/javaweb/ctrl/selectAllAuther.mvc">
请输入你选择的页数:<input name="page"/><br>
	请输每页查询多少条:<input name="count"/><br>
		<input type="submit" value="查看所有作者"/>
</form>
<br>
	<hr>
<h1>11.增加作者界面</h1>
<form action="/javaweb/ctrl/addtwoPoet.mvc">
		作者名:<input name="auther"/><br>
		内容:<input name="msg"/><br>
		<input type="submit" value="springmvc注册"/>
</form>
<br>
	<hr>
<h1>13.修改作者页面</h1>
	<form action="/javaweb/ctrl/updatePoet.mvc">
		名字:<input name="auther"/><br>
		内容:<input name="msg"/><br>
		<input type="submit" value="springmvc修改"/>
	</form>
	<br>
	<hr>
<h1>14.删除作者界面</h1>
<form action="/javaweb/ctrl/deletePoet.mvc">
		请输入你要删除的作者:<input name="auther"/><br>
		<input type="submit" value="springmvc删除"/>
</form>
<br>
	<hr>
<h1>15.game1界面</h1>
<form action="/javaweb/ctrl/game1.mvc">
		<input type="submit" value="game1：点击随机获取一首诗"/>
</form>
<br>
	<hr>
<h1>16.game2界面</h1>
<form action="/javaweb/ctrl/game2.mvc">
		诗人名字:<input name="poet"/><br>
		诗人朝代:<input name="dynasty"/><br>
		诗歌类型:<input name="type"/><br>
		<input type="submit" value="game2:吟诗作词（根据类型作者朝代随机获取一首古诗）"/>
		
</form>
</body>
</html>