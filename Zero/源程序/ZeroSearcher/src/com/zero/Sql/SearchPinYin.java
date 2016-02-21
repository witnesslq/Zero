package com.zero.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zero.util.UtilClass;

public class SearchPinYin {

	public static String Search(String txt){
		String str="";
		
		try{
		  String   dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ=" + UtilClass.realPath + "SQL\\PinYin.mdb";  
		  String   user="";   
		  String   password="";   
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
		  Connection c=DriverManager.getConnection(dbUrl,user,password);
		  Statement   s=c.createStatement();   
	
		  ResultSet   r=s.executeQuery("select * from change where yin='"+txt+"'");   
		if(r.next()){
		
		 do{ 
			  String hanzi=r.getString("zi");
			 if(str.indexOf(hanzi)== -1)
                str+=hanzi+" ";
			  
		  } while(r.next());   
		  r.close();
		  s.close();
		  c.close();   
		  System.out.println("Æ´Òô×ª»¯Îª£º  "+str);
		}else{
			str=txt;
		}
		  return str;
		}catch(Exception e){ return txt; }

		
	}

  


}