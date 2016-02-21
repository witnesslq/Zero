package com.zero.Servers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.zero.Sql.Chuli;
import com.zero.util.UtilClass;

public class PinYinChange extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204193652743076833L;


	public PinYinChange() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void init() throws ServletException{ 
		System.out.println("Æ´Òô¼ìË÷Ä£¿éÆô¶¯ÖÐ.........");
		ServletContext context = getServletContext(); 
		String path=context.getRealPath("/") + "SQL\\PinYin.mdb";
       
		UtilClass.realPath=context.getRealPath("/");
		
	try{	
		Chuli li=new Chuli(path);
		li.getkeyPinYin();
		
		System.out.println("Æ´Òô¼ìË÷Æô¶¯³É¹¦");
	}catch(Exception e){System.out.println("Æ´Òô¼ìË÷Æô¶¯Ê§°Ü");}

	
	}

 
}