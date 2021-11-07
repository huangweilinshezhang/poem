<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="dao.user.*,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<% String p=request.getParameter("p");//取请求中的参数，看看用户要查第几页
	   String m=request.getParameter("m");//每页最多显示多少条数据
	   if(p==null) p="1";
	   if(m==null) m="2";
	   int pg =Integer.parseInt(p);
	   int max=Integer.parseInt(m);
	   UserDao dao=new UserDao();
	   List<Long> users=dao.queryUsers(pg,max);//dao.queryUsers(1, 2);//看第一页，每页最多显示2条数据
	   if(users.size()==0){
		   out.println("no data.");
	   }else{
		   for(int i=0;i<users.size();i++){
			   out.println("id="+users.get(i)+"<br>");
		   }
	   }
	 %><br>当前是第<b><%=pg%></b>页 
	   <a href="userList.jsp?p=<%=pg+1%>">下一页</a>
	   <form action="userList.jsp" >
	                              跳转到第<input name="p"/>页
	          <input type="submit" value="确定"/>
	   </form>
</body>
</html>