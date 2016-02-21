package com.zero.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.Filter;

import com.zero.domainModel.Result;

public class UtilClass {
	public static Filter filter1;
	public static Filter filter2;
	public static Filter filter3;
	public static List<Result> result ;
	/** 
	* <br>变量名：Path
	* <br>作  用：记录服务器站点目录的真实地址
	*/	
	public static String realPath="";

	public static ArrayList<String> Select= new ArrayList<String>();
	/** 
	* <br>变量名：Hostip
	* <br>作  用：记录本机ip地址
	* <br>类型： String 
	*/
     private static String Hostip;       //记录本机 IP 地址
 	/** 
 	* <br>变量名：Remoteip
 	* <br>作  用：记录服务器ip地址
 	* <br>类型： String 
 	*/
     private static String Remoteip;     //记录需要连接的服务器地址
	/** 
	* <br>函数名：getHostip
	* <br>作  用： 获取本机ip地址
	* <br>参  数： 无
	* <br>返回类型： String 
	*/
   public static String getHostip() {
		return Hostip;
	}
	/** 
	* <br>函数名：setHostip
	* <br>作  用： 设置本机ip地址
	* <br>参  数： hostip
	* <br>返回类型： 空 
	*/
	public static void setHostip(String hostip) {
		Hostip = hostip;
	}
	/** 
	* <br>函数名：getRemoteip
	* <br>作  用： 获取服务器ip地址
	* <br>参  数： 无
	* <br>返回类型： String 
	*/
	public static String getRemoteip() {
		return Remoteip;
	}
	/** 
	* <br>函数名：setRemoteip
	* <br>作  用： 获取本机ip地址
	* <br>参  数： remoteip
	* <br>返回类型： 空 
	*/
	public static void setRemoteip(String remoteip) {
		Remoteip = remoteip;
	}
	
	/** 
	* <br>函数名：getPath 
	* <br>作  用：得到tomcat根目录下面某个文件夹的路径 
	* <br>参  数：tomcat根目录下面的某个文件夹 
	* <br>返回值：字符串 
	*/    
	public static String getPath(String Webapps){
		
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
