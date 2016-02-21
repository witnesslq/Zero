<%@page import="com.zero.util.UtilClass"%>
<%@page import="com.zero.Rmi.Del"%>
<%@page import="com.zero.Rmi.IPlist"%>
<%@page import="com.zero.Servers.RmiServer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.rmi.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ChuliList.jsp' starting page</title>
    
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
    <% String mingling=request.getParameter("mingling");
       String ip=request.getParameter("ip");
      
       if(mingling.equals("addres")){
         try{
            RmiServer fa=(RmiServer) Naming.lookup("rmi://" + ip + "/Ser");
	        String realpath=fa.getPath()+"/Manager/fileAdd.jsp";
	     	out.println("<script language=javascript>window.location='http://" +ip+":8080/" + realpath + "'</script>");
	       }catch(Exception e){
	            out.println("<script language=javascript>alert('服务器已断开连接');");
	    		out.println("location.href='../../fileAdd.jsp'</script>");
	    	    }                   
        
        }else{ if(mingling.equals("list")){
                  try{
                	  RmiServer fa=(RmiServer) Naming.lookup("rmi://" + ip + "/Ser");
	                 String realpath=fa.getPath()+"/Manager/submit.jsp";
	                 out.println("<script language=javascript>window.location='http://" +ip+":8080/" + realpath + "'</script>");
	               }catch(Exception e){
	                   out.println("<script language=javascript>alert('服务器已断开连接');");
	    		        out.println("location.href='../../Manager/submit.jsp'</script>");
	    	       }
                
               }else{ if(mingling.equals("delip")){
                      IPlist.iplist.remove(ip);
                    	  for(int y=0;y<IPlist.iplist.size();y++){
		      	              if(!(IPlist.iplist.get(y).toString().equals(UtilClass.getHostip()))){
                                  Del del=new Del(IPlist.iplist.get(y).toString(),ip);
                                     del.start();
                                }
	                         }
	                   out.println("<script language=javascript>alert('已断开与"+ip+"的连接');</script>");
                      }
                }      
         }

     %>
  </body>
</html>
