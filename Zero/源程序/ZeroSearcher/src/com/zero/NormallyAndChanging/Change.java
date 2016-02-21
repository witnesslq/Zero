package com.zero.NormallyAndChanging;
/** 
* <p>类名：Urlchange
* <p>作  用：Url的转换，便于页面之间的传递 
*/
public class Change {
	
	/** 
	* <br>函数名：change
	* <br>作  用： 把转化为 ASCII 码 的URL地址转换回来
	* <br>参  数： String url
	* <br>返回类型： String 
	*/
  public static String change2UrlNorm(String url){
	 
	    
	  int[] shuju=new int[300];
	  String[] a=new String[300];
	  
	  String path="";
	    
	  a=url.split("\\*");
	  
	  for(int i=0;i<a.length;i++){
	  	   shuju[i]=Integer.parseInt(a[i]);
	  	   path+=(char)shuju[i];

	  }
return path;
  }
	/** 
	* <br>函数名：change
	* <br>作  用： 把URL 地址转化为 ASCII 码
	* <br>参  数： String url
	* <br>返回类型： String 
	*/
  public static String urlChange(String url){
	  
	  String str="";
	  int ascii;
	  for(int i=0;i<url.length();i++){
		  ascii=(int)url.charAt(i);
		  str+=String.valueOf(ascii)+"*";
	  }
	return str;
  }
  
  /** 
	* <br>函数名：change
	* <br>作  用： 转换一些特定的字符编码 
	* <br>参  数： String str
	* <br>返回类型： String 
	*/
	public static String ChineseChange(String str){   
      if(str==null){   
        str="";   
      }   
      else{ 
      	try{   
            str=new String(str.getBytes("iso-8859-1"),"gb2312");   
              }   
              catch(Exception ex){   
              }   
      }   
      return str   ;   
}
}