package com.zero.Servers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.zero.domainModel.Result;

/** 
* <p>�ӿ�����RmiServer
* <p>��  �ã�RMI �Ľӿ��࣬ʵ�ֲַ�ʽԶ�̵��÷����Ľӿ� 
*/
public interface RmiServer extends Remote { 

// ԭ  Server  ����
	/** 
	* <br>��������Loginin
	* <br>��  �ã���������¼ 
	*/
	boolean Loginin(String ip)throws RemoteException ;    //�������ĵ�¼
	
 /** 
	* <br>��������Loginout
	* <br>��  �ã��������˳� 
	*/
	 boolean Loginout(String ip)throws RemoteException ;   //���������˳�
 
	/** 
	* <br>��������getIPlist
	* <br>��  �ã���ȡip��ַ�б�
	*/
	 ArrayList<String> getIPlist()throws RemoteException ;         //����IP��ַ�б�
 
 //���Ͻ����� Client ����
 
	/** 
	* <br>��������addip
	* <br>��  �ã�����¼����������ַ 
	*/
	boolean addip(String ip) throws RemoteException ;     //���IP��ַ
 
	/** 
	* <br>��������delip
	* <br>��  �ã�ɾ��ָ����ַ
	*/
	boolean delip(String ip) throws RemoteException ;     //ɾ��IP��ַ
 
	/** 
	* <br>��������getPath
	* <br>��  �ã���ȡԶ��վ�����ʵĿ¼ 
	*/
	String getPath()throws RemoteException ;
 
	/** 
	* <br>��������jiansuo
	* <br>��  �ã�ִ����Դ��Զ�̼��� 
	*/
	ArrayList<Result> jiansuo(List<String> txt,String kind,String type) throws RemoteException;     //��Դ��������
}