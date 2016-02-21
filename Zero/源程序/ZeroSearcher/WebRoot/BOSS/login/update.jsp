<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<%@ page import="com.zero.Sql.*" %>
<%@ page import="java.util.*" %>

<%  String ID = request.getParameter("ID");

  UserBean info = new UserBean();
  info = UserDAO.getUser(ID);

  %>


<html:html>
<LINK href="../css/style.css" rel=stylesheet type=text/css>
<head>
<title>
修改用户
</title>
</head>
<body bgcolor="#ffffff">
<br>
<br>
<br>
<h1 align="center">修改用户信息界面 </h1>
<br>
<html:form action="user" method="post">
  <html:hidden value="update" property="command"/>
          
  <table align="center" width="40%" bgcolor="#f3faf9" border="1">
  <tr>
    <td colspan="3">
      <table align="center" bgcolor="#f3faf9" width="60%">
        <tr>
          <td valign="middle" width="150" align="center">用户名：</td>
          <td valign="middle" width="50%" align="left">
          <html:hidden value="<%=String.valueOf(info.getId()) %>" property="ID"/>
            <html:text property="username" value='<%=info.getUsername()%>'/>
          </td>
        </tr>
        <tr>
          <td valign="middle" width="50%" align="center">密码：</td>
          <td valign="middle" width="50%" align="left">
            <html:text property="password" value='<%=info.getPassword()%>'/>
          </td>
        </tr>
        
      </table>
    </td>
  </tr>
</table>

    <p align="center">
        <html:submit value="修改" property="submit"/>
          <html:reset value="取消" />
      </p>
</html:form>

</body>
</html:html>

