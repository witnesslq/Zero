package com.zero.Init;

import java.rmi.registry.LocateRegistry;

import com.zero.Rmi.MainServer;
import com.zero.util.UtilClass;



/** 
* <p>������RUN
* <p>��  �ã� �ֲ�ʽ�ĳ�ʼ�������ӿڣ��� servlrt �ڷ�����������ʱ����е��� 
*  
*/
public class RUN{
	/** 
	* <br>��������RUN
	* <br>��  �ã����췽������ servlrt �ڷ�����������ʱ����е��� 
	*  
	*/
	public  RUN(){
		
	try{	
		new InitRmi();
		
		System.out.println("������ַ�� " + UtilClass.getHostip());
		System.out.println("ע���ַ�� " + UtilClass.getRemoteip());
		
		LocateRegistry.createRegistry(1099);  //���� rmiע����� 
		
		MainServer run=new MainServer();
		run.Server();
		
	}catch(Exception e){System.out.println("ϵͳ����");}
	}
}