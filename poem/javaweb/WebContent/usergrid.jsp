<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#usergrid").datagrid( 
    			{ pagination:true,url:"user/grid"
    			 ,toolbar:[{iconCls:'icon-add',text:"新增",onClick:function(){$('#win').window({
    				    width:200,
    				    height:200,left:300,top:300,title:"新增用户",
    				    modal:true
    				});}}
    			 ,{iconCls:'icon-help',onClick:function(){
    				 var rows=$("#usergrid").datagrid("getSelections");
    				 //console.info(rows);
    				 for(var i=0;i<rows.length;i++){
    					 var r=rows[i];
    					 alert(r.id+" "+r.name+" "+r.pwd+" "+r.sex+" "+r.age+" "+r.email+" "+r.number+" "+r.address+" "+r.staus);
    				 }
    			 }}]
    			 ,pageList:[1,2,3,4,5,10]
    			 ,pageSize:10
    			 ,columns:[[ 
    				 {title:"id主键",field:"id",width:100}
    				 ,{title:"姓名",field:"name",width:100}
    				 ,{title:"密码",field:"pwd",width:100}
    				,{title:"性别",field:"sex",width:100}
    				,{title:"年龄",field:"age",width:100}
    				,{title:"Email",field:"email",width:100}
    				,{title:"电话",field:"number",width:100}
    				,{title:"地址",field:"address",width:100}
    				,{title:"权限等级",field:"staus",width:100}
    			  ]]
    			} );
    });
    </script>
</head>
<body><div id="win"></div>
	<table id="usergrid"></table>
</body>
</html>