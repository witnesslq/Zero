package com.zero.Rmi;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import com.zero.Servers.RmiServer;
import com.zero.domainModel.Result;

/** 
* <p>������Mess
* <p>��  �ã� �̳� Tread Ϊ��Դ�ļ�������һ���������߳�
* <br> �����������̵߳���ʽΪÿһ�����м������߳����ò��� 
*  
*/
class Mess extends Thread{
      List<String> txt=null;
      String adress="";
      String kinds="";
      String types="";
      
      /** 
      * <br>��������Mess
      * <br>��  �ã� ���캯��Ϊִ�м������߳����ò��� 
      * <br>��  ���� ArrayList t,String kind,String type,String path
      */ 
	public Mess(List<String> str,String kind,String type,String path){
		super();
		txt=str;
		kinds=kind;
        types=type;
		adress=path;
		
	}
	
    /** 
     * <br>��������run
     * <br>��  �ã� ִ�м��� ͳ�Ƽ����Ľ�� 
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
   
           //�������Ľ����ʾģ��
                 
           //      new ShowSearch(shuju);
		     
		  }catch(Exception e){
		  	System.out.println("����"+adress+"ʧ��,ɾ����Ӧ�ĵ�ַ");
		     
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
 * <p>������SearchMess
 * <p>��  �ã� Ϊÿ���ȴ������ķ��������������̲߳��������õĲ�����ִ�м��� ͳ�Ƽ����Ľ�� 
 *  
 */ 
public class SearchMess{
	
	/** 
	 * <br>������SearchMess
	 * <br>��  �ã� ���캯�� ���ü����̵߳Ĳ���������ʼ����
	 *  
	 */ 
	public SearchMess(List<String> ppw,String kind,String type){
		List<String> str = ppw;
		 try{
		 	
		 	System.out.println("��ʼ����  "+str.size());
   

		     //���Դ���  
		       System.out.println(IPlist.iplist.size());
		       for(int s=0;s<str.size();s++){
		       	System.out.println(str.get(s).toString());
		       }
		      //���Դ���    
		       
		       
		  for(int i=0;i<IPlist.iplist.size();i++){
		         //ִ������
			  System.out.println("ִ������"+IPlist.iplist.get(i).toString());
		         Mess m=new Mess(str,kind,type,IPlist.iplist.get(i).toString());
		         m.start();
		      }   
		       
		      
		 }catch(Exception e){System.out.println("����ʧ��");}
	}
	
}