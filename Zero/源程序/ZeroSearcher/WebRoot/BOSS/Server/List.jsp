<%@page import="com.zero.Rmi.IPlist"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>服务器列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <% String type=request.getParameter("type");// server 为在线服务器  resource 为资源管理 %>
  
  <body>
  <p align="center"><strong><span style="color:#FF0000;">在线服务器</span></strong></p>
 <% for(int i=0;i<IPlist.iplist.size();i++){ %>
            
            <div style="position:absolute; left:<%=((int)(i%3))*300 %>px; top:<%=((int)(i/3))*230+50 %>px; width:315px; ">
                    <div style="position:absolute; left: 135px; top: 55px; width: 119px; height: 34px;"><strong>&nbsp;&nbsp;&nbsp;IP地址<br><%=IPlist.iplist.get(i).toString() %></strong></div>
                               <img src="images/computer.png" width="316" height="225" >
                  
                   <div>
                     <table width="100%">
                       <tr>
                       <%if(type.equals("resource")){ %>
                        <td align="center"><a href="BOSS/Server/ChuliList.jsp?mingling=addres&ip=<%=IPlist.iplist.get(i).toString()  %>">增加资源</a></td>
                        <td align="center"><a href="BOSS/Server/ChuliList.jsp?mingling=list&ip=<%=IPlist.iplist.get(i).toString()  %>">查看资源列表</a></td>
                       <% } else { if(type.equals("server")){ %>
                        <td align="center"><a href="BOSS/Server/ChuliList.jsp?mingling=delip&ip=<%=IPlist.iplist.get(i).toString()  %>">断开此服务器连接</a></td>
                       <%} }%>
                       </tr>
                     </table>
                   </div>
            </div>
   
 
   <%} %> 
   

  </body>
</html>
