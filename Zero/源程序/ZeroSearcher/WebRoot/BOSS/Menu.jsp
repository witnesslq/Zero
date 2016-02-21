<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>        

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="BOSS/css/Menu.css" rel="stylesheet" type="text/css" />
    <script  type="text/javascript" src="BOSS/js/Menu.js"></script>

  </head>
  
  
  
<body background="images/diwen.jpg">
  
<ul id="menu">
<li class="item"><a href="javascript:void(0)" _fcksavedurl="javascript:void(0)" class="title" name="1">资源管理</a>
<ul id="opt_1" class="optiton">
<li><a target="mainFrame" href="Manager/fileAdd.jsp">添加资源</a></li>
<li><a target="mainFrame" href="Manager/submit.jsp">删除资源</a></li>
<li><a target="mainFrame" href="BOSS/Server/List.jsp?type=resource">管理指定服务器资源</li>
</ul>
</li>
<li class="item"><a href="javascript:void(0)" _fcksavedurl="javascript:void(0)" class="title" name="2">服务器管理</a>
<ul id="opt_2" class="optiton">
<li><a target="mainFrame" href="BOSS/Server/Config.jsp">服务器设置</a></li>
<li><a target="mainFrame" href="BOSS/Server/List.jsp?type=server">在线服务器列表</a></li>
</ul>
</li>


<li class="item"><a href="javascript:void(0)" _fcksavedurl="javascript:void(0)" class="title" name="6">用户管理</a>
<ul id="opt_6" class="optiton">
<li><a target="mainFrame" href="BOSS/login/userList.jsp">用户列表</a></li>
<li><a target="mainFrame" href="BOSS/login/register.jsp">添加用户</a></li>
<li><a target="mainFrame" href="BOSS/login/del.jsp">删除用户</a></li>
<li><a target="_parent" href="BOSS/login/login.jsp">退出登录</a></li>
</ul>
</li>
</ul>
  

  </body>
</html>
