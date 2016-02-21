package com.zero.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zero.util.UtilClass;
import com.zero.xml.ResourceAdd;

/**
 * <p>类名：FileAddAction
 * <p>作用：把某个文件增加到共享域内
 */
public class FileAddAction extends Action{
	
	  /**    
	   *<br>函数名：execute     
	   *<br>作  用： 把某个文件增加到资源文件夹下
	   *<br>参  数：ActionMapping,ActionForm,HttpServletRequest,HttpServletResponse
	   *<br>返回类型：ActionForward 
	   */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//初始化增加资源的表单
		FileAddForm faf = (FileAddForm)form;
		//获取资源文件数组
		String files[] = faf.getFiles();
		//获取关键字数组
		String keywords[] = faf.getKeywords();
		//获取类型数组
		String kind[] = faf.getKind();
		//获取资源描述数组
		String describe[] = faf.getDescribe();
		//获取日期数组
		String date[] = faf.getDate();
		//获取url数组
		String url[] = faf.getUrl();
		//获取作者数组
		String author[] = faf.getAuthor();
		//获取出版者数组
		String publisher[] = faf.getPublisher(); 
		//初始化增加资源的类
		ResourceAdd ra = new ResourceAdd();
		//获取webapps目录
	    String path=UtilClass.getPath("webapps");
	    //逐条增加资源
		for(int i=0;i<files.length;i++){
			ra.addResourceitem();
			ra.addId();
			ra.addTitle(files[i]);
			ra.addKeyWords(keywords[i]);
			ra.addKind(kind[i]);
			ra.addDescribe(describe[i]);
			ra.addDate(date[i]);
			ra.addUrl(url[i]);
			ra.addAuthor(author[i]);
			ra.addpublisher(publisher[i]);
			ra.resouceWrite(path+"\\test.xml");
		}
		//转向 发布成功界面
		return  mapping.findForward("succeed");
	}
}