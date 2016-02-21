<%@page import="com.zero.NormallyAndChanging.Change"%>
<%@ page language="java" import="java.util.*,java.net.URLEncoder" pageEncoding="UTF-8"%>
<%

String url=request.getParameter("url");
String pa=Change.change2UrlNorm(url);
System.out.println(pa);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="#">
    
    <title>视频播放</title>
    
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
  
   <pre> 
   
   <br>
     <br>
       <br>
       <br> 
<object classid="clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6"
							id="phx" width="350" height="320">
							<param name="URL" value="<%=pa%>">
							<param name="rate" value="1">
							<param name="balance" value="0">
							<param name="currentPosition" value="0">
							<param name="defaultFrame" value>
							<param name="playCount" value="1">
							<param name="autoStart" value="-1">
							<param name="currentMarker" value="0">
							<param name="invokeURLs" value="-1">
							<param name="baseURL" value>
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
<div id="rpdiv">
						<table border="0">
							<tr>
								<td>
									<input type=button value="全屏"
										onclick="if(phx.playState==3)phx.fullscreen=1;">
								</td>
							</tr>
						</table>


					</div>
				




    

    
   </pre>
  
  </body>
</html>
