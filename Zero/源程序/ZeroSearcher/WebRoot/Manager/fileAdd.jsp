<%@page import="com.zero.util.UtilClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<style type="text/css">
	#header {
	border-top: 1px solid #778899;
	border-bottom: 1px dotted #B2BCC6;
	height: 3em;
}
#header .strapline {
	font: 120% Georgia, "Times New Roman", Times, serif;
	color: #778899;
	background-color: transparent;
	float: right;
	margin-right: 2em;
	margin-top: 1em;
}
#header .logo {
	float: left;
	margin-left: 1.5em;
	margin-top: 0.5em;
}
*{ 
   padding:0; 
   margin:0; 
   list-style:none;
    font-size:12px;}
#form1{
    margin:50px;
   }
#form1 li{
   float:left; 
   width:15.4%;
   text-align:center;
   margin:0 auto; 
   list-style:none }
#form1 li a span{
   margin:-15px 0 0 -40px;
   position:absolute;
   background="#d0dff4";
   no-repeat; 
   display:block;
   height:35px; 
   width:41px;}
</style>

	<head>
		<base href="<%=basePath%>">

		<title>添加资源</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script><!--
function check() {	
	if((form1.f1.value == "" || form1.f1.value == null)&&(form1.f2.value == "" || form1.f2.value == null)&&(form1.f3.value == "" || form1.f3.value == null)&&(form1.f4.value == "" || form1.f4.value == null)&&(form1.f5.value == "" || form1.f5.value == null)){
		alert("请选择数据文件");
		return false;
	}
			
	return true;
}
//--></script>
 
	</head>
 
	<body>
	   <table width="100%" border="0">
			<tr>	
				<td bgcolor="#d0dff4" ><font size="3"><strong>资源发布</strong></font></td>
			</tr>
	   </table>
   <div id="wrapper">

	<table width="100%"  border="0" cellspacing="0" cellpadding="0">

    <td  align="center"><strong>执行操作的服务器是：<%=UtilClass.getHostip() %></strong><br><br></td>
</table>
		<form name="form1" enctype="multipart/form-data" method="post"
			action="updata" onsubmit="return check();">
			<table align="center">
				<tr>
					<th>
						<p align="center">请选择您要上传的文件路径</p>
				</tr>
				
				<tr>
					<th height="35">
						<input name="f1" type="file" size="100"
							onKeyDown="javascript:alert('此信息不能手动输入');return false;" />	
				</tr>

				<tr>
					<th height="35">
						<input name="f2" type="file" size="100"
							onKeyDown="javascript:alert('此信息不能手动输入');return false;" />
				</tr>

				<tr>
					<th height="35">
						<input name="f3" type="file" size="100"
							onKeyDown="javascript:alert('此信息不能手动输入');return false;" />
				</tr>

				<tr>
					<th height="35">
						<input name="f4" type="file" size="100"
							onKeyDown="javascript:alert('此信息不能手动输入');return false;" />
				</tr>

				<tr>
					<th height="35">
						<input name="f5" type="file" size="100"
							onKeyDown="javascript:alert('此信息不能手动输入');return false;" />	
				</tr>
				<br>
				<tr>
					<th height="35">
						<input type="submit" value="文件发布">
				</tr>
			</table>
		</form>

	</body>
</html>
