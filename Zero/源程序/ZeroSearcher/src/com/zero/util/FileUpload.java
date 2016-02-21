package com.zero.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * <p>������FileUpload
 * <p>���ã�ʹ��commonʵ���ļ����ϴ����� ���õ��ϴ��ļ���title��keywords��kind��describe��url����Ϣ
 * <p>@author searchforyou
 * <p>@since 2008.8.10
 */
public class FileUpload extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ�������
		resp.setContentType("text/html;charset=gb2312");
		//����servlet ������̵�isMultipart���жϴ���һ���µ��ϴ�Ҫ���Ƿ�ɹ�
	//	boolean isMultipart = ServletFileUpload.isMultipartContent((HttpServletRequest) new ServletRequestContext(req));
		//��ʼ���ϴ�·��
		String uploadPath = "";
		//��ʼ���µ��ļ���
		String newFileName = "";
		//��ʼ�����ļ����� д�����
		File writeFile = null;

		
			try {
				//�����ϴ��ļ��ĵ�ַ
				uploadPath =getPath("webapps")+ "\\resources";
				//�½�һ�����ڴ��̵Ĺ���ģʽ��Ŀ
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//�����ϴ��ļ��Ĵ�С������
				factory.setSizeThreshold(1000000);
				//�����ļ��ϴ���·��
				factory.setRepository(new File(uploadPath));
                //�½�һ���ļ��ϴ��������
				ServletFileUpload upload = new ServletFileUpload(factory);
				//����request  
				List<?> items = upload.parseRequest(req);
				
				//����������ϵĵ���
				Iterator<?> iter = items.iterator();
				//�¼ӵ���������ļ���Name����
				List<String> listName = new ArrayList<String>();
				List<String> listKeyWords = new ArrayList<String>();
				List<String> listKind = new ArrayList<String>();
				List<String> listDescribe = new ArrayList<String>();
				List<String> listUrl = new ArrayList<String>();
				List<String> listDate = new ArrayList<String>();
				List<String> listAuthor = new ArrayList<String>();
				List<String> listPublisher = new ArrayList<String>();
				
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (!item.isFormField()) {
						 // �õ��ļ������֣���������showFileName.jsp
						 String name = item.getName().replaceAll(".+\\\\", "");
						 long size = item.getSize();
						 //���5���ϴ�Ҫ���� �����ϴ�Ϊ�յ� �������ϴ�����
						 if ((name == null || name.equals("")) && size == 0) {
						 continue;
						 }						   
						//�õ� ��� һ��"."�������Դ���Ϊ �ֿ����������͵� ����λ
	                                        int i= name.lastIndexOf(".");
	                                        //ȡ�ϴ��ļ�������
	                                        String  title= name.substring(0,i);
	                                        //�ӵ�title ��list��
	                                        listName.add(title);
				                          //ȡ�ϴ��ļ�����
		                                String kindType=name.substring(i+1,name.length());
		                 
						//�õ�ϵͳ��ǰ������ʱ�䡣��ʽΪyyyy-MM-dd HH:mm:ss
						Calendar cal = Calendar.getInstance(); 
						java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
						String cdate = sdf.format(cal.getTime()); 						
						//ȡϵͳ��ǰ������ʱ�䡣��ʽΪyyyyMMddhhmmssSSS
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");
						//���ϴ���Ŀ��·�����ļ�����Ǯ����"yyyyMMddhhmmssSSS-"��ʽ��ʱ�䣬��ֹ�ļ����ֳ�ͻ
						newFileName = fmt.format(new Date()) + "_" + name;
	                    
						//���ļ���title�������ķִ� �õ�Ĭ�ϵĹؼ���
						String keywords =title;
						listKeyWords.add(keywords);
						
						//�õ��ϴ��ļ�������
						String kind = kindType;
						listKind.add(kind);
						
						//�õ��ϴ��ļ��ı���
						String describe = title;
						listDescribe.add(describe);
						
						//�����õ�������ip��ַ
						InetAddress   address   =   InetAddress.getLocalHost(); 
						String ipLocal=address.getHostAddress();
						
						//�����ļ��ķ���·��
						String url = "http://"+ipLocal+":8080/resources/"+newFileName;
						listUrl.add(url);
						
						//�����ļ��ϴ�������ʱ��Ϊ�ϴ�ʱ�̵�����ʱ��
						String date =cdate;
						listDate.add(date);
						
						//�ļ���author��publisher Ĭ��Ϊowner��
						String author = "owner";
						listAuthor.add(author);
						
						String publisher = "owner";
						listPublisher.add(publisher);
						
						//���ļ��ϴ���uploadPath·��
						writeFile = new File(uploadPath, newFileName);
						item.write(writeFile);
					}
				}
				/* ���û��޸��˱��󷵻�List��ҳ���У�����ipΪĬ�ϣ��������޸� */
				System.out.println(listName);
				req.setAttribute("fileName1", listName);
				req.setAttribute("fileName2", listKeyWords);
				
				req.setAttribute("fileName4", listDescribe);
				req.setAttribute("fileName5", listUrl);
				req.setAttribute("fileName6", listDate);
				req.setAttribute("fileName7", listAuthor);
				req.setAttribute("fileName8", listPublisher);
				req.setAttribute("fileName9", listKind);
				req.getRequestDispatcher("/Manager/showFileAddContent.jsp").forward(req,resp);
			} catch (FileUploadException e) {
				
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			} catch (Exception e) {				
			}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	

	 /** 
	  * ��������getPath
	  * ��  �ã��õ�tomcat��Ŀ¼����ĳ���ļ��е�·��
	  * ��  �������ݹ�����tomcat��Ŀ¼�����ĳ���ļ���
	  * ����ֵ���ַ��� 
	  */     
	public String getPath(String Webapps){
		
		//�ڱ���Ŀ¼���½�һ���ļ���Ž�����ڲ��� �����Ƿ���ȷ
		String   path   =  System.getProperty("catalina.home");			
		/*��Ϊ��ͬ�Ļ����� user��dirָ����е���tomcat��Ŀ¼���е���binĿ¼��
		 * ���� ����� bin��λ�ý����жϣ����Ŀ¼�к���bin�򣬽��� ȥ��binĿ¼�Ĵ���
		 * ���� ���ܵõ� tomcat�ĸ�Ŀ¼�ˡ�
		 */
		int binindex=path.lastIndexOf("bin");
       if(binindex!=-1){
       	path=path.substring(0, binindex-1);
       }		
		path=path+"\\"+Webapps;
		return path;		
	}	
}