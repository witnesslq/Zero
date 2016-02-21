package com.zero.Action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.Document; 
import org.dom4j.DocumentException; 
import org.dom4j.Element; 
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader; 
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import com.zero.util.UtilClass;

/**
 * <p>������ResourceDelete
 * <p>���ã�ɾ��test.xmlĳ����Դ��¼
 */
public class DeleteAction extends Action{
	
	  /**    
	   *<br>��������execute     
	   *<br>��  �ã�ɾ��test.xmlĳ����Դ��¼
	   *<br>��  ����ActionMapping,ActionForm,HttpServletRequest,HttpServletResponse
	   *<br>�������ͣ�ActionForward 
	   */
	 public ActionForward execute(ActionMapping mapping,
				ActionForm form, 
				HttpServletRequest request, 
				HttpServletResponse response)
				throws SAXException, DocumentException, IOException {
		        System.out.println("��ʼɾ��");
                //ȡ�ô��ݵع�����form
		        DeleteForm deleteResourceForm = (DeleteForm) form;	
		        
		        
				//���Ҫɾ������Դ���ļ���
		        String[] fileNames=deleteResourceForm.getdeleteName();
		        for(int i=0;i<fileNames.length;i++)
		        System.out.println(fileNames[i]);
		        //���test.xml�ļ�·��
		        String path = UtilClass.getPath("webapps");
		        String recordpath= path+"\\"+"test.xml";
		        
			    //������test.xml�Ľ���
		        Document doc = null;
		   	    Element root=null;
		        SAXReader xmlReader = new SAXReader();
		        doc = xmlReader.read(recordpath);
		        root = doc.getRootElement(); 
                //�����µ� ElementIterator���� Element �����е�����
		        Iterator<?>  it = root.elementIterator("resourceitem"); 
                Element elementNode=null;
                
				//ѭ������ ���xml�е� ��¼���ҵ�Ҫɾ������Դ��¼������ɾ��
				while (it.hasNext()) { 					
					elementNode=  (Element) it.next(); 
					String url=elementNode.elementText("url");
					//���������¼��url�а������ݹ�����fileName��˵�������Ҫɾ���ļ�¼������ɾ����������ѭ��
					for(int i=0;i<fileNames.length;i++){
					    if(url.indexOf(fileNames[i])!=-1){
					    	root.remove(elementNode);
						    break;
					    }
					}
			    }
				//ɾ��ĳЩ��¼�󣬱���xml�ļ�
				 try{  
					 OutputFormat format = OutputFormat.createPrettyPrint();
						//ָ��XML�ַ������� 
						format.setEncoding("GBK");
						//����xml��
					  XMLWriter writer = new XMLWriter(new FileWriter(new File(recordpath)),format);     
					  writer.write(doc);                               
					  writer.close();                                                       
					  }   
					  catch(Exception ex){
						  ex.printStackTrace(); 
					  } 
			    //�ڷ�����Դ���ļ����а�Ҫɾ������Դɾ��
				for(int i=0;i<fileNames.length;i++){
				String filepath= path+"\\"+"resources"+"\\"+fileNames[i];
                //����ļ��Ѿ����ڣ����������ļ����
				File file=new File(filepath);							
			    if(file.exists()&&file.isFile())file.delete();	
				}			    
			    return mapping.findForward("resourceSuccess");
	 }
}