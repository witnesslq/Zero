package com.zero.NormallyAndChanging;
/** 
* <p>������Urlchange
* <p>��  �ã�Url��ת��������ҳ��֮��Ĵ��� 
*/
public class Change {
	
	/** 
	* <br>��������change
	* <br>��  �ã� ��ת��Ϊ ASCII �� ��URL��ַת������
	* <br>��  ���� String url
	* <br>�������ͣ� String 
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
	* <br>��������change
	* <br>��  �ã� ��URL ��ַת��Ϊ ASCII ��
	* <br>��  ���� String url
	* <br>�������ͣ� String 
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
	* <br>��������change
	* <br>��  �ã� ת��һЩ�ض����ַ����� 
	* <br>��  ���� String str
	* <br>�������ͣ� String 
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