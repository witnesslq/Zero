package com.zero.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.zero.util.UtilClass;

/**
 * <p>类名：ResourceAdd
 * <p>作用：添加资源记录到test.xml中
 * <p>@author searchforyou
 * <p>@since 2008.8.20
 */
public class ResourceAdd {

	HttpServletRequest req;
	private Document doc = null;
	private Element root = null;
	private Element resourceitem = null;
	
	  /**    
	   *<br>函数名：addResourceitem     
	   *<br>作  用： 建立对test.xml的解析，并添加resourceitem元素节点
	   *<br>参  数：无
	   *<br>返回类型：无 
	   */
	public void addResourceitem() throws DocumentException {
		// 得到test.xml的存放地址
		String path = UtilClass.getPath("webapps");
		// test.xml的访问路径
		String filepath = path + "\\" + "test.xml";
		
		//构建一个 解析器
		SAXReader xmlReader = new SAXReader();
		doc = xmlReader.read(filepath);
		root = doc.getRootElement();
		resourceitem = root.addElement("resourceitem");
	}

	// 为resourceitem添加id元素节点
	public void addId() {
		Iterator<?> it = root.elementIterator("resourceitem"); 
		Element elementNode = null;
		int largeId = 0;
		// 遍历整个Element树，找出id的最大值
		while (it.hasNext()) {
			elementNode = (Element) it.next();
			String id = elementNode.elementText("id");
			int lengths = elementNode.elements("id").size();
			if(lengths==0)
				continue;
			// largeId为已经遍历过的resourceitem中的id最大值
			if (Integer.parseInt(id) > largeId){
				largeId = Integer.parseInt(id);
			}
		}
		// 当前记录的id为已经存在的记录的id最大值加1；
		String idText = String.valueOf(largeId + 1);
		// 添加id结点
		Element idNode = resourceitem.addElement("id");
		idNode.addText(idText);

	}

	// 为resourceitem添加title元素节点
	public void addTitle(String titleText) {
		Element titleNode = resourceitem.addElement("title");
		titleNode.addText(titleText);
	}

	// 为resourceitem添加keywords元素节点
	public void addKeyWords(String keywords) {
		Element keyWordsNode = resourceitem.addElement("keywords");
		keyWordsNode.addText(keywords);
	}

	// 为resourceitem添加kind元素节点
	public void addKind(String kind) {
		Element kindNode = resourceitem.addElement("kind");
		kindNode.addText(kind);
	}

	// 为resourceitem添加describe元素节点
	public void addDescribe(String describe) {
		Element describeNode = resourceitem.addElement("describe");
		describeNode.addText(describe);
	}

	// 为resourceitem添加date元素节点
	public void addDate(String date) {
		Element dateNode = resourceitem.addElement("date");
		dateNode.addText(date);
	}

	// 为resourceitem添加url元素节点
	public void addUrl(String url) {
		Element urlNode = resourceitem.addElement("url");
		urlNode.addText(url);
	}

	// 为resourceitem添加author元素节点
	public void addAuthor(String author) {
		Element authorNode = resourceitem.addElement("author");
		authorNode.addText(author);
	}

	// 为resourceitem添加publisher元素节点
	public void addpublisher(String publish) {
		Element publishNode = resourceitem.addElement("publish");
		publishNode.addText(publish);
	}
	
	public void resouceWrite(String newfilename) throws IOException{
		//格式化输出,类型IE浏览一样
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 指定XML字符集编码 
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File(newfilename)));
		writer.write(doc);
		writer.close();
	}
}