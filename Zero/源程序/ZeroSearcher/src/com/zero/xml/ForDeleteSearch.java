package com.zero.xml;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zero.util.UtilClass;

/** 
* <p>��������ForDeleteSearch
* <p>��  �ã���ʾ����xml�ļ���������ݣ�Ŀ��Ϊ��ɾ����
*/
 public class ForDeleteSearch  {
   

       int ii=0;
       
	     String id;
		 String title;
		 String describe;
		 String date;
		 
	
		 /** 
		 * <br>��������Search
		 * <br>��  �ã��г����е�����
		 * <br>��  ������
		 * <br>�������ͣ� �� 
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