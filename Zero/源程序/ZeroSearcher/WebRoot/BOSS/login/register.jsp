<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html:html lang="true">
  <head>
    <title>添加页面</title>
	<LINK href="../css/style.css" rel=stylesheet type=text/css>
  </head>
  
  <body>
    <h1 align="center">添加用户页面</h1> 
    <html:form action="user" method="post">
    <html:hidden value="insert" property="command"/>
    <table align="center">
    	<tr>
    		<td>用户名：</td>
    		<td><html:text property="username" size="15"/></td>
    	</tr>
    	<tr>
            <td >密 &nbsp; 码：</td>
			<td ><html:password property="password" size="15"/></td>
		</tr>

		<tr>
 			 <td >重复密码 ：</td>
			 <td ><html:password property="confirm" size="15"/></td>
		</tr>
		<tr>
 			 <td align="right"><html:submit property="submit" value="添加"/></td>
			 <td align="left"><html:reset property="reset" value="取消"/></td>
		</tr>

    </table>
    </html:form>
  </body>
</html:html>
