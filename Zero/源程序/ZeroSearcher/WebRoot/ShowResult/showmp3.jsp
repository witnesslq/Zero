<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.zero.util.UtilClass"%>
<%@page import="com.zero.NormallyAndChanging.Change"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String url=request.getParameter("url");
String title=request.getParameter("title"); 
String pa1 = Change.change2UrlNorm(url);
String pa=Change.change2UrlNorm(url);
String[] paths = pa.split("/");
pa = UtilClass.getPath("webapps");
int s = paths.length;
pa = pa + "\\" + paths[s-2] + "\\" + paths[s-1];
System.out.println(pa);
System.out.println(Change.change2UrlNorm(title));
%>


<html>
  <head>
    <base href="#">
    
    <title>音乐播放器</title>
    
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
  <center>
<div style="margin: 0px; left: 20px; position: absolute; width: 500px; height: 600px;">



<table width="300px" border="0" align="center">
  <tr>
    <td height="30" align="left">正在播放：<%=Change.change2UrlNorm(title) %></td>   
    <td align="center" width="100"><a href=<%=pa1 %>  style="text-decoration:none">下载音乐</a></td>
  </tr>
</table>

<object classid="clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6"
							id="phx" width="200" height="50">
							<param name="URL" value="<%=pa%>">
							<param name="rate" value="1">
							<param name="balance" value="0">
							<param name="currentPosition" value="0">
							<param name="defaultFrame" value>
							<param name="playCount" value="1">
							<param name="autoStart" value="true">
							<param name="currentMarker" value="0">
							<param name="invokeURLs" value="-1">
							<param name="baseURL" value="<%=basePath%>">
							<param name="volume" value="50">
							<param name="mute" value="0">
							<param name="uiMode" value="full">
							<param name="stretchToFit" value="0">
							<param name="windowlessVideo" value="0">
							<param name="enabled" value="-1">
							<param name="enableContextMenu" value="-1">
							<param name="fullScreen" value="0">
							<param name="SAMIStyle" value>
							<param name="SAMILang" value>
							<param name="SAMIFilename" value>
							<param name="captioningID" value>
							<param name="enableErrorDialogs" value="0">
							<param name="_cx" value="6482">
							<param name="_cy" value="6350">
						</object>

<br/>
<br/>
<!-- 
	<center>
	<P style="HEIGHT: 30px top:50px">
		<A onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('<%=basePath%>')" 
			href="<%=basePath%>">将Zero设为主页</A>丨
        <A href="../aboutZero.jsp">关于Zero</A>
     </P>
	<hr color="#999999" width="300px" size="1px"/><br />
    欢迎使用Zero
	
	</center>
 -->
 </div>

</center>
  
   
 
   
    

    

  
  </body>
</html>
