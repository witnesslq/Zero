package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.util.UtilClass;

/** 
* <p>类名：Del
* <p>作  用：此类继承 Tread 用来通知远程主机删除特定的ip地址 
*/
public class Del extends Thread{
	String LocalIP=UtilClass.getHostip();    //  后期改动
	String path="";
	String Message="";
	
	/** 
	* <br>函数名：Del
	* <br>作  用：构造函数，设置参数用来创建删除指定ip地址的线程 
	*/
	public Del(String ip,String str){
		path=ip;
		Message=str;     //通知指定的ip
 
	}
	
	/** 
	* <br>函数名：run
	* <br>作  用：执行删除指定主机地址的线程 
	*/
	public void run(){
          try{
                System.out.println("Tongzhi绑定端口"+path);
             RmiServer diaoyong=(RmiServer) Naming.lookup("rmi://" + path + "/Ser");
               
               if(diaoyong.delip(Message)){
               	
                 System.out.println("向远程机器"+path+"删除"+Message+"成功");
            /*测试
            	   for(int y=0;y<IPlist.iplist.size();y++){
            	  	   	System.out.println(IPlist.iplist.get(y).toString());
            	  	   }
            	   
           测试*/
               }
               
		} catch(Exception e){System.out.println("连接失败");}
	}
	
}