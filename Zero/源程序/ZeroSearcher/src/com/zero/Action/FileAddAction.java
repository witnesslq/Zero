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
 * <p>������FileAddAction
 * <p>���ã���ĳ���ļ����ӵ���������
 */
public class FileAddAction extends Action{
	
	  /**    
	   *<br>��������execute     
	   *<br>��  �ã� ��ĳ���ļ����ӵ���Դ�ļ�����
	   *<br>��  ����ActionMapping,ActionForm,HttpServletRequest,HttpServletResponse
	   *<br>�������ͣ�ActionForward 
	   */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ʼ��������Դ�ı�
		FileAddForm faf = (FileAddForm)form;
		//��ȡ��Դ�ļ�����
		String files[] = faf.getFiles();
		//��ȡ�ؼ�������
		String keywords[] = faf.getKeywords();
		//��ȡ��������
		String kind[] = faf.getKind();
		//��ȡ��Դ��������
		String describe[] = faf.getDescribe();
		//��ȡ��������
		String date[] = faf.getDate();
		//��ȡurl����
		String url[] = faf.getUrl();
		//��ȡ��������
		String author[] = faf.getAuthor();
		//��ȡ����������
		String publisher[] = faf.getPublisher(); 
		//��ʼ��������Դ����
		ResourceAdd ra = new ResourceAdd();
		//��ȡwebappsĿ¼
	    String path=UtilClass.getPath("webapps");
	    //����������Դ
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
		//ת�� �����ɹ�����
		return  mapping.findForward("succeed");
	}
}