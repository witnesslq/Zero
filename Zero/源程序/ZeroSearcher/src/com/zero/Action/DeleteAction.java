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
 * <p>类名：ResourceDelete
 * <p>作用：删除test.xml某条资源记录
 */
public class DeleteAction extends Action{
	
	  /**    
	   *<br>函数名：execute     
	   *<br>作  用：删除test.xml某条资源记录
	   *<br>参  数：ActionMapping,ActionForm,HttpServletRequest,HttpServletResponse
	   *<br>返回类型：ActionForward 
	   */
	 public ActionForward execute(ActionMapping mapping,
				ActionForm form, 
				HttpServletRequest request, 
				HttpServletResponse response)
				throws SAXException, DocumentException, IOException {
		        System.out.println("开始删除");
                //取得传递地过来的form
		        DeleteForm deleteResourceForm = (DeleteForm) form;	
		        
		        
				//获得要删除的资源的文件名
		        String[] fileNames=deleteResourceForm.getdeleteName();
		        for(int i=0;i<fileNames.length;i++)
		        System.out.println(fileNames[i]);
		        //获得test.xml文件路径
		        String path = UtilClass.getPath("webapps");
		        String recordpath= path+"\\"+"test.xml";
		        
			    //建立到test.xml的解析
		        Document doc = null;
		   	    Element root=null;
		        SAXReader xmlReader = new SAXReader();
		        doc = xmlReader.read(recordpath);
		        root = doc.getRootElement(); 
                //创建新的 ElementIterator，沿 Element 树进行迭代；
		        Iterator<?>  it = root.elementIterator("resourceitem"); 
                Element elementNode=null;
                
				//循环遍历 这个xml中的 记录，找到要删除的资源记录并把它删除
				while (it.hasNext()) { 					
					elementNode=  (Element) it.next(); 
					String url=elementNode.elementText("url");
					//如果这条记录的url中包含传递过来的fileName，说明这就是要删除的记录，把它删除，并跳出循环
					for(int i=0;i<fileNames.length;i++){
					    if(url.indexOf(fileNames[i])!=-1){
					    	root.remove(elementNode);
						    break;
					    }
					}
			    }
				//删除某些记录后，保存xml文件
				 try{  
					 OutputFormat format = OutputFormat.createPrettyPrint();
						//指定XML字符集编码 
						format.setEncoding("GBK");
						//创建xml流
					  XMLWriter writer = new XMLWriter(new FileWriter(new File(recordpath)),format);     
					  writer.write(doc);                               
					  writer.close();                                                       
					  }   
					  catch(Exception ex){
						  ex.printStackTrace(); 
					  } 
			    //在放置资源的文件夹中把要删除的资源删除
				for(int i=0;i<fileNames.length;i++){
				String filepath= path+"\\"+"resources"+"\\"+fileNames[i];
                //如果文件已经存在，则获得它的文件句柄
				File file=new File(filepath);							
			    if(file.exists()&&file.isFile())file.delete();	
				}			    
			    return mapping.findForward("resourceSuccess");
	 }
}