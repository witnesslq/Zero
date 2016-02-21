package com.zero.xml;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zero.util.UtilClass;

/** 
* <p>函数名：ForDeleteSearch
* <p>作  用：显示整个xml文件里面的内容，目的为了删除用
*/
 public class ForDeleteSearch  {
   

       int ii=0;
       
	     String id;
		 String title;
		 String describe;
		 String date;
		 
	
		 /** 
		 * <br>函数名：Search
		 * <br>作  用：列出所有的数据
		 * <br>参  数：无
		 * <br>返回类型： 空 
		 */

	public  void Search() throws UnsupportedEncodingException{
			
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
			
//			String keywords= foo.elementText("keywords"); 
	
	    	 id=foo.elementText("id");
			 title=foo.elementText("title");
			  describe=foo.elementText("describe");
			  date=foo.elementText("date");
                 
             ii++;
	    	continue;				    
		}
	}	
}