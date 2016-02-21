<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 
 
<%
  Object obj = session.getAttribute("logon");
  ArrayList list = new ArrayList();
  String username = "";
  //String userType = "";
  if(obj != null){
	list = (ArrayList)obj;
	username = (String)list.get(1);
  }
%>
  
  
  
  
<body>
<div style="top:-10px; position:absolute;">
<table style="margin-top:0px;" align="center">
<tr><td>
   <img src="images/zero.jpg" width="303" height="113" />
</td></tr>
</table>
	   <table bgcolor="#d0dff4" width="100%" border="0">
			<tr>	
				<td >欢迎您的到来：&nbsp;&nbsp;<strong><%=username %></strong></td><td align="center" ><font size="3"><strong>ZeroSearcher后台管理系统</strong></font></td>
			</tr>
	   </table>
</div>
  </body>
</html>
