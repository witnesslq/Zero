package com.zero.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.zero.domainModel.Result;
import com.zero.util.UtilClass;

/**
 * <b>test.xml资源文件解析类</b>
 * @author Ahmatjan
 * @version V1.0
 */
public class ParseTestXml {
	private final static Log log = LogFactory.getLog(ParseTestXml.class);
	private static String testxml = "test.xml";
	/**
	 * <b>解析test.xml</br>
	 * 返回一个包含每一个ResourceItem相关信息的List</b>
	 * @return List<ResourceItem><br>
	 * <b>返回包含资源信息的List</b>
	 */
	public static List<Result> parseXml() {
		List<Result> list = new ArrayList<Result>();
		Document document = getDocument();
		Element root = document.getRootElement();
		Iterator<?> it = root.elementIterator();
		while (it.hasNext()) {
			Element resourceEle = (Element) it.next();
			Result resourceItem = new Result();
			resourceItem.setId(resourceEle.elementTextTrim("id"));
			resourceItem.setTitle(resourceEle.elementTextTrim("title"));
			resourceItem.setAuthor(resourceEle.elementTextTrim("author"));
			resourceItem.setDate(resourceEle.elementTextTrim("date"));
			resourceItem.setDescribe(resourceEle.elementTextTrim("describe"));
			resourceItem.setKeywords(resourceEle.elementTextTrim("keywords"));
			resourceItem.setKind(resourceEle.elementTextTrim("kind"));
			resourceItem.setPublisher(resourceEle.elementTextTrim("publisher"));
			resourceItem.setUrl(resourceEle.elementTextTrim("url"));
			list.add(resourceItem);
		}
		return list;
	}
	/**
	 * <b>将发布的资源写入test.xml</b>
	 * @param id
	 * @param title
	 * @param author
	 * @param date
	 * @param describe
	 * @param keywords
	 * @param kind
	 * @param publisher
	 * @param url
	 */
	public static void addResource(String id,String title,String author,String date,String describe,
			String keywords,String kind,String publisher,String url){
		Document doc=getDocument();
		Element root=doc.getRootElement();
		Element resourceitem=root.addElement("resourceitem");
		Element idEle = resourceitem.addElement("id");
		idEle.setText(id);
		Element titleEle = resourceitem.addElement("title");
		titleEle.setText(title);
		Element authorEle = resourceitem.addElement("author");
		authorEle.setText(author);
		Element dateEle = resourceitem.addElement("date");
		dateEle.setText(date);
		Element describeEle = resourceitem.addElement("describe");
		describeEle.setText(describe);
		Element keywordsEle = resourceitem.addElement("keywords");
		keywordsEle.setText(keywords);
		Element kindEle = resourceitem.addElement("kind");
		kindEle.setText(kind);
		Element publisherEle = resourceitem.addElement("publisher");
		publisherEle.setText(publisher);
		Element urlEle = resourceitem.addElement("url");
		urlEle.setText(url);	
//		doc.add(resourceitem);
		saveXML(doc);
	}
	
	/**
	 * <b>根据资源唯一id删除资源信息</b>
	 * @param id
	 */
	public static void removeResource(String id){
		Document doc=getDocument();
		Element root=doc.getRootElement();
		Iterator<?> it = root.elementIterator();
		while(it.hasNext()){
			Element child=(Element)it.next();
			if(child.element("id").getText().equals(id))
				root.remove(child);
		}
		saveXML(doc);
	}
	/**
	 * <b>获取本机IP</b>
	 * <b>finally方法,不能被继承</b>
	 * @return String
	 * <b>String形式本机IP信息</b>
	 */
	@SuppressWarnings("finally")
	public static String getHostIP(){
		String hostIP="";
		Document doc = null;
		Element root = null;
		try {
			doc=getDocument();
			root=doc.getRootElement();		
			hostIP = root.attributeValue("host");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("",e);
		}finally{
			return hostIP;
		}
	}
	/**
	 * <b>获取远程主机（协调者）的IP</b>
	 * <b>finally方法,不能被继承</b>
	 * @return String
	 * <b>String形式远程主机IP信息</b>
	 */
	@SuppressWarnings("finally")
	public static String getRemoteIP(){
		String remoteIP="";
		try {
			Document doc=getDocument();
			Element root=doc.getRootElement();		
			remoteIP = root.attributeValue("remote");
		}finally{
			return remoteIP;
		}
	}

	/**
	 * <b>获取Document</b>
	 * @return Document
	 */
	public static Document getDocument() {
		String path = UtilClass.getPath("webapps\\");
		File test = null;
		Document document = null;
		SAXReader parser = new SAXReader();
		try {
			test = new File(path + testxml);
			document = parser.read(test);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			log.error("找不到"+document,e);
		}
		return document;
	}
	
	/**
	 * <b>保存xml<b>
	 * @param doc
	 */
	public static void saveXML(Document doc){
		String resourcePath = UtilClass.getPath("webapps\\");
		FileOutputStream test = null;
		OutputFormat format = null;
		XMLWriter writer = null;
		try {
			format = OutputFormat.createPrettyPrint();
			test = new FileOutputStream(resourcePath + testxml);
	        writer = new XMLWriter(test, format );
	        writer.write(doc);	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.error("获取XMLWriter失败"+writer, e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("test.xml文件获取失败"+test, e);
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("关闭XMLWriter失败"+writer, e);
			}
		}
	}
}
