package com.zero.Init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.zero.Rmi.Del;
import com.zero.Rmi.IPlist;
import com.zero.util.UtilClass;

/** 
* <p>类  名：Init (servlet)
* <p>作  用：RMI远程调用的初始化工作
* <br>此 Servlet为初始化作用
* <br>初始化完成了RMI 注册服务的开启 并向主服务器注册
*/
public class Init extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031931666738966175L;

	/** 
	* <br>函数名：Init
	* <br>作  用： 构造函数
	* <br>参  数： 无
	*/
	public Init() {
		super();
	}

	/** 
	* <br>函数名：destroy
	* <br>作  用： 系统退出发送注销信息
	* <br>参  数： 无
	* <br>返回类型： 空 
	*/
	public void destroy() {
		super.destroy(); 
		IPlist.iplist.remove(UtilClass.getHostip());
	      for(int y=0;y<IPlist.iplist.size();y++){
		      	if(!(IPlist.iplist.get(y).toString().equals(UtilClass.getHostip()))){
               Del del=new Del(IPlist.iplist.get(y).toString(),UtilClass.getHostip());
               del.start();

               }
	      }	
		
	}
	
	/** 
	* <br>函数名：init
	* <br>作  用：servlet的初始化函数
	* <br>参  数： 无
	* <br>返回类型： 空 
	*/
	public void init() throws ServletException {
		new RUN();
		System.out.println("初始化完成");
	}

}