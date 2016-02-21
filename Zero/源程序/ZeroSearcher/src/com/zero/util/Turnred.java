package com.zero.util;

import java.util.List;

public class Turnred {
public static String turn(String Str,List<String> txt){
	String s=Str;
    int od=0;
    int nd=0;   
    String Str2="";    //设置title
    
  	  
  	  for(int inde=0;inde<txt.size();inde++){
  		  od=0;
  		  nd=0;
  		while(nd!= -1){
  		  nd=s.indexOf(txt.get(inde).toString(),od);  

    	if(nd!= -1){    //如果有新位置
    	
    		Str2=Str2+s.substring(od,nd)+"<span>"+s.substring(nd,nd+txt.get(inde).toString().length())+"</span>";
    	    od=nd+txt.get(inde).toString().length();
    	 
    	 }else{
    		Str2=Str2+s.substring(od,s.length());
    	 	
    	   }

        }
  		s=Str2;
  		Str2="";
     }
    return s;
	
}
}