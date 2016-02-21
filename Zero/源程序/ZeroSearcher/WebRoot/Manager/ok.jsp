<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资源删除成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
   
<div style="position:absolute; left:expression((document.body.clientWidth-this.offsetWidth)/2);   top:expression((document.body.clientHeight-this.offsetHeight)/2);font-size:50px;">
     <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>   
<tr>
	<td colspan="4" align="center">
		<br>
	</td>      
</tr>	
    <td  align="center"><img src="images/delete.jpg" width=400 height=110 border=0 alt="public" title="seachforyou">&nbsp;</td>
</table>
    <table align="left" width="100%" border ="0" cellpadding="0" bgcolor="#d0dff4">
<tr>

  <td align="center" ><a href="Manager/submit.jsp">返回&gt;&gt;&gt;</a></td>
   </tr>
</table>  
   </div>
   
   
  </body>
</html>
