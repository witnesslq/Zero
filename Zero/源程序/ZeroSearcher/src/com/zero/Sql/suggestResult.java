package com.zero.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zero.util.UtilClass;

public class suggestResult extends Thread {
      String keyword="";
      int shuliang=0;
      
	 public suggestResult(String key,int shu){
		 super();
		 this.keyword=key;
		 this.shuliang=shu;
	 }
	 
	 public void run(){
		 
//			boolean ret=false;
			try{
			  String   dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ=" + UtilClass.realPath + "SQL\\suggest.mdb";  
			
			  String   user="";   
			  String   password="";   
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
			  Connection c=DriverManager.getConnection(dbUrl,user,password);
			  Statement   s=c.createStatement();   
		
			String sql="select * from search where keyword like '"+keyword+"'";
			   	
		
			  ResultSet   r=s.executeQuery(sql);   
			     String nsql="";
			    
			     if(r.next()){
					nsql="update search set searchtimes="+(r.getString("searchtimes")+1)+",matchnum="+shuliang+" where id="+r.getString("id");
//		            int shuzhi=s.executeUpdate(nsql);
		            s.executeUpdate(nsql);
			      }else{
			        nsql="insert into search(keyword,searchtimes,matchnum) values('"+keyword+"',1,"+shuliang+")";
//			        int tt=s.executeUpdate(nsql);  	
			        s.executeUpdate(nsql);
			      }				  
			  r.close();
			  s.close();
			  c.close();			
			}catch(Exception e){ }		 
	 }
	
}