<%@page import="com.zero.Lucene.index.SearchHelper"%>
<%@page import="com.zero.Sql.suggestResult"%>
<%@page import="com.zero.NormallyAndChanging.Change"%>
<%@page import="com.zero.util.TitleChange"%>
<%@page import="com.zero.util.MaoPao"%>
<%@page import="com.zero.Rmi.IPlist"%>
<%@page import="com.zero.domainModel.Result"%>
<%@page import="com.zero.Rmi.FinalResult"%>
<%@page import="com.zero.Rmi.SearchMess"%>
<%@page import="com.zero.Sql.SearchPinYin"%>
<%@page import="com.zero.Config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

 String shushu=request.getParameter("jiansuo");
 String kind=request.getParameter("kind");
 String type=request.getParameter("type");          //设定检索方式
 String num=request.getParameter("num");            //设定每页显示的数量

int NUM=10; 
 if(type==null){
   type="every";
 }
if(num!=null){
NUM=Integer.parseInt(num);
Config.pagenum=Integer.parseInt(num);
}

String shuju=SearchPinYin.Search(shushu);
boolean PinYin=false;
  application.removeAttribute("ResultPinyin");
  application.setAttribute("ResultPinyin","false");
if(shushu==null||shushu.equals("")){
	    	                  out.println("<script language=javascript>");
	    		               out.println("location.href='MainIndex.jsp'</script>");
}

if(!shuju.equals(shushu)){
   PinYin=true;
   application.removeAttribute("ResultPinyin");
   application.setAttribute("ResultPinyin","true");
  
 }
 


 //hanzichuli chuchu=new hanzichuli();         //用于字符的转换
 
   //String shuju=chuchu.change(shushu);
  // String shuju=shushu;
 
   
   //分词模块
   
             List<String> TxtStr;
  
         TxtStr=SearchHelper.splitKeywords(shuju);
         
   for(int y=0;y<TxtStr.size();y++){
     System.out.println(TxtStr.get(y).toString());  //检测分词列表
     }
    //    SearchMess mess=new SearchMess(TxtStr);
   
   
      //记录检索开始时的时间
   double starting =System.currentTimeMillis();
   //执行检索...........................................
    
 
    SearchMess mess=new SearchMess(TxtStr,kind,type);
    
   FinalResult.setComputer(0);   //设置当前已经检索过的服务器数量
   System.out.println("数量清零");
  
       FinalResult.clearFresult();         //清空数据
   
    System.out.println("数据清空还有"+ FinalResult.getFresultsize());
   
    int iii=0; 
      int shu=0;
   
   Result jilu;
      
      // 当没有检索完的时候继续检索
      while(FinalResult.getComputerContent()!=IPlist.iplist.size()){
          
        }
        
  
   
         
   double Stay= (System.currentTimeMillis() - starting)/1000;
   String staytime=("运行时间："+ Stay +" 秒"); //staytime 为检索时间
        
        System.out.println("数据个数为：" + FinalResult.getFresultsize());
  
    //       QuickPaiXu paixu=new QuickPaiXu();
    //       paixu.quickSort(FinalResult.Fresult,0,FinalResult.Fresult.size()-1);
   MaoPao xu=new MaoPao();
    xu.Sort();
   
   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>搜索结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="css/result.css" rel="stylesheet" type="text/css">
<script src="js/page.js" type="text/javascript"></script>
<link href="css/Fenye.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  
 <form method="post" name="form1" action="result.jsp">
  <table align='center'><tr><td align='center'><img src='images/zero.jpg' onClick="javascript:window.location='MainIndex.jsp'" ></img></td>
  </tr>
  <tr>
  <td>
     <p>
     <p align="center"><input type="text" maxlength="100" size="50" name="jiansuo" id="jie">
	    <input type="submit" name="button2" value=" 搜  索 ">
	    <input name="" type="button" onClick="javascript:window.location='Search/Search.jsp'" value="高级搜索"/>
	 </p>
     
  </td>
  </tr>
    <tr>
    <td colspan="3">     
    <p align="center">
       <label>
       <input name="kind" type="radio" id="kind_0" value="all" checked>
         全部</label>

       <label>
       <input type="radio" name="kind" value="document" id="kind_1">
         文档</label>
    
       <label>
       <input type="radio" name="kind" value="video" id="kind_2">
         视频</label>
   
       <label>
       <input type="radio" name="kind" value="picture" id="kind_3">
         图片</label>
    
       <label>
       <input type="radio" name="kind" value="mp3" id="kind_4">
         MP3</label>
    
     </p></td>
    </tr>
  </table>
  </form>
  <table style="font-size:12px; " align="right" width="100%" height="30" border="0"
			cellspacing="0" bgcolor="#d0dff4" cellpadding="0">
			<tr>
				<td align="left">
					
						&nbsp;<%if(PinYin){out.println("您是不是要搜索");}else{out.println("您搜索的关键字是");} %>&nbsp;&nbsp;
						<b>
					 	<%     
						       String Txt="";
						    for(int shuliang=0;shuliang<TxtStr.size();shuliang++){
						        
						           Txt+=TxtStr.get(shuliang).toString()+" ";
						       out.println(TxtStr.get(shuliang).toString() + "&nbsp;");
						    }
						    application.removeAttribute("ResultTxt");
						    application.setAttribute("ResultTxt",Txt);
						 %>
						</b>
					
			  </td>
				<td align="right">
					
						已找到
						<label id="count1">
							<font color="red"> <%=FinalResult.getFresultsize()%>
							</font> 
						</label>条信息&nbsp;&nbsp;&nbsp;
						
						<b><%  application.removeAttribute("ResultTime");
						       application.setAttribute("ResultTime",staytime);
						       
						       
                             out.println(staytime);
                             %>
                        </b> &nbsp;
					
			  </td>
			</tr>
		</table>
 <p><br><br></p>   
 
<% if(Config.pagetype.equals("personality")){ %>
<div>
 <ul>
   <%  
      
  //   循环显示检索到的资源   
     for( iii=0;iii<FinalResult.getFresultsize();iii++){ 
         
          jilu=(Result)FinalResult.getFresult(iii);
          shu=iii % NUM;
     
     if((shu!=0) || (iii==0)){  %>
     
     
     
          <li>
            <table style="table-layout:fixed;">              
            
             <tr>
              <td class="title">
              
                <%=TitleChange.change(jilu.getTitle(),jilu.getKind(),Change.urlChange(jilu.getUrl())) %>
              
              </td>          
             </tr>
           
               	
               <tr>
			      <td class="describe">
				   &nbsp;&nbsp;&nbsp;<%=jilu.getDescribe() %>
                   </td>
               </tr>
                <tr>
			      <td class="date">&nbsp;&nbsp;&nbsp;发布时间：
				   <%=jilu.getDate() %>
                   </td>
               </tr>              
               <tr>
			      <td class="kind">&nbsp;&nbsp;&nbsp;文档类型：
				   <%=jilu.getKind() %>
                   </td>
               </tr>
               
               <tr>
			      <td class="publisher">&nbsp;&nbsp;&nbsp;发布单位：
				   <%=jilu.getPublisher() %>
                   </td>
               </tr> 
               
               <tr>
			      <td class="url">&nbsp;&nbsp;&nbsp;URL：
				   <%=jilu.getUrl() %>
                   </td>
               </tr>     
               
               <tr>
			      <td align="right" class="down">&nbsp;&nbsp;&nbsp;
				    <a href="<%=jilu.getUrl() %>"><span class="downa">点击下载</span></a>
                  </td>
               </tr>
               
            </table>
           </li>
          
          
          
        <%  }else{  %>
        </ul>
                     </div>
                     <div>
                     <ul>
                          
          <li>
            <table style="table-layout:fixed;">              
        
              <tr>
              <td class="title">
              
             <%=TitleChange.change(jilu.getTitle(),jilu.getKind(),Change.urlChange(jilu.getUrl())) %>
             
              </td>
              
              </tr>
                   

               	
               <tr>
			      <td class="describe">
				   &nbsp;&nbsp;&nbsp;<%=jilu.getDescribe() %>
                   </td>
               </tr>
                <tr>
			      <td class="date">&nbsp;&nbsp;&nbsp;发布时间：
				   <%=jilu.getDate() %>
                   </td>
               </tr>              
               <tr>
			      <td class="kind">&nbsp;&nbsp;&nbsp;文档类型：
				   <%=jilu.getKind() %>
                   </td>
               </tr>
               
               <tr>
			      <td class="publisher">&nbsp;&nbsp;&nbsp;发布单位：
				   <%=jilu.getPublisher() %>
                   </td>
               </tr> 
               
               <tr>
			      <td class="url">&nbsp;&nbsp;&nbsp;URL：
				   <%=jilu.getUrl() %>
                   </td>
               </tr>     
               
               <tr>
			      <td align="right" class="down">&nbsp;&nbsp;&nbsp;
				    <a href="<%=jilu.getUrl() %>"><span class="downa">点击下载</span></a>
                  </td>
               </tr>
               
            </table>
           </li>
           
           
       <%  }
	   
	   }  if(shu!=NUM){
	       for(int y=1;y<NUM-shu;y++){    %>
		     <li>
             <table>              
        
              <tr>
              <td class="title">
                   &nbsp; &nbsp;
              </td>  
              </tr>
               <tr>
			      <td class="describe">
				   &nbsp;&nbsp;
                   </td>
               </tr>
                <tr>
			      <td class="date">&nbsp;&nbsp;
                   </td>
               </tr>              
               <tr>
			      <td class="kind">&nbsp;&nbsp;
                   </td>
               </tr>
               
               <tr>
			      <td class="publisher">&nbsp;&nbsp;
                   </td>
               </tr> 
               
               <tr>
			      <td class="url">&nbsp;&nbsp;
                   </td>
               </tr>     
               
               <tr>
			      <td class="down">&nbsp;&nbsp;&nbsp;

                  </td>
               </tr>
               
            </table>
             </li> 
		<%	  }     
	       }
	    %>

 </ul>
</div>
<%
}else{
	
      out.println("<script language=javascript>");						
out.println("location.href='DefaultResult.jsp'</script>");
}
%>
<% suggestResult suggest=new suggestResult(shushu,FinalResult.getFresultsize());
       suggest.start();

 %>
  </body>
</html>
