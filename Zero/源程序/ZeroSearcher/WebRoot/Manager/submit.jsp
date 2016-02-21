<%@page import="com.zero.xml.ForDeleteSearch"%>
<%@page import="com.zero.util.UtilClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.dom4j.*" %>
<%@ page import="org.dom4j.io.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>资源管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/table.css" rel="stylesheet" type="text/css">
<script language="JavaScript">
function checkCount(itemName){ 
  var aa = document.getElementsByName(itemName); 
  var sum=0; 
  //计算复选框选中个数
  for (var i=0; i <aa.length; i++){ 
    if(aa[i].checked) sum=sum+1; 
  } 
  return sum; 
} 
//确认是否要删除选中的资源
function test(itemName){ 
  if(checkCount(itemName)!=0){ 
      if(!confirm("确定要删除吗？")){ 
        return false; 
        } 
  } 
  else{ 
      //如果没有选择要删除的资源，则提示用户选择要删除的资源
      alert("请选择要删除的资源！"); 
      return false; 
      } 
} 

</script>

  </head>
  
  
  
  <body>
  <div style="position:absolute;"><strong style="font-size:12px">当前操作:<%=UtilClass.getHostip() %></strong></div>
   <html:form action="delete" method="post" focus="login">
    <div style="position:absolute; width:100%; height:90%; overflow:scroll; ">
   		<div id=divone class="scollercss" align="center">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td>
							<fieldset align="center">
								<legend>
									资源列表
								</legend>

								<table id="mytable" cellspacing="0"
									summary="The technical specifications of the Apple PowerMac G5 series">
									<caption>
									</caption>
									<tr>
										<th scope="col" abbr="Configurations">
											文件名：
										</th>
										<th scope="col" abbr="Dual 1.8">
											描述信息：
										</th>
										<th scope="col" abbr="riqi">
											发布作者：
										</th>
									</tr>
        <% 	ForDeleteSearch dizhi=new ForDeleteSearch();
          
      	         String tomcat=UtilClass.getPath("webapps");       
                  String filepath= tomcat+"\\"+"test.xml";

    	             SAXReader reader = new SAXReader(); 
	               	Document document = null;
	        	try {
			           document = reader.read("file:\\"+filepath);
		          } catch (DocumentException e) {
		            	e.printStackTrace();
	                	} 

		Element root = document.getRootElement(); 
		Element foo = null; 

		Iterator<?>  it = root.elementIterator("resourceitem"); 
		
			     String id;
		         String title;
		         String describe;
		         String date;
                 String url;
		
		while (it.hasNext()) { 	
			
			foo =  (Element) it.next(); 
			 id=foo.elementText("id");
			 title=foo.elementText("title");
			 describe=foo.elementText("describe");
			 date=foo.elementText("date");
			 url=foo.elementText("url");
		%>


									<tr >
										<th scope="row" abbr="Frontside bus" class="spec">
											 <input type="checkbox" name="deleteName" value="<%=url %>"><%=title %>						
										</th>
										<td class="alt">
											<%=describe %>
										</td>
										<td class="date">
											<%=date %>
										</td>
									</tr>
  <%} %>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</div>
			
	</div>		
			<div id=divtwo style="position:absolute;  top:90%; left:33%; ">
				<table>
					<tr align="center">
						<td height="50">
							<input type=submit value="  删   除  " class="btn3_mouseout" >
						</td>
					</tr>
				</table>
			</div>
			
				
       </html:form>
       
       
  </body>
</html:html>
   
   

