<%@ page language="java" import="java.util.*,com.zero.Config.Config" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>处理配置文件</title>
    
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
   <% String type=request.getParameter("ye");
      String num=request.getParameter("num");
      String zhushou=request.getParameter("zhushou");
      
       Config.pagetype=type; 
       Config.pagenum=Integer.parseInt(num);
      String zhu="";
      if(zhushou.equals("kaiqi")){
         Config.molin=true;
         zhu="小助手开启";
      }
      
      if(zhushou.equals("guanbi")){
        Config.molin=false;
         zhu="小助手关闭";
      }
      
      
       String txt="";
       if(type.equals("personality")){
          txt="个性化分页";
       }else{
          if(type.equals("default")){
            txt="普通分页";
          }
       }
       
    out.println("<script language=javascript>alert('     修改成功\\n当前设置为：  "+txt+"\\n每页结果数量："+Integer.parseInt(num)+"\\n"+zhu+"')");
	out.println("location.href='ShowType.jsp'</script>");
   
    %>
  </body>
</html>
