<%@page import="com.zero.util.UtilClass"%>
<%@ page language="java" import="java.sql.*,java.util.*" pageEncoding="UTF-8"%>
<%


   String key=request.getParameter("keyword");  
 
		String str="";
		
		try{
		  String   dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ="+ UtilClass.realPath +"\\SQL\\suggest.mdb";  
		  String   user="";   
		  String   password="";   
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
		  Connection c=DriverManager.getConnection(dbUrl,user,password);
		  Statement   s=c.createStatement();   
	
	String sql="select * from search where keyword like '"+ key + "%' order by searchtimes desc";
	
		  ResultSet   r=s.executeQuery(sql);   
		  
 
	
		out.println("<ul>");
		
		for(int i=0;i<=9;i++){
			if(r.next()){
			   out.println("<li value=\"" + i + "\" onclick=\"form_submit()\" onmouseover=\"mo(this.value)\">"+r.getString("keyword")+"<span class=\"suggestspan\">约"+r.getString("matchnum") + "结果</span></li>");
	        }else{ 
	         break;
		    }
		}
		out.println("</ul>");
		
		
		
	
		}catch(Exception e){  }

		






	
	

%>
