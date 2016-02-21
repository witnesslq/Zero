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
 * <p>������ResourceAdd
 * <p>���ã������Դ��¼��test.xml��
 * <p>@author searchforyou
 * <p>@since 2008.8.20
 */
public class ResourceAdd {

	HttpServletRequest req;
	private Document doc = null;
	private Element root = null;
	private Element resourceitem = null;
	
	  /**    
	   *<br>��������addResourceitem     
	   *<br>��  �ã� ������test.xml�Ľ����������resourceitemԪ�ؽڵ�
	   *<br>��  ������
	   *<br>�������ͣ��� 
	   */
	public void addResourceitem() throws DocumentException {
		// �õ�test.xml�Ĵ�ŵ�ַ
		String path = UtilClass.getPath("webapps");
		// test.xml�ķ���·��
		String filepath = path + "\\" + "test.xml";
		
		//����һ�� ������
		SAXReader xmlReader = new SAXReader();
		doc = xmlReader.read(filepath);
		root = doc.getRootElement();
		resourceitem = root.addElement("resourceitem");
	}

	// Ϊresourceitem���idԪ�ؽڵ�
	public void addId() {
		Iterator<?> it = root.elementIterator("resourceitem"); 
		Element elementNode = null;
		int largeId = 0;
		// ��������Element�����ҳ�id�����ֵ
		while (it.hasNext()) {
			elementNode = (Element) it.next();
			String id = elementNode.elementText("id");
			int lengths = elementNode.elements("id").size();
			if(lengths==0)
				continue;
			// largeIdΪ�Ѿ���������resourceitem�е�id���ֵ
			if (Integer.parseInt(id) > largeId){
				largeId = Integer.parseInt(id);
			}
		}
		// ��ǰ��¼��idΪ�Ѿ����ڵļ�¼��id���ֵ��1��
		String idText = String.valueOf(largeId + 1);
		// ���id���
		Element idNode = resourceitem.addElement("id");
		idNode.addText(idText);

	}

	// Ϊresourceitem���titleԪ�ؽڵ�
	public void addTitle(String titleText) {
		Element titleNode = resourceitem.addElement("title");
		titleNode.addText(titleText);
	}

	// Ϊresourceitem���keywordsԪ�ؽڵ�
	public void addKeyWords(String keywords) {
		Element keyWordsNode = resourceitem.addElement("keywords");
		keyWordsNode.addText(keywords);
	}

	// Ϊresourceitem���kindԪ�ؽڵ�
	public void addKind(String kind) {
		Element kindNode = resourceitem.addElement("kind");
		kindNode.addText(kind);
	}

	// Ϊresourceitem���describeԪ�ؽڵ�
	public void addDescribe(String describe) {
		Element describeNode = resourceitem.addElement("describe");
		describeNode.addText(describe);
	}

	// Ϊresourceitem���dateԪ�ؽڵ�
	public void addDate(String date) {
		Element dateNode = resourceitem.addElement("date");
		dateNode.addText(date);
	}

	// Ϊresourceitem���urlԪ�ؽڵ�
	public void addUrl(String url) {
		Element urlNode = resourceitem.addElement("url");
		urlNode.addText(url);
	}

	// Ϊresourceitem���authorԪ�ؽڵ�
	public void addAuthor(String author) {
		Element authorNode = resourceitem.addElement("author");
		authorNode.addText(author);
	}

	// Ϊresourceitem���publisherԪ�ؽڵ�
	public void addpublisher(String publish) {
		Element publishNode = resourceitem.addElement("publish");
		publishNode.addText(publish);
	}
	
	public void resouceWrite(String newfilename) throws IOException{
		//��ʽ�����,����IE���һ��
		OutputFormat format = OutputFormat.createPrettyPrint();
		// ָ��XML�ַ������� 
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File(newfilename)));
		writer.write(doc);
		writer.close();
	}
}