package com.zero.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zero.util.UtilClass;

public class NotIn {
   public boolean notin(String str){
		boolean ret=false;
		try{
		  String   dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ=" + UtilClass.realPath + "SQL\\PinYin.mdb";  
		  String   user="";   
		  String   password="";   
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
		  Connection c=DriverManager.getConnection(dbUrl,user,password);
		  Statement   s=c.createStatement();   
	
		  ResultSet   r=s.executeQuery("select * from change where zi='"+str.trim()+"'");   
		
			  if(r.next()){
				  ret = false;
		      }else{
			   ret = true;
		      } 
			  
		  r.close();
		  s.close();
		  c.close();   

		  return ret;
		}catch(Exception e){ return false;}

		
	
	   
   }
}