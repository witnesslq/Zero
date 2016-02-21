<%@page import="com.zero.read.readppt"%>
<%@page import="com.zero.read.readword2"%>
<%@page import="com.zero.NormallyAndChanging.Change"%>
<%@ page language="java" import="java.util.*,java.net.URLEncoder" pageEncoding="UTF-8"%>
<%
String url=request.getParameter("url");
String kin=request.getParameter("kind");
String ki=kin;
String pa=Change.change2UrlNorm(url);
System.out.println(pa);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>文档读取</title>
    
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

  <div style="position:absolute; width:1200px; height:650px; background-repeat:no-repeat;  background-image:url(../images/officebace.jpg)">
      <div style="position:absolute; left: 25px; top: 22px; width: 800px; height: 500px; overflow:scroll;">

          <pre> 
             <% if(ki.equals("doc")){ %>
             <%=readword2.getDocContent(pa) %>
             <%}else{%>
             <%= readppt.getPptStr(pa)%>
             <%} %>
          </pre>

      </div>
  </div>
  

  
  </body>
</html>
