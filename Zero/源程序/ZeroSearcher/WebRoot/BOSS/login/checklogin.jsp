<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="com.zero.Sql.*,java.util.*"%>
  
<%
  Object obj = session.getAttribute("logon");
  ArrayList list = new ArrayList();
  String password = "";
  String username = "";
  //String userType = "";
  if(obj == null){
%>
  <script language="javascript">
	alert('你未登录！');
   //if(confirm("Please"))
	window.top.location="login.jsp";
   //else window.close();
  </script>
<%
	//System.out.println("用户尚未登录.");
	//response.sendRedirect("road-index.jsp");
  }else{
	list = (ArrayList)obj;
	username = (String)list.get(0);
	password = (String)list.get(1);
  }
%>
