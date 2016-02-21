package com.zero.Rmi;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import com.zero.Servers.RmiServer;
import com.zero.domainModel.Result;

/** 
* <p>类名：Mess
* <p>作  用： 继承 Tread 为资源的检索分配一个独立的线程
* <br> 此类自身以线程的形式为每一个进行检索的线程设置参数 
*  
*/
class Mess extends Thread{
      List<String> txt=null;
      String adress="";
      String kinds="";
      String types="";
      
      /** 
      * <br>函数名：Mess
      * <br>作  用： 构造函数为执行检索的线程设置参数 
      * <br>参  数： ArrayList t,String kind,String type,String path
      */ 
	public Mess(List<String> str,String kind,String type,String path){
		super();
		txt=str;
		kinds=kind;
        types=type;
		adress=path;
		
	}
	
    /** 
     * <br>函数名：run
     * <br>作  用： 执行检索 统计检索的结果 
     *  
     */ 
	public void run(){
		
		  try{
		        
		     
		      RmiServer fa=(RmiServer) Naming.lookup("rmi://" + adress + "/Ser");
		          
		         ArrayList<Result> shuju=null;
		        
                 shuju= fa.jiansuo(txt,kinds,types);
                 
                 for(int j=0;j<shuju.size();j++){
                     FinalResult.setFresult(shuju.get(j));
                   }            
                 
                 FinalResult.addComputer();
   
           //早期做的结果显示模块
                 
           //      new ShowSearch(shuju);
		     
		  }catch(Exception e){
		  	System.out.println("检索"+adress+"失败,删除相应的地址");
		     
		      for(int y=0;y<IPlist.iplist.size();y++){
		      	if(!(IPlist.iplist.get(y).toString().equals(adress))){
                 Del del=new Del(IPlist.iplist.get(y).toString(),adress);
                 del.start();

                 }
            	}
		   
		    }
		 
	}
}

/** 
 * <p>类名：SearchMess
 * <p>作  用： 为每个等待检索的服务器创建检索线程并传入设置的参数，执行检索 统计检索的结果 
 *  
 */ 
public class SearchMess{
	
	/** 
	 * <br>类名：SearchMess
	 * <br>作  用： 构造函数 设置检索线程的参数，并开始检索
	 *  
	 */ 
	public SearchMess(List<String> ppw,String kind,String type){
		List<String> str = ppw;
		 try{
		 	
		 	System.out.println("开始检索  "+str.size());
   

		     //测试代码  
		       System.out.println(IPlist.iplist.size());
		       for(int s=0;s<str.size();s++){
		       	System.out.println(str.get(s).toString());
		       }
		      //测试代码    
		       
		       
		  for(int i=0;i<IPlist.iplist.size();i++){
		         //执行搜索
			  System.out.println("执行搜索"+IPlist.iplist.get(i).toString());
		         Mess m=new Mess(str,kind,type,IPlist.iplist.get(i).toString());
		         m.start();
		      }   
		       
		      
		 }catch(Exception e){System.out.println("检索失败");}
	}
	
}