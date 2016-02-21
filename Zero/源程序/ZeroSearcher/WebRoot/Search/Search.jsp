<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>精确搜索</title>
    
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
  
<div style="left:150px; position:absolute; width:1000px; height:800px; margin:0px; margin-top:0px; margin-left:0px;">



<table width="70%" border="0" align="center">
  <tr>
    <td height="150">&nbsp;</td>
    <td align="center"><img src="images/zero.jpg" onClick="javascript:window.location='/ZeroSearcher/MainIndex.jsp'"></td>
    <td>&nbsp;</td>
  </tr>
</table>
<table align="center" width="921" border="0">
	
   
	<tr>
    
		<td width="200" bgcolor="#d0dff4" style="width: 250px; ">ZeroSearcher</td>
		<td align="center" bgcolor="#d0dff4"><font size="3"><strong>精确搜索</strong></font></td>
		<td width="200" align="right" bgcolor="#d0dff4" style="width: 197px; "><font size="3">Zero &nbsp;&nbsp;团队开发</font></td>
	</tr>
</table><br>
    
    
<form action="result.jsp" method="post">
<table align="center" width="921" border="0" bgcolor="#d0dff4">

	<tr>
		<td width="125" height="30"><font size="3"><strong>搜索结果</strong></font></td>
      <td width="257"><font size="3">
		  <select name="type">
			<option value="every">智能分词并包含任一关键词</option>
			<option value="complete">包含以下的完整关键词</option>
			<option value="all">包含以下全部的关键词</option>
			<option value="same">与关键字完全匹配</option>
			</select>
		</td>
      <td width="280"><font size="3">
          <input type="text" name="jiansuo" size="40"></font>&nbsp; 
		</td>
	</tr>
     <tr>
		<td width="125" height="30">&nbsp;</td>
		<td width="257"><font size="3">资源作者</font></td>
<td>
			<input type="text" name="jiansuo" size="40">&nbsp;		</td>
	</tr>
    <tr>
		<td width="125" height="30">&nbsp;</td>
		<td width="257"><font size="3">出版社</font></td>
<td>
			<input type="text" name="jiansuo" size="40">&nbsp; 
	  </td>
        <td width="196"><input type="submit" value="搜&nbsp;索" name="button1"></td>
	</tr>	
	<tr>
		<td width="125" height="30"><font size="3"><strong>显示条数</strong></font></td>
		<td width="257"><font size="3">选择显示的条数</font></td>
<td>
			<select name="num">
			<option value="10">每页显示10条</option>
			<option value="15">每页显示15条</option>
			<option value="20">每页显示20条</option>
			</select>
		</td>
        
	</tr>
	<tr>
		<td width="125" height="30"><font size="3"><strong>搜索类型</strong></font></td>
		<td width="257"><font size="3">请选择搜索类型</font></td>
<td>
			<select name="kind">
			<option value="all">全部</option>
			<option value="document">文档</option>
			<option value="mp3">MP3</option>
            <option value="vedio">视频</option>
            <option value="picture">图片</option>
			</select>
		</td>
        
	</tr>
   
   


</table> </form>

<br/>
<br/>
	<center>
	<P style="HEIGHT: 30px top:50px">
		<A onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('<%=basePath%>')" 
			href="<%=basePath%>">把ZeroSearcher设为主页</A>丨
        <A href="aboutZero.jsp">关于Zero</A>
     </P>
	<hr color="#999999" width="500px" size="1px"/><br />
    欢迎使用ZeroSearcher
	
</center>




 
 </div>



 
 
  </body>
</html>
