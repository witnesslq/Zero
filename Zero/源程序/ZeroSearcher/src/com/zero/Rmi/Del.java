package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.util.UtilClass;

/** 
* <p>������Del
* <p>��  �ã�����̳� Tread ����֪ͨԶ������ɾ���ض���ip��ַ 
*/
public class Del extends Thread{
	String LocalIP=UtilClass.getHostip();    //  ���ڸĶ�
	String path="";
	String Message="";
	
	/** 
	* <br>��������Del
	* <br>��  �ã����캯�������ò�����������ɾ��ָ��ip��ַ���߳� 
	*/
	public Del(String ip,String str){
		path=ip;
		Message=str;     //ָ֪ͨ����ip
 
	}
	
	/** 
	* <br>��������run
	* <br>��  �ã�ִ��ɾ��ָ��������ַ���߳� 
	*/
	public void run(){
          try{
                System.out.println("Tongzhi�󶨶˿�"+path);
             RmiServer diaoyong=(RmiServer) Naming.lookup("rmi://" + path + "/Ser");
               
               if(diaoyong.delip(Message)){
               	
                 System.out.println("��Զ�̻���"+path+"ɾ��"+Message+"�ɹ�");
            /*����
            	   for(int y=0;y<IPlist.iplist.size();y++){
            	  	   	System.out.println(IPlist.iplist.get(y).toString());
            	  	   }
            	   
           ����*/
               }
               
		} catch(Exception e){System.out.println("����ʧ��");}
	}
	
}