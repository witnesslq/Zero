<%@page import="com.zero.util.MaoPao"%>
<%@page import="com.zero.Rmi.IPlist"%>
<%@page import="com.zero.Rmi.SearchMess"%>
<%@page import="com.zero.Lucene.index.SearchHelper"%>
<%@page import="com.zero.Sql.SearchPinYin"%>
<%@page import="com.zero.NormallyAndChanging.Change"%>
<%@page import="com.zero.util.TitleChange"%>
<%@page import="com.zero.Rmi.FinalResult"%>
<%@page import="com.zero.Config.Config"%>
<%@page import="com.zero.domainModel.Result"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int nowPageNum=0;    //当前页号
int onePageCount=Config.pagenum;    //每页记录数
int allRecordCount=FinalResult.getFresultsize();//总记录数
int allPageCount=0;       //总页数
int nowFirst=0;          //当前首记录
int nowLast=0;            //当前尾记录
//得到总页数
allPageCount=allRecordCount/onePageCount;
if((allRecordCount%onePageCount) > 0){
       allPageCount++;
}
//得到当前记录范围
if(request.getParameter("nowPageNum") != null){
nowFirst=(int)((allRecordCount*Integer.parseInt((String)request.getParameter("nowPageNum"))/allPageCount));
nowPageNum=Integer.parseInt((String)request.getParameter("nowPageNum"));
}
nowLast=nowFirst+onePageCount-1;
if(nowLast>=FinalResult.getFresultsize()){
nowLast=FinalResult.getFresultsize()-1;
}

/*String shushu=request.getParameter("jiansuo");
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
if(shuju.equals(shushu)){  
}else{
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
   xu.Sort();*/


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>	
	span{font-weight:bold;color:#ff9955;}
	body{color:#000;background:#fff;padding:6px 0 0;margin:0;position:relative}
	body,th,td,.p1,.p2{font-family:arial}
	p,form,ol,ul,li,dl,dt,dd,h3{margin:0;padding:0;list-style:none}
	input{padding-top:0;padding-bottom:0;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box}
	table,img{border:0}td{font-size:9pt;line-height:18px}em{font-style:normal;color:#cc0000}a em{text-decoration:underline}cite{font-style:normal;color:#008000}.m,a.m{color:#666}a.m:visited{color:#606}.g,a.g{color:#008000}.c{color:#77c}
	.f14{font-size:14px}.f10{font-size:10.5pt}.f16{font-size:16px}.f13{font-size:13px}#u,#head,#tool,#search,#foot{font-size:12px}.p1{line-height:120%;margin-left:-12pt}.p2{width:100%;line-height:120%;margin-left:-12pt}
	#out{_margin-left:880px;_zoom:1}#in{_position:relative;_float:left;_margin-left:-880px}#wrapper{min-width:880px;_zoom:1}#container{padding-left:20px}
	.container_s{width:967px}.container_l{width:1187px}#content_left{width:636px;float:left}#content_right{border-left:1px solid #e1e1e1;float:right}
	.container_s #content_right{width:281px}.container_l #content_right{width:451px}#u{color:#999;white-space:nowrap;position:absolute;right:10px;top:4px;_top:0;z-index:299}
	#u a{color:#00c;margin:0 5px}#u .reg{margin:0}#u .last{margin-right:0}
	#u .un{font-weight:bold;padding-right:11px;margin-right:5px;background:url("images/put.png") no-repeat right -195px}#u ul{width:100%;background:#fff;border:1px solid #9b9b9b}#u li{height:25px}#u li a{width:100%;height:25px;line-height:25px;display:block;text-align:left;text-decoration:none;text-indent:6px;margin:0;filter:none\9}
	#u li a:hover{background:#ebebeb}#u li.nl{border-top:1px solid #ebebeb}#user{position:relative;display:inline-block}
	#user_center{position:relative;display:inline-block}#user_center .user_center_btn{padding-right:11px;margin-right:5px;background:url("images/put.png") no-repeat right -195px}.userMenu{width:64px;position:absolute;right:7px;_right:2px;top:15px;top:14px\9;*top:15px;padding-top:4px;display:none;*background:#fff}#head{padding-left:20px;margin-bottom:20px}.fm{clear:both;position:relative;z-index:297}.nv a,.nv b,.btn,#page,#more{font-size:14px}.s_nav{height:45px}.s_nav .s_logo{margin-right:20px;float:left}.s_nav .s_logo img{border:0;display:block}.s_tab{line-height:18px;padding:20px 0 0;float:left}.s_nav a{color:#0000cc;font-size:14px}.s_nav b{font-size:14px}.s_ipt_wr{width:536px;height:30px;display:inline-block;margin-right:5px;background:url(/img/i-1.0.0.png) no-repeat -304px 0;border:1px solid #b6b6b6;border-color:#7b7b7b #b6b6b6 #b6b6b6 #7b7b7b;vertical-align:top}.s_ipt{width:523px;height:22px;font:16px/22px arial;margin:5px 0 0 7px;padding:0;background:#fff;border:0;outline:0;-webkit-appearance:none}.s_btn{width:95px;height:32px;padding-top:2px\9;font-size:14px;padding:0;background:#ddd url(/img/i-1.0.0.png);border:0;cursor:pointer}.s_btn_h{background-position:-100px 0}.s_btn_wr{width:97px;height:34px;display:inline-block;background:url(/img/i-1.0.0.png) no-repeat -202px 0;*position:relative;z-index:0;vertical-align:top}.sethf{padding:0;margin:0;font-size:14px}.set_h{display:none;behavior:url(#default#homepage)}.set_f{display:none}.shouji{margin-left:19px}#tb_mr{color:#00c;cursor:pointer;position:relative;z-index:298}#tb_mr b{font-weight:normal;text-decoration:underline}#tb_mr small{font-size:11px}#page{font:14px simsun;white-space:nowrap}#page a,#page strong{display:inline-block;vertical-align:text-bottom;height:54px;text-align:center;line-height:22px;text-decoration:none;overflow:hidden;margin-right:5px;background:white}#page a{cursor:pointer}#page a:hover{background:0}#page .n:hover,#page a:hover .pc{background:#ebebeb}#page .n{height:22px;padding:0 6px;border:1px solid #e7ecf0}#page span{display:block}#page .pc{width:22px;height:22px;border:1px solid #e7ecf0;cursor:pointer}
	#page .fk{width:24px;height:30px;background:url("images/put.png") -35px -309px no-repeat;cursor:pointer}#page strong .fk,#page strong .pc{cursor:auto}#page .fkd{background-position:-35px -303px}#page .fk_cur{background-position:2px -312px}#page strong .pc{border:0;width:24px;height:24px;line-height:24px}#page .nums{display:inline-block;vertical-align:text-bottom}#rs{width:100%;background:#fff;padding:8px 0;margin:20px 0 0}#rs td{width:5%}#rs th{font-size:14px;font-weight:normal;line-height:19px;white-space:nowrap;text-align:left;vertical-align:top}#rs .tt{font-weight:bold;padding:0 10px 0 20px}#rs_top{font-size:14px;margin-bottom:22px}#rs_top a{margin-right:18px}#search{padding:35px 0 16px 20px}#search .s_help{position:relative;top:10px}#foot{height:20px;line-height:20px;color:#77c;background:#e6e6e6;text-align:center}#foot span{color:#666}.site_tip{font-size:13px;line-height:18px;padding:3px 0 5px 72px;margin-bottom:20px;background:url(/img/bg-1.0.0.gif) no-repeat}.to_zhidao,.to_tieba{font-size:16px;line-height:24px;margin:20px 0 0;padding:0 0 0 32px;background:url(/img/bg-1.0.0.gif) no-repeat 0 -68px}.to_tieba{background-position:0 -102px}.f{line-height:115%;*line-height:120%;font-size:100%;width:33.7em;word-break:break-all;word-wrap:break-word}.h{margin-left:8px;width:100%}.r{word-break:break-all;cursor:hand;width:238px}.t{font-weight:normal;font-size:medium;margin-bottom:1px}.pl{padding-left:3px;height:8px;padding-right:2px;font-size:14px}.mo,a.mo:link,a.mo:visited{color:#666;font-size:100%;line-height:10px}.htb{margin-bottom:5px}.jc a{color:#cc0000}a font[size="3"] font,font[size="3"] a font{text-decoration:underline}div.blog,div.bbs{color:#707070;padding-top:2px;font-size:13px}.result{width:33.7em;table-layout:fixed}.result-op .f{word-wrap:normal}.nums{font-size:12px;color:#999}.tools{width:230px;position:absolute;top:10px;white-space:nowrap}#mHolder{width:62px;position:relative;z-index:296;top:-18px;margin-left:9px;margin-right:-12px;display:none}#mCon{height:18px;position:absolute;right:7px;top:3px;top:6px\9;cursor:pointer;padding:0 18px 0 0;line-height:18px;background:url(/img/bg-1.0.0.gif) no-repeat right -133px;background-position:right -135px\9}#mCon span{color:#00c;cursor:default;display:block}#mCon .hw{text-decoration:underline;cursor:pointer}#mMenu{width:56px;border:1px solid #9b9b9b;position:absolute;right:7px;top:23px;display:none;background:#fff}#mMenu a{width:100%;height:100%;color:#00c;display:block;line-height:22px;text-indent:6px;text-decoration:none;filter:none\9}#mMenu a:hover{background:#ebebeb}#mMenu .ln{height:1px;background:#ebebeb;overflow:hidden;font-size:1px;line-height:1px;margin-top:-1px}.op_LAMP{background:url("/cache/global/img/aladdinIcon-1.0.gif") no-repeat 0 2px;color:#77C;display:inline-block;font-size:13px;height:12px;*height:14px;width:16px;text-decoration:none;zoom:1}.EC_mr15{margin-left:0}.pd15{padding-left:0}.map_1{width:30em;font-size:80%;line-height:145%}.map_2{width:25em;font-size:80%;line-height:145%}.favurl{background-repeat:no-repeat;background-position:0 1px;padding-left:20px}.dan_tip{font-size:12px;margin-top:4px}.unsafe_txttip_o{cursor:pointer;display:inline-block;margin-right:4px;height:18px;line-height:16px;*line-height:19px;font-size:12px;color:#e10602;background:url('images/put.png') no-repeat left -762px;padding-left:18px;width:31px}.dan_tip a{color:#b95b07}#more,#u ul,#mMenu,.msg_holder{box-shadow:1px 1px 2px #ccc;-moz-box-shadow:1px 1px 2px #ccc;-webkit-box-shadow:1px 1px 2px #ccc;filter:progid:DXImageTransform.Microsoft.Shadow(Strength=2,Direction=135,Color="#cccccc")\9}.hit_top{line-height:18px;margin:0 15px 10px 0;width:516px}.hit_top .c-icon-bear{height:18px;margin-right:4px}.hit_top_01{background:0;padding-left:0;*line-height:20px;width:33.7em}.hit_top_01 i{display:inline-block;background:url("images/put.png") no-repeat left -446px;width:16px;height:16px;vertical-align:-3px;margin-right:3px;*vertical-align:1px;_vertical-align:2px}.f a font[size="3"] font,.f font[size="-1"] a font{text-decoration:underline}h3 a font{text-decoration:underline}.c-title{font-weight:normal;font-size:16px}.c-title-size{font-size:16px}.c-abstract{font-size:13px}.c-abstract-size{font-size:13px}.c-showurl{color:#008000;font-size:13px}.c-showurl-color{color:#008000}.c-cache-color{color:#666}.c-lightblue{color:#77C}.c-highlight-color{color:#C00}.c-clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden}.c-clearfix{zoom:1}.c-wrap{word-break:break-all;word-wrap:break-word}.c-frame{margin-bottom:18px}.c-container table.result,.c-container table.result-op{width:100%}.c-container td.f{font-size:13px;line-height:1.54;width:auto}.c-container .vd_newest_main{width:auto}.c-offset{padding-left:10px}.c-gap-top-small{margin-top:5px}.c-gap-top{margin-top:10px}.c-gap-bottom-small{margin-bottom:5px}.c-gap-bottom{margin-bottom:10px}.c-gap-right{margin-right:17px}.c-gap-right-small{margin-right:8.5px}.c-container{width:540px;font-size:13px;line-height:1.54}.c-container .c-container{width:auto}.c-default{font-size:13px;line-height:1.54}.c-row{*zoom:1}.c-row:after{display:block;height:0;content:"";clear:both}.c-span2{width:29px}.c-span3{width:52px}.c-span4{width:75px}.c-span5{width:98px}.c-span6{width:121px}.c-span7{width:144px}.c-span8{width:167px}.c-span9{width:190px}.c-span10{width:213px}.c-span11{width:236px}.c-span12{width:259px}.c-span13{width:282px}.c-span14{width:305px}.c-span15{width:328px}.c-span16{width:351px}.c-span17{width:374px}.c-span18{width:397px}.c-span19{width:420px}.c-span20{width:443px}.c-span21{width:466px}.c-span22{width:489px}.c-span23{width:512px}.c-span24{width:535px}.c-span2,.c-span3,.c-span4,.c-span5,.c-span6,.c-span7,.c-span8,.c-span9,.c-span10,.c-span11,.c-span12,.c-span13,.c-span14,.c-span15,.c-span16,.c-span17,.c-span18,.c-span19,.c-span20,.c-span21,.c-span22,.c-span23,.c-span24{float:left;_display:inline;margin-right:17px;list-style:none}.c-span-last{margin-right:0}.c-border{width:518px;padding:9px;border:1px solid #e3e3e3;border-bottom-color:#e0e0e0;border-right-color:#ececec;box-shadow:1px 2px 1px rgba(0,0,0,0.072);-webkit-box-shadow:1px 2px 1px rgba(0,0,0,0.072);-moz-box-shadow:1px 2px 1px rgba(0,0,0,0.072);-o-box-shadow:1px 2px 1px rgba(0,0,0,0.072)}.c-border .c-gap-right{margin-right:10px}.c-border .c-gap-right-small{margin-right:5px}.c-border .c-border{width:auto;padding:0;border:0;box-shadow:none;-webkit-box-shadow:none;-moz-box-shadow:none;-o-box-shadow:none}.c-border .c-span2{width:34px}.c-border .c-span3{width:56px}.c-border .c-span4{width:78px}.c-border .c-span5{width:100px}.c-border .c-span6{width:122px}.c-border.c-span7{width:144px}.c-border .c-span8{width:166px}.c-border .c-span9{width:188px}.c-border .c-span10{width:210px}.c-border .c-span11{width:232px}.c-border .c-span12{width:254px}.c-border .c-span13{width:276px}.c-border .c-span14{width:298px}.c-border .c-span15{width:320px}.c-border .c-span16{width:342px}.c-border .c-span17{width:364px}.c-border .c-span18{width:386px}.c-border .c-span19{width:408px}.c-border .c-span20{width:430px}.c-border .c-span21{width:452px}.c-border .c-span22{width:474px}.c-border .c-span23{width:496px}.c-border .c-span24{width:518px}.c-border .c-span2,.c-border .c-span3,.c-border .c-span4,.c-border .c-span5,.c-border .c-span6,.c-border .c-span7,.c-border .c-span8,.c-border .c-span9,.c-border .c-span10,.c-border .c-span11,.c-border .c-span12,.c-border .c-span13,.c-border .c-span14,.c-border .c-span15,.c-border .c-span16,.c-border .c-span17,.c-border .c-span18,.c-border .c-span19,.c-border .c-span20,.c-border .c-span21,.c-border .c-span22,.c-border .c-span23,.c-border .c-span24{margin-right:10px}.c-border .c-span-last{margin-right:0}.c-icon{display:inline-block;width:14px;height:14px;vertical-align:text-bottom;font-style:normal;overflow:hidden;background:url(http://s1.bdstatic.com/r/www/cache/static/global/img/icons_5957d4ca.png) no-repeat 0 0;_background-image:url(http://s1.bdstatic.com/r/www/cache/static/global/img/icons_6dea628c.gif)}.c-icon-unfold,.c-icon-fold,.c-icon-chevron-unfold,.c-icon-chevron-fold{width:12px;height:12px}.c-icon-star,.c-icon-star-gray{width:59px}.c-icon-qa-empty,.c-icon-safeguard,.c-icon-register-empty,.c-icon-download,.c-icon-lyric,.c-icon-zan,.c-icon-share .c-icon,.c-icon-location,.c-icon-warning,.c-icon-doc,.c-icon-xls,.c-icon-ppt,.c-icon-pdf,.c-icon-txt,.c-icon-play-black,.c-icon-bear{width:16px;height:16px}.c-icon-play-circle,.c-icon-stop-circle{width:18px;height:18px}.c-icon-tieba,.c-icon-zhidao{width:24px;height:24px}.c-icon-ball-blue,.c-icon-ball-red,.c-icon-envelope,.c-icon-camera,.c-icon-note,.c-icon-ok,.c-icon-other,.c-icon-clock,.c-icon-play-black-large,.c-icon-stop-black-large{width:38px;height:38px}.c-icon-unfold,.c-icon-fold,.c-icon-chevron-unfold,.c-icon-chevron-fold,.c-icon-v,.c-icon-hui,.c-icon-bao,.c-icon-phone,.c-icon-download,.c-icon-lyric{border:1px solid #d8d8d8;cursor:pointer}.c-icon-unfold:hover,.c-icon-fold:hover,.c-icon-chevron-unfold:hover,.c-icon-chevron-fold:hover,.c-icon-v:hover,.c-icon-hui:hover,.c-icon-bao:hover,.c-icon-phone:hover,.c-icon-download:hover,.c-icon-lyric:hover{border-color:#388bff}.c-icon-unfold:active,.c-icon-fold:active,.c-icon-chevron-unfold:active,.c-icon-chevron-fold:active,.c-icon-v:active,.c-icon-hui:active,.c-icon-bao:active,.c-icon-phone:active,.c-icon-download:active,.c-icon-lyric:active{border-color:#a2a6ab;background-color:#f0f0f0;box-shadow:inset 1px 1px 1px #c7c7c7;-webkit-box-shadow:inset 1px 1px 1px #c7c7c7;-moz-box-shadow:inset 1px 1px 1px #c7c7c7;-o-box-shadow:inset 1px 1px 1px #c7c7c7}.c-icon-flag{background-position:0 0}.c-icon-bus{background-position:-24px 0}.c-icon-calendar{background-position:-48px 0}.c-icon-street{background-position:-72px 0}.c-icon-map{background-position:-96px 0}.c-icon-bag{background-position:-120px 0}.c-icon-money{background-position:-144px 0}.c-icon-game{background-position:-168px 0}.c-icon-user{background-position:-192px 0}.c-icon-globe{background-position:-216px 0}.c-icon-lock{background-position:-240px 0}.c-icon-plane{background-position:-264px 0}.c-icon-list{background-position:-288px 0}.c-icon-star-gray{background-position:-312px 0}.c-icon-circle-gray{background-position:-384px 0}.c-icon-fullscreen{background-position:0 -24px}.c-icon-safe{background-position:-24px -24px}.c-icon-exchange{background-position:-48px -24px}.c-icon-chevron-bottom{background-position:-72px -24px}.c-icon-chevron-top{background-position:-96px -24px}.c-icon-unfold{background-position:-120px -24px}.c-icon-fold{background-position:-144px -24px}.c-icon-chevron-unfold{background-position:-168px -24px}.c-icon-qa{background-position:-192px -24px}.c-icon-register{background-position:-216px -24px}.c-icon-star{background-position:-240px -24px}.c-icon-star-gray{position:relative}.c-icon-star-gray .c-icon-star{position:absolute;top:0;left:0}.c-icon-play-blue{background-position:-312px -24px}.c-icon-pic{width:16px;background-position:-336px -24px}.c-icon-chevron-fold{background-position:-360px -24px}.c-icon-video{width:18px;background-position:-384px -24px}.c-icon-circle-blue{background-position:-408px -24px}.c-icon-circle-yellow{background-position:-432px -24px}.c-icon-v{background-position:0 -48px}.c-icon-hui{background-position:-24px -48px}.c-icon-bao{background-position:-48px -48px}.c-icon-phone{background-position:-72px -48px}.c-icon-qa-empty{background-position:-96px -48px}.c-icon-safeguard{background-position:-120px -48px}.c-icon-register-empty{background-position:-144px -48px}.c-icon-zan{background-position:-168px -48px}.c-icon-share{display:inline-block;position:relative;height:12px;line-height:12px;font-size:12px;padding:1px 5px 1px 27px;width:auto;color:#1cb7fd;background-color:#fff;border:1px solid #b3e1ff;vertical-align:text-bottom}.c-icon-share .c-icon{position:absolute;top:-1px;left:-1px;width:23px;background-position:-192px -48px}.c-icon-location{background-position:-240px -48px}.c-icon-warning{background-position:-264px -48px}.c-icon-doc{background-position:-288px -48px}.c-icon-xls{background-position:-312px -48px}.c-icon-ppt{background-position:-336px -48px}.c-icon-pdf{background-position:-360px -48px}.c-icon-txt{background-position:-384px -48px}.c-icon-play-black{background-position:-408px -48px}.c-icon-play-black:hover{background-position:-432px -48px}.c-icon-bear{background-position:-456px -48px}.c-icon-download{background-position:0 -72px}.c-icon-lyric{background-position:-24px -72px}.c-icon-play-circle{background-position:-48px -72px}.c-icon-play-circle:hover{background-position:-72px -72px}.c-icon-stop-circle{background-position:-96px -72px}.c-icon-stop-circle:hover{background-position:-120px -72px}.c-icon-ball-red{background-position:0 -96px}.c-icon-ball-blue{background-position:-48px -96px}.c-icon-envelope{background-position:-96px -96px}.c-icon-camera{background-position:-144px -96px}.c-icon-note{background-position:-192px -96px}.c-icon-ok{background-position:-240px -96px}.c-icon-other{background-position:-288px -96px}.c-icon-clock{background-position:-336px -96px}.c-icon-play-black-large{background-position:-384px -96px}.c-icon-play-black-large:hover{background-position:-432px -96px}.c-icon-stop-black-large{background-position:-480px -96px}.c-icon-stop-black-large:hover{background-position:-528px -96px}.c-icon-tieba{background-position:0 -144px}.c-icon-zhidao{background-position:-48px -144px}.icp_info{color:#666;margin-top:2px;font-size:13px}.icp_info span{width:11px;height:13px;display:inline-block;background:url('images/put.png') -28px -223px;margin-right:5px;vertical-align:-2px;*vertical-align:2px}.icon-gw,.icon-unsafe-icon{background:#2c99ff;vertical-align:text-bottom;height:16px;padding-top:0;padding-bottom:0;padding-left:6px;padding-right:6px;line-height:16px;_padding-top:2px;_height:14px;_line-height:14px;font-size:12px;font-family:simsun;margin-left:10px;overflow:hidden;display:inline-block;-moz-border-radius:1px;-webkit-border-radius:1px;border-radius:1px;color:#fff}.icon-unsafe-icon{background:#e54d4b}.icon-abstract-front{height:16px;color:#fff;font-size:12px;text-align:center;line-height:16px;*line-height:17px;padding:0 3px 0 6px;*padding:0 5px 0 6px;letter-spacing:2px;display:inline-block;margin-right:4px;background:#66ceff;vertical-align:text-bottom;overflow:hidden}#con-at{margin-bottom:15px}#con-ar{padding-left:10px;margin-bottom:40px}#con-at .result-op{margin-bottom:15px;font-size:13px;line-height:1.52em}#con-ar .result-op{margin-bottom:28px;font-size:13px;line-height:1.52em}#content_left .result-op,#content_left .result{margin-bottom:18px;border-collapse:collapse}#content_left .result .f,#content_left .result-op .f{padding:0}</style>
 	<link href="css/result.css" rel="stylesheet" type="text/css">
 	<link type="text/css" rel="stylesheet" href="css/suggest.css"/>
	<script type="text/javascript" src="js/suggest.js"></script>
 </head>
  <body link="#0000cc" onclick="hide_suggest();">
  <!-- <form method="post" name="form1" action="result.jsp" autocomplete="off" > -->
  <form method="post" name="form1" action="result.jsp" autocomplete="off" >
  <div id="out">
  <div id="in">
  <div id="wrapper">
  <div id="head">
  
  <a href="index.jsp" class="s_logo" onmousedown="return c({'fm':'tab','tab':'logo'})">
  <img src="images/zeroback.jpg" width="250" height="38" border="0" alt="到ZeroSearcher首页" title="到ZeroSearcher首页"></a>
       <label><input name="kind" type="radio" id="kind_0" value="all" checked> 全部</label>
       <label><input name="kind" type="radio" value="document" id="kind_1">文档</label>
       <label><input name="kind" type="radio" value="video" id="kind_2">视频</label>
       <label><input name="kind" type="radio" value="picture" id="kind_3">图片</label>
       <label><input name="kind" type="radio" value="mp3" id="kind_4">mp3</label>
       <br><div style="position:absolute; margin-top:23px; z-index:10; background-color:#FFFFFF; " id="suggest"></div> 
     <input type="text" maxlength="100" size="80" name="jiansuo" id="jiansuo" onkeyup="keyupdeal(event);" onkeydown="keydowndeal(event);" onclick="keyupdeal(event);" style="width: 323px; ">
      
	    <input type="submit" name="button2" value=" 搜  索 " >
	    <input name="" type="button" onClick="javascript:window.location='Search/Search.jsp'" value="高级搜索"/>     
   </div>
   <!-- </form> -->
   </form>
<div id="container" class="container_1">
<!--  <div id="content_right">这里预留</div>-->
<div id="content_left">
<%    Result result;

       for(int j=nowFirst;j<=nowLast;j++){
    	   result=FinalResult.getFresult(j);
%>
      <table style="table-layout:fixed;" align="center" width="600" border="0" >  <!-- bgcolor="#d0dff4" -->            
            
             <tr>
              <td class="title">              
                <%=TitleChange.change(result.getTitle(),result.getKind(),Change.urlChange(result.getUrl())) %>              
              </td>          
             </tr>
               <tr>
			      <td class="describe"><%=result.getDescribe() %></td>
               </tr>
                <tr>
			      <td class="date">发布时间： <%=result.getDate() %></td>
			      </tr>
                <tr>
			      <td class="kind">文档类型：<%=result.getKind() %></td>
			      </tr>
                <tr>
			      <td class="publisher">发布单位：<%=result.getPublisher() %></td>
               </tr>
               <tr>
			      <td class="url" alt="点击下载"><a href="<%=result.getUrl() %>" ><span class="downa" >URL：<%=result.getUrl() %></span></a></td>
               </tr>
            </table>
            <br/>           
  <% } %>
  <p id="page">
<% for(int i=0;i<allPageCount;i++){ 
               if(nowPageNum!=i){%>
<a href="DefaultResult.jsp?nowPageNum=<%=i%>"><span class="fk"></span>
<span class="pc"><%=i+1%></span></a>
<% }else{ %>
<strong><span class="fk fk_cur"></span><span class="pc"><%=nowPageNum+1%></span></strong>
<% } } %>
<% if(nowPageNum != (allPageCount - 1)){ %>
<a href="DefaultResult.jsp?nowPageNum=<%=nowPageNum+1%>" class="n">下一页&gt;</a>
<% } %>
<span class="nums" style="margin-left:120px">ZeroSearcher为您找到相关结果<label id="count1">
<font color="red"> <%=FinalResult.getFresultsize()%></font></label>条</span>
</p>
</div>
</div>   
  </div>
  </div>
  </div>
  </body>
</html>
