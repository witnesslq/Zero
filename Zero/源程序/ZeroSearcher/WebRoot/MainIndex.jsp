<%@ page language="java" import="java.util.*,com.zero.Config.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ZeroSearcher</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link href="css/ico.css" rel="stylesheet" type="text/css">
  <script language="javascript" src="js/guanggao.js"></script>
<style type="text/css">
body {
	background-repeat: no-repeat;
}
a{direction:none;
}


</style>
    <link href="css/ico.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="js/guanggao.js"></script>
	<link type="text/css" rel="stylesheet" href="css/suggest.css"/>
	<script type="text/javascript" src="js/suggest.js"></script>

  </head>
  
<body onclick="hide_suggest();">
 <a  href="BOSS/OA.jsp" >系统后台登陆</a><br><br>
<form method="post" name="form1" action="result.jsp" autocomplete="off">
<table  border="0" align="center">
  <tr>
    
    <td colspan="2" align="left">
    
      <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><img src="images/zero.jpg" width="350" height="150">
    
    </td>
    
  </tr>
  <tr>
    <td height="50" >
 
  
 
     <p align="right">
     
 
     <input type="text" maxlength="100" size="40" name="jiansuo" id="jiansuo" onkeyup="keyupdeal(event);" onkeydown="keydowndeal(event);" onclick="keyupdeal(event);" style="width: 322px; ">
     
     </p>
     
     <div style="position:absolute; z-index:100; background-color:#FFFFFF; " id="suggest"></div>

     </td><td align="left" width="37%">

 
 
	    <input type="submit" name="button2" value="搜索">
	    <input name="" type="button" onClick="javascript:window.location='Search/Search.jsp'" value="精确搜索"/>
	 </td>
  </tr>
  <tr>
    <td>     
    <p align="right">
       
       <input name="kind" type="radio" id="kind_0" value="all" checked>全部
       <input type="radio" name="kind" value="document" id="kind_1">文档
       <input type="radio" name="kind" value="video" id="kind_2">视频
       <input type="radio" name="kind" value="picture" id="kind_3">图片
       <input type="radio" name="kind" value="mp3" id="kind_4">MP3
    
     </p></td>
     <td>
     </td>
    </tr>
</table>
</form>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<table align="center" ><tr><td align="center">

	<P style="HEIGHT: 30px top:50px">
		<a onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('<%=basePath%>')" 
			href="<%=basePath%>">把Zero设为主页</a>丨 
        <a href="aboutZero.jsp">关于Zero</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        
     </P>
	<hr color="#999999" width="800px" size="1px"/><br />
    欢迎使用ZeroSearcher<br />版权所有: Zero 开发团队
	

</td>
</tr>
</table>
</body>
</html>




<SCRIPT>    

function crml(nid)    

{    

try    

{    

nid=new ActiveXObject("Agent.Control.2");    

nid.Connected = true;    

nid.Characters.Load("");    

return nid;    

}    

catch (err)    

{    

return false;    

}    

}    

function chplay ()    

{    

if (ml=crml ("ml"))    

{    

var MerlinID;    

var MerlinACS;    

Merlin = ml.Characters.Character(MerlinID);    

Merlin.MoveTo(200,200);   

Merlin.Show();    

Merlin.Play("Explain");    

Merlin.Play("Announce");    

Merlin.Speak("Zero 全组成员欢迎您的到来");    

Merlin.Play("Gestureright");    

Merlin.Play("Pleased");   

Merlin.Speak("在这里我们会尽力为您提供最实用的搜索");    

Merlin.Play("Idle1_1");   

Merlin.Hide();   

Merlin.MoveTo(600,300);   

Merlin.Show();   

Merlin.Play("Surprised");    

Merlin.Play("Read");     

Merlin.Speak("如需帮助的时候我再来找你");   
Merlin.Play("Gestureright");
Merlin.Speak("我先回去睡会儿觉，再见！！");
Merlin.Play("Gestureright");
Merlin.Play("Greet");   

Merlin.Hide();    

}    

}    
 
<%if(Config.molin){%>
  chplay()  
<% }%> 
 

</SCRIPT>   


<% if(Config.TanGuangGao){ %>

<script language="javascript" >
<% String s=Config.GuangGao.replace("\"","\\\""); %>

ss="<%=s %>";
popmsg(ss);

</script> 

<% } %>





