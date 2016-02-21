package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.Servers.RmiServerImpl;
import com.zero.util.UtilClass;

/** 
* <p>类名：MainServer
* <p>作  用： RMI 远程调用的初始化工作 
* <br>包括：从XML文件获取服务器列表、向主服务器注册、获取主机列表 
*/
 
public class MainServer {
	
	/** 
	* <br>函数名：Server
	* <br>作  用：获取 xml 文件里面的 信息 并执行 Loginin 操作 向主服务器注册 
	*/
    public void Server() {
           String Host=UtilClass.getHostip();
           String Remo=UtilClass.getRemoteip();
           RmiServer diaoyong=null;
        try {
           
            RmiServerImpl rmi = new RmiServerImpl();
            Naming.rebind("Ser", rmi);
      	     
            diaoyong=(RmiServer) Naming.lookup("rmi://" + Remo + "/Ser");
            
            if(diaoyong.Loginin(Host)){
            	System.out.println("主机加入成功");
            }
        } catch (Exception e) {
       	 
        	 try{
        		 System.out.println("主服务器连接失败，开始选举服务器。。。。。");
        		 boolean ok=false;
    			   ReadIPlist.go();

    			   for(int sele=0;sele<UtilClass.Select.size();sele++){
                    if((!UtilClass.Select.get(sele).equals(UtilClass.getHostip())) && (ok==false)){
                    	
    				   diaoyong=(RmiServer) Naming.lookup("rmi://" + UtilClass.Select.get(sele) + "/Ser");
    	                
    				   if(diaoyong.Loginin(Host)){
    	        	          System.out.println("主机加入成功");
    	        	          ok=true;
    	        	          break;
    	                 }
                    }
                 }
    			   
    			   if(ok==false){
    				   diaoyong=(RmiServer) Naming.lookup("rmi://" + Host + "/Ser");
   	                
    				   if(diaoyong.Loginin(Host)){
    	        	          System.out.println("主机加入成功");
    	        	          ok=true;
    	                 }
    			   }

    	     }catch(Exception ee){System.out.println("错误"+ee);}
        	
        }
          
        try{
            
			IPlist.iplist=diaoyong.getIPlist();
             
             //测试代码
             System.out.println("当前的IP地址列表数量为："+IPlist.iplist.size());
            for(int i=0;i<IPlist.iplist.size();i++){
               	System.out.println(IPlist.iplist.get(i).toString());
               }
            WriteIPlist.go();           
            
        	System.out.println("IP地址列表打印完毕");
            
            //测试代码
                 
            
        } catch (Exception e) {
            System.out.println("错误: " + e);
        }
    }
}