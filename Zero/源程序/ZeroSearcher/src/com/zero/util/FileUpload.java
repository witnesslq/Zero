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
 * <p>类名：FileUpload
 * <p>作用：使用common实现文件的上传功能 并得到上传文件的title，keywords，kind，describe，url等信息
 * <p>@author searchforyou
 * <p>@since 2008.8.10
 */
public class FileUpload extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码类型
		resp.setContentType("text/html;charset=gb2312");
		//构建servlet 处理过程的isMultipart，判断创建一个新的上传要求是否成功
	//	boolean isMultipart = ServletFileUpload.isMultipartContent((HttpServletRequest) new ServletRequestContext(req));
		//初始化上传路径
		String uploadPath = "";
		//初始化新的文件名
		String newFileName = "";
		//初始化对文件进行 写入的类
		File writeFile = null;

		
			try {
				//定义上传文件的地址
				uploadPath =getPath("webapps")+ "\\resources";
				//新建一个基于磁盘的工厂模式名目
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//设置上传文件的大小的上限
				factory.setSizeThreshold(1000000);
				//设置文件上传的路径
				factory.setRepository(new File(uploadPath));
                //新建一个文件上传处理程序
				ServletFileUpload upload = new ServletFileUpload(factory);
				//解析request  
				List<?> items = upload.parseRequest(req);
				
				//返回这个集合的跌代
				Iterator<?> iter = items.iterator();
				//新加的用来存放文件的Name名称
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
						 // 得到文件的名字，把它传给showFileName.jsp
						 String name = item.getName().replaceAll(".+\\\\", "");
						 long size = item.getSize();
						 //如果5个上传要求中 ，有上传为空的 就跳过上传程序
						 if ((name == null || name.equals("")) && size == 0) {
						 continue;
						 }						   
						//得到 最后 一个"."的索引以此作为 分开名称与类型的 索引位
	                                        int i= name.lastIndexOf(".");
	                                        //取上传文件的名称
	                                        String  title= name.substring(0,i);
	                                        //加到title 的list中
	                                        listName.add(title);
				                          //取上传文件类型
		                                String kindType=name.substring(i+1,name.length());
		                 
						//得到系统当前的日期时间。格式为yyyy-MM-dd HH:mm:ss
						Calendar cal = Calendar.getInstance(); 
						java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
						String cdate = sdf.format(cal.getTime()); 						
						//取系统当前的日期时间。格式为yyyyMMddhhmmssSSS
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");
						//把上传到目的路径的文件名字钱加上"yyyyMMddhhmmssSSS-"格式的时间，防止文件名字冲突
						newFileName = fmt.format(new Date()) + "_" + name;
	                    
						//把文件的title进行中文分词 得到默认的关键字
						String keywords =title;
						listKeyWords.add(keywords);
						
						//得到上传文件的类型
						String kind = kindType;
						listKind.add(kind);
						
						//得到上传文件的标题
						String describe = title;
						listDescribe.add(describe);
						
						//用来得到本机的ip地址
						InetAddress   address   =   InetAddress.getLocalHost(); 
						String ipLocal=address.getHostAddress();
						
						//设置文件的访问路径
						String url = "http://"+ipLocal+":8080/resources/"+newFileName;
						listUrl.add(url);
						
						//设置文件上传的日期时间为上传时刻的日期时间
						String date =cdate;
						listDate.add(date);
						
						//文件的author，publisher 默认为owner。
						String author = "owner";
						listAuthor.add(author);
						
						String publisher = "owner";
						listPublisher.add(publisher);
						
						//把文件上传置uploadPath路径
						writeFile = new File(uploadPath, newFileName);
						item.write(writeFile);
					}
				}
				/* 经用户修改了表单后返回List到页面中，其中ip为默认，不允许修改 */
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
	  * 函数名：getPath
	  * 作  用：得到tomcat根目录下面某个文件夹的路径
	  * 参  数：出递过来的tomcat根目录下面的某个文件夹
	  * 返回值：字符串 
	  */     
	public String getPath(String Webapps){
		
		//在本地目录下新建一个文件存放结果用于测试 检索是否正确
		String   path   =  System.getProperty("catalina.home");			
		/*因为不同的环境中 user。dir指向的有的是tomcat根目录，有的是bin目录，
		 * 所以 下面对 bin的位置进行判断，如果目录中含有bin则，进行 去掉bin目录的处理
		 * 这样 就能得到 tomcat的根目录了。
		 */
		int binindex=path.lastIndexOf("bin");
       if(binindex!=-1){
       	path=path.substring(0, binindex-1);
       }		
		path=path+"\\"+Webapps;
		return path;		
	}	
}