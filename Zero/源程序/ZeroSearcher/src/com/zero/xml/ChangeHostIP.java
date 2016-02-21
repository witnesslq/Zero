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
* <p>类名：ChuliConfig
* <p>作  用：用来处理ChuliConfig.jsp 提交过来的用来修改主服务器地址的参数 
*/
public class ChangeHostIP {

	
	  /**    
	   *<br>函数名：dul     
	   *<br>作  用：修改test.xml 文件中主服务器地址
	   *<br>参  数：server 待修改的主服务器地址
	   *<br>返回类型：boolean
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
		//指定XML字符集编码 
		format.setEncoding("GBK");
		//创建xml流
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