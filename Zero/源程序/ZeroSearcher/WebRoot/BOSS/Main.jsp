<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关于我们的团队</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
.STYLE1 {
	color: #CC0099;
	font-size: 24px;
}
-->
</style>
  </head>
  
  <body>
    <div style=" position:absolute; left:15%; width:auto;">
  <p align="center" class="STYLE1">Zero资源搜索引擎（ZeroSearcher）</p>
<br><p><strong>系统名称： </strong>Zero资源搜索引擎（ZeroSearcher）<br><br> 
<strong>开发者： </strong>Zero 团队</p> 

<strong>所需系统配置：</strong>
<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; jdk 6.0以上 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Tomcat 7.x<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <br><strong>后台管理使用说明：</strong><br>&nbsp;一、 资源管理<br>   二、服务器管理
   <br>  三、用户管理<br><br><br><br><br><p><strong><br></strong></p></div>
  </body>
</html>
