<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<%@page import="java.util.*,com.zero.Sql.*" %>


  <%
  Object obj = session.getAttribute("logon");
  ArrayList listuser = new ArrayList();
  String password = "";
  String username = "";
  String Manager = "";
  //String userType = "";
  if(obj == null){
%>
  <script language="javascript">

	window.top.location="login/login.jsp";  <% //登录 转向登陆界面 %>
  
  </script>
<%

  }else{
	listuser = (ArrayList)obj;
	username = (String)listuser.get(1);
	password = (String)listuser.get(2);
    Manager = (String)listuser.get(3).toString();
  }
%>



<html:html>
<LINK href="../css/style.css" rel=stylesheet type=text/css>
<head>
<title>
 删除用户界面
</title>
</head>
<body bgcolor="#ffffff">
<h1 align="center">用户信息 </h1>
<html:form action="user"  method="post" >
<html:hidden value="del" property="command"/>
<table width=70% border=0 cellpadding="3" cellspacing="1" align="center">
   <tr bgcolor=#8899cc>

   <td> 编号</td>
   <td> 用户名</td>
   <td>密码</td>
   <td>修改</td>
   </tr>

<%
     
  ArrayList list=UserDAO.getAll();
  if(list.size()!=0) {
  Iterator it = list.iterator();
  while (it!=null && it.hasNext()) {
   UserBean info = (UserBean)it.next();
%>
<tr bgcolor=#ffffff>
<td><%=info.getId()%> </td>
<td> <%=info.getUsername()%></td>
<% if(Integer.parseInt(Manager)>=5){ %>
<td><%=info.getPassword()%></td>
<td><a href="update.jsp?ID=<%=String.valueOf(info.getId()) %>"target="_self">修改</a></td>
<% }else{ %>
<td>**********</td>
<td>您没有权限修改用户信息</td>

<% } %>
</tr>
<%  } }%>
<tr>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
</tr>
</table>

</html:form>
</body>
</html:html>
