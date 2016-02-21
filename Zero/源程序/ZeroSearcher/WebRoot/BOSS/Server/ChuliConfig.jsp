<%@page import="com.zero.xml.ChangeHostIP"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ChuliConfig.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%  String server=request.getParameter("server"); %>
<body>
 
 <% if(server!=null){
 System.out.println(server); 
 ChangeHostIP li=new ChangeHostIP();
    if(li.dul(server)){
    	out.println("<script language=javascript>");
    	     out.println("alert('主服务器地址修改为"+server+"')");
	    out.println("location.href='Config.jsp'</script>");

    }else{
        	out.println("<script language=javascript>");
    	    out.println("alert('主服务器地址修改失败')");
	        out.println("location.href='Config.jsp'</script>");
    
    
    }
 
 } %>
 
 
</body>
</html>
