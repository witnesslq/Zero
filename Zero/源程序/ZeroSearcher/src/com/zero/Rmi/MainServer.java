package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.Servers.RmiServerImpl;
import com.zero.util.UtilClass;

/** 
* <p>������MainServer
* <p>��  �ã� RMI Զ�̵��õĳ�ʼ������ 
* <br>��������XML�ļ���ȡ�������б�����������ע�ᡢ��ȡ�����б� 
*/
 
public class MainServer {
	
	/** 
	* <br>��������Server
	* <br>��  �ã���ȡ xml �ļ������ ��Ϣ ��ִ�� Loginin ���� ����������ע�� 
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
            	System.out.println("��������ɹ�");
            }
        } catch (Exception e) {
       	 
        	 try{
        		 System.out.println("������������ʧ�ܣ���ʼѡ�ٷ���������������");
        		 boolean ok=false;
    			   ReadIPlist.go();

    			   for(int sele=0;sele<UtilClass.Select.size();sele++){
                    if((!UtilClass.Select.get(sele).equals(UtilClass.getHostip())) && (ok==false)){
                    	
    				   diaoyong=(RmiServer) Naming.lookup("rmi://" + UtilClass.Select.get(sele) + "/Ser");
    	                
    				   if(diaoyong.Loginin(Host)){
    	        	          System.out.println("��������ɹ�");
    	        	          ok=true;
    	        	          break;
    	                 }
                    }
                 }
    			   
    			   if(ok==false){
    				   diaoyong=(RmiServer) Naming.lookup("rmi://" + Host + "/Ser");
   	                
    				   if(diaoyong.Loginin(Host)){
    	        	          System.out.println("��������ɹ�");
    	        	          ok=true;
    	                 }
    			   }

    	     }catch(Exception ee){System.out.println("����"+ee);}
        	
        }
          
        try{
            
			IPlist.iplist=diaoyong.getIPlist();
             
             //���Դ���
             System.out.println("��ǰ��IP��ַ�б�����Ϊ��"+IPlist.iplist.size());
            for(int i=0;i<IPlist.iplist.size();i++){
               	System.out.println(IPlist.iplist.get(i).toString());
               }
            WriteIPlist.go();           
            
        	System.out.println("IP��ַ�б��ӡ���");
            
            //���Դ���
                 
            
        } catch (Exception e) {
            System.out.println("����: " + e);
        }
    }
}