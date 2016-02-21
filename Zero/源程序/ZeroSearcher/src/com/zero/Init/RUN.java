package com.zero.Init;

import java.rmi.registry.LocateRegistry;

import com.zero.Rmi.MainServer;
import com.zero.util.UtilClass;



/** 
* <p>类名：RUN
* <p>作  用： 分布式的初始化操作接口，被 servlrt 在服务器开启的时候进行调用 
*  
*/
public class RUN{
	/** 
	* <br>函数名：RUN
	* <br>作  用：构造方法，被 servlrt 在服务器开启的时候进行调用 
	*  
	*/
	public  RUN(){
		
	try{	
		new InitRmi();
		
		System.out.println("本机地址： " + UtilClass.getHostip());
		System.out.println("注册地址： " + UtilClass.getRemoteip());
		
		LocateRegistry.createRegistry(1099);  //开启 rmi注册服务 
		
		MainServer run=new MainServer();
		run.Server();
		
	}catch(Exception e){System.out.println("系统错误");}
	}
}