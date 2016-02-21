package com.zero.xml;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.zero.util.UtilClass;

/** 
* <p>������ChuliConfig
* <p>��  �ã���������ChuliConfig.jsp �ύ�����������޸�����������ַ�Ĳ��� 
*/
public class ChangeHostIP {

	
	  /**    
	   *<br>��������dul     
	   *<br>��  �ã��޸�test.xml �ļ�������������ַ
	   *<br>��  ����server ���޸ĵ�����������ַ
	   *<br>�������ͣ�boolean
	   */
@SuppressWarnings("deprecation")
public boolean dul(String server){	
	String tomcat=UtilClass.getPath("webapps");       
    String filepath= tomcat+"\\"+"test.xml";
	SAXReader reader = new SAXReader(); 
	Document document = null;
	try {
		document = reader.read("file:\\"+filepath);
		Element root = document.getRootElement(); 
		root.setAttributeValue("remote", server);	
		OutputFormat format = OutputFormat.createPrettyPrint();
		//ָ��XML�ַ������� 
		format.setEncoding("GBK");
		//����xml��
		XMLWriter writer = new XMLWriter(new FileWriter(new File(filepath)),format);     
		writer.write(document);                               
		writer.close();       
		UtilClass.setRemoteip(server);       
		return true;
	} catch (Exception e) {
		return false;
	}	
	}    
}