<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
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
  String password = "";
  String username = "";
  //String userType = "";
  if(obj == null){
%>
  <script language="javascript">

	window.top.location="login/login.jsp";  <% //登录 转向登陆界面 %>
  
  </script>
<%

  }else{
	list = (ArrayList)obj;
	username = (String)list.get(1);
	password = (String)list.get(2);
  }
%>

<frameset rows="145,*" cols="*" frameborder="yes" border="1" framespacing="0">
  <frame src="BOSS/Top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="Top" />
  <frameset rows="*" cols="153,*" framespacing="0" frameborder="no" border="0">
    <frame src="BOSS/Menu.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="Menu" />
    <frame src="BOSS/Main.jsp" name="mainFrame" id="mainFrame" title="Main" />
  </frameset>
</frameset>
<noframes>


<body>
</body>
</noframes>




</html>
