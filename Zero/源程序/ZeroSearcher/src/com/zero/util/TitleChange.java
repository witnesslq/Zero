package com.zero.util;

import com.zero.NormallyAndChanging.Change;

/**
 * 对文件名的包装工具类
 * @author Ahmatjan
 * @version V1.0
 */
public class TitleChange {
	/**
	 * 根据文件属性中的信息生成对文件信息包装后的URL链接地址,已访问文件内容
	 * @param title
	 * @param kind
	 * @param path
	 * @return String URL链接地址
	 */
public static String change(String title,String kind,String path){
	 String URL="";
	
   if(kind.equals("doc")||kind.equals("ppt")||kind.equals("docx")){ 
     URL="<a style=\"cursor:pointer\" onClick=\"javascript: window.open('ShowResult/showOffice.jsp?url=" + path + "&kind=" + kind + "','newwindow','left=300,height=650,width=570,fullscreen=0,toolbar=0,directories=0,location=0,status=1,menubar=0,scrollbars=1,resizable=1');\">" + title + "</a>"; 
   }
   else if(kind.equals("mp3")||kind.equals("wma")){
	 URL="<a style=\"cursor:pointer\" onClick=\"javascript: window.open('ShowResult/showmp3.jsp?title="+Change.urlChange(title)+"&url=" + path + "','newwindow','left=300,height=520,width=420,fullscreen=0,toolbar=0,directories=0,location=0,status=1,menubar=0,scrollbars=1,resizable=1');\">" + title + "</a>"; 

   }
   else if(kind.equals("mp4")||kind.equals("asf")||kind.equals("avi")||kind.equals("rm")||kind.equals("rmvb")||kind.equals("swf")||kind.equals("wmv")){
	 URL="<a style=\"cursor:pointer\" onClick=\"javascript: window.open('ShowResult/showvedio.jsp?url=" + path + "','newwindow','fullscreen=0,toolbar=0,directories=0,location=0,status=1,menubar=0,scrollbars=1,resizable=1');\">" + title + "</a>"; 
	   
   }
   else if(kind.equals("jpg")||kind.equals("gif")||kind.equals("bmp")||kind.equals("jpeg")||kind.equals("psd")||kind.equals("png")||kind.equals("pcx")||kind.equals("tiff")){
	 URL="<a href=\"" + Change.change2UrlNorm(path) + "\">"+ title + "</a>";  
   }else{
	   
	 URL="<a href=\"" + Change.change2UrlNorm(path) + "\">"+ title + "</a>";
   }

	return URL;	
}
}