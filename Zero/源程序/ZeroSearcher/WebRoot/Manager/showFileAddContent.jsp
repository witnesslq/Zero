<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="java.util.*"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>showFileAddContent.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body > 

	<table width="100%" border="0">
			<tr>
    
				<td width="210" bgcolor="#d0dff4">资源猎手</td>
				<td bgcolor="#d0dff4"><font size="3"><strong>资源发布</strong></font></td>
				<td width="200" align="right" bgcolor="#d0dff4"><font size="3">资源猎手首页</font></td>
			</tr>
	</table>

 <form   method="post" action="fileadd.do" onsubmit="return check();">
     <table align="center">
  <%
	/*新加的用来存放文件的Name名称*/
	List listNamea = (List)request.getAttribute("fileName1");
	List listKeyWords = (List)request.getAttribute("fileName2");
	List listType = (List)request.getAttribute("fileName3");
	List listDescribe = (List)request.getAttribute("fileName4");
	List listUrl = (List)request.getAttribute("fileName5");
	List listDate = (List)request.getAttribute("fileName6");
	List listAuthor = (List)request.getAttribute("fileName7");
	List listPublisher = (List)request.getAttribute("fileName8");
	List listKind = (List)request.getAttribute("fileName9");
	for(int i=0;i<listNamea.size();i++){
		%>
		<tr>              
		 <!-- title的表单域 -->
		 <tr><th><label for="title">title：</label></th><td class="input"><input id="title" name="files" type="text" class="text" value="<%=listNamea.get(i)%> " /><span></span></td></tr>
		 <!-- keywords的表单域 -->
		 <tr><th><label for="keywords">keywords：</label></th><td class="input" ><input id="keywords" name="keywords" type="text" class="text" value="<%=listKeyWords.get(i)%> "  /><span></span></td></tr>
		 <!-- kind的表单域 -->
		 <tr><th><label for="kind">kind：</label></th><td class="input" ><input id="kind" name="kind" type="text" class="text" value="<%=listKind.get(i)%>"  /><span></span></td></tr>
		 <!-- describe的表单域 -->
		 <tr><th><label for="describe">describe：</label></th><td class="input" ><input id="describe" name="describe" type="text" class="text" value="<%=listDescribe.get(i)%>"  /><span></span></td></tr>
		 <!-- date的表单域 -->
		 <tr><th><label for="date">date：</label></th><td class="input" ><input id="date" name="date" type="text" class="text" value="<%=listDate.get(i)%>"  /><span></span></td></tr>
		 <tr>
		 <!-- url的表单域 -->
		 <tr><th><label for="url">url：</label></th><td class="input" ><input id="url" name="url" type="text" class="text" value="<%=listUrl.get(i)%>"  /><span></span></td></tr>
		 <!-- author的表单域 -->
		 <tr><th><label for="author">author：</label></th><td class="input" ><input id="author" name="author" type="text" class="text" value="<%=listAuthor.get(i)%>"  /><span></span></td></tr>
		 <!-- publisher的表单域 -->
		 <tr><th><label for="publisher">publisher：</label></th><td class="input" ><input id="publisher" name="publisher" type="text" class="text" value="<%=listPublisher.get(i)%>"  /><span></span></td></tr>
		 <tr><th colspan="2">...................................................</th>
		  </tr>
		<%
	}

  %>
  		 <tr><th></th><td class="input" ><input type="submit" value="提交" ><span></span></td></tr>
   </table> 
   </form>
  </body>
</html>
