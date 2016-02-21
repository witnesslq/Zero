<%@page import="com.zero.util.UtilClass"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Config.jsp' starting page</title>
    
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
  
<form id="form1" name="form1" method="post" action="BOSS/Server/ChuliConfig.jsp">
   <table align="center">
    <tr>
       <td>
           主服务器地址设置
       </td>
       <td>
          当前服务器地址           
       </td>
    </tr>
    
    <tr>
       <td>
         <input type="text" name="server" id="textfield" value="<%=UtilClass.getRemoteip() %>" />
       </td>
       <td>
         <%=UtilClass.getHostip() %>          
       </td>
    </tr>
     <tr>
       <td colspan="2" align="center" >  
            <input type="submit" name="button" id="button" value="确定修改" />
       </td>
     </tr>
   </table>
</form>
   
   
  </body>
</html>
