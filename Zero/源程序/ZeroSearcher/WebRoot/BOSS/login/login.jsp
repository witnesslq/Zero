<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html:html>
<LINK href="../css/style.css" rel=stylesheet type=text/css><!-- 添加的样式 -->
<head>
<title>
后台管理系统
</title>
</head>
<body bgcolor="#ffffff">
<a href="/ZeroSearcher/index.jsp">返回主页</a>
<br><br><br>
<h1 align="center" ><font color="blue">用户登录界面</font></h1>

<br><br><br>
<% session.removeAttribute("logon"); %>
<html:form action="user" method="POST">
  <html:hidden value="login" property="command"/>
  <table align="center" >
    <tr>
   <td>用户名：</td>
    <td><html:text property="username" size="15"/></td>
    </tr>

  <tr>
  <td>密&nbsp;&nbsp;码：</td>
<td>  <html:password property="password" size="15"/></td>
</tr>
  </table>
    <p></p>
        <table align="center" width="298px"> 
        	<tr>
        		<TD align="center"><html:submit value="登录" property="submit"/>
          			<html:reset value="取消" />
          		</TD></tr>

        </table>
</html:form>

</body>
</html:html>
