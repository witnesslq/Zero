package com.zero.Sql;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zero.util.SpellCnHelper;
import com.zero.util.UtilClass;

public class Chuli  {
	 String path="";
	 public Chuli(String aa){
		 path=aa;
		 
	 }

	public void getkeyPinYin() throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
		String   dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ=" + path;  
		String   user="";   
		String   password="";   
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
		Connection   c=DriverManager.getConnection(dbUrl,user,password);   
		Statement   s=c.createStatement();   
//		ResultSet rs=null;
		String tomcat=UtilClass.getPath("webapps");       
        String filepath= tomcat+"\\"+"test.xml";
    	SAXReader reader = new SAXReader(); 
		Document document = null;
		try {
			document = reader.read("file:\\"+filepath);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement(); 
		Element foo = null; 
		Iterator<?>  it = root.elementIterator("resourceitem"); 		
		while (it.hasNext()) { 				
			foo =  (Element) it.next(); 
			String keywords= foo.elementText("keywords"); 
			if(keywords!=null ){	
			 //多关键字以逗号拆分
		    String[] chai;
            if(keywords.indexOf(",")!= -1){
          	  chai=keywords.split(",");
            }else{
          	  chai=keywords.split("，");
            }
            //多关键字以逗号拆分			
			for(int y=0;y<chai.length;y++){
				String yin=SpellCnHelper.getSpell(chai[y].trim());
				NotIn  in=new NotIn();
				if(in.notin(chai[y].trim())){
					String	 sql="insert into change values('"+yin+"','"+chai[y]+"')";
					s.executeUpdate(sql);
        		}
			}
		}
	}		// int[] tt= s.executeBatch();
	s.close();
	c.close();
	}	
}