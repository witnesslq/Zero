package com.zero.Rmi;

import java.rmi.Naming;

import com.zero.Servers.RmiServer;
import com.zero.util.UtilClass;

/** 
 * <p>������Tongzhi
 * <p>��  �ã� �̳� Thread �� ֪ͨ�������������������� ����֪��������ip
 *  
 */
public class Tongzhi extends Thread{
	String LocalIP=UtilClass.getHostip();;    //  ���ڸĶ�
	String path="";
	String Message="";
	public Tongzhi(String ip,String str){
		path=ip;
		Message=str;     //ָ֪ͨ����ip
 
	}
	
	 /** 
	  * <br>��������run
	  * <br>��  �ã� �̵߳�ִ�з�����֪ͨ��������������������
	  * <br>��  ���� û��
	  * <br>�������� void 
	  *  
	  */

		public void run(){
          try{
                System.out.println("Tongzhi�󶨶˿�"+path);
               RmiServer diaoyong=(RmiServer) Naming.lookup("rmi://" + path + "/Ser");
               
               if(diaoyong.addip(Message)){
               	
                 System.out.println("��Զ�̻���"+path+"���"+Message+"�ɹ�");
            /*����
            	   for(int y=0;y<IPlist.iplist.size();y++){
            	  	   	System.out.println(IPlist.iplist.get(y).toString());
            	  	   }
            	   
          ���� */
               }
               
		} catch(Exception e){System.out.println("����ʧ��");}
	}
	
}