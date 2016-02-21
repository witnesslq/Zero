package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.util.UtilClass;

/** 
 * <p>类名：Tongzhi
 * <p>作  用： 继承 Thread 类 通知其他主机有新主机加入 并告知新主机的ip
 *  
 */
public class Tongzhi extends Thread{
	String LocalIP=UtilClass.getHostip();;    //  后期改动
	String path="";
	String Message="";
	public Tongzhi(String ip,String str){
		path=ip;
		Message=str;     //通知指定的ip
 
	}
	
	 /** 
	  * <br>函数名：run
	  * <br>作  用： 线程的执行方法，通知其他主机有新主机加入
	  * <br>参  数： 没有
	  * <br>返回类型 void 
	  *  
	  */

		public void run(){
          try{
                System.out.println("Tongzhi绑定端口"+path);
               RmiServer diaoyong=(RmiServer) Naming.lookup("rmi://" + path + "/Ser");
               
               if(diaoyong.addip(Message)){
               	
                 System.out.println("向远程机器"+path+"添加"+Message+"成功");
            /*测试
            	   for(int y=0;y<IPlist.iplist.size();y++){
            	  	   	System.out.println(IPlist.iplist.get(y).toString());
            	  	   }
            	   
          测试 */
               }
               
		} catch(Exception e){System.out.println("连接失败");}
	}
	
}