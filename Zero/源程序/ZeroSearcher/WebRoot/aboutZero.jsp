<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我们的团队</title>
    
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
  <a href="index.jsp">返回主页</a>
  <body>
    <div style=" position:absolute; left:15%; width:auto;">
  <p align="center" class="STYLE1">ZeroSearcher</p>
<p><strong>系统名称： </strong>Zero (ZeroSearcher)</p>
<p><strong>开发者： </strong>Zero 团队</p>
<p><strong>所属学校：</strong> 山东师范大学-信息科学与工程学院</p>
<p><strong>团队成员：</strong> 李朋 ， 李进 ， 阿合买提，郭振亚</p>
 </div>
  </body>
</html>
