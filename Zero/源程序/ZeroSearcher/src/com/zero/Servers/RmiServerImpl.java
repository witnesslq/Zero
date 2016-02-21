package com.zero.Servers;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.zero.Rmi.IPlist;
import com.zero.Rmi.Tongzhi;
import com.zero.Rmi.WriteIPlist;
import com.zero.domainModel.Result;
import com.zero.util.UtilClass;
import com.zero.xml.Xml;

/** 
 * <p>������RmiServerImpl
 * <p>��  �ã� RMI�ӿڷ�����ʵ���࣬ʵ�� �ӿ��� RmiServer ��������з���
 * <br> ��Զ�̵��õķ��� 
 *  
 */ 
public class RmiServerImpl extends UnicastRemoteObject implements RmiServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8939556682681339559L;
	
	String Host=UtilClass.getHostip();
	
    public RmiServerImpl() throws RemoteException {
        super();
    }
    
    /** 
     * <br>��������Loginin
     * <br>��  �ã� Զ�̵��õ�ʵ�ַ�����ʵ���� ��������¼����
     * <br>��  ���� String ip
     * <br>�������� boolean  
     *  
     */ 

  public boolean Loginin(String ip)throws RemoteException {
      String inip=ip;
      if(!(IPlist.iplist.contains(ip))){
  	   IPlist.iplist.add(ip);
      }  	   
  	  System.out.println("��ǰ���߷�����������"+IPlist.iplist.size());
  	  System.out.println();
  	  for(int shu=0;shu<IPlist.iplist.size();shu++){
  		  String dizhi=IPlist.iplist.get(shu).toString();
  	      if(!(dizhi.equals(inip) || dizhi.equals(Host))){
  	    	  Tongzhi tong=new Tongzhi(IPlist.iplist.get(shu).toString(),ip);
  	          tong.start();	
  	      }
  	  }
  	  WriteIPlist.go();    //��IP�б�д���ļ���ȥ     	    
  	  return true;
   }
  
  
  /** 
   * <br>��������Loginout
   * <br>��  �ã� Զ�̵��õ�ʵ�ַ�����ʵ���� �������˳�����
   * <br>��  ���� String ip
   * <br>�������� boolean  
   *  
   */
  public boolean Loginout(String ip)throws RemoteException {
  	
		try{
		  for(int p=0;p<IPlist.iplist.size();p++){
		    if(IPlist.iplist.get(p).toString().equals(ip)){
		      IPlist.iplist.remove(p);
		      
//���Ե�
	   for(int y=0;y<IPlist.iplist.size();y++){
	  	   	System.out.println("Del "+IPlist.iplist.get(y).toString());
	  	   }
  	 //���Ե� 
		      
		      break;
		      }
		   }
		   return true;
		}catch(Exception e){return false;}
  	        
   }
  /** 
   * <br>��������getIPlist
   * <br>��  �ã� Զ�̵��õ�ʵ�ַ������ӷ������ϻ�ȡ���������б�
   * <br>��  ���� ��
   * <br>�������� ArrayList  
   *  
   */
   public ArrayList<String> getIPlist()throws RemoteException {
   	
   	return IPlist.iplist;
   	
   } 
/*
 *����鷽��ʵ�����
 */   
   
//ԭ  Client  ����
   
   /** 
    * <br>��������addip
    * <br>��  �ã� Զ�̵��õ�ʵ�ַ�������������������ip��ַ
    * <br>��  ���� String ip
    * <br>�������� ������  
    *  
    */
   public  boolean addip(String ip)throws RemoteException{
		if(!(IPlist.iplist.contains(ip))){
		    IPlist.iplist.add(ip);
		    System.out.println("����"+ip+"client��ӳɹ�");
		    
		    WriteIPlist.go();       //��IP�б�д���ļ���ȥ   
		    
		   }
 
  	 return true;
		
	}
	
   /** 
    * <br>��������delip
    * <br>��  �ã� Զ�̵��õ�ʵ�ַ�������ip�б�ɾ��ָ����ip
    * <br>��  ���� String ip
    * <br>�������� ������  
    *  
    */
	public  boolean delip(String ip) throws RemoteException {
		try{
		  for(int p=0;p<IPlist.iplist.size();p++){
		    if(IPlist.iplist.get(p).toString().equals(ip)){
		      IPlist.iplist.remove(p);
		      
//���Ե�
	   for(int y=0;y<IPlist.iplist.size();y++){
	  	   	System.out.println("Del: "+IPlist.iplist.get(y).toString());
	  	   }
 //���Ե� 
		      
		      break;
		      }
		   }
		   return true;
		}catch(Exception e){return false;}

	}
	
	   
	
	
/*
 *ʵ�ּ���ģ��
 *
 */	
	   /** 
	    * <br>��������jiansuo
	    * <br>��  �ã� Զ�̵��õ�ʵ�ַ�������Ҫ������������������ʵ�֣�ͨ���������Զ����Դ�ļ���
	    * <br>��  ���� ArrayList str,String kind,String type
	    * <br>�������� ArrayList 
	    *  
	    */	
 public ArrayList<Result> jiansuo(List<String> str,String kind,String type) throws RemoteException {
      try{
          Xml xm=new Xml();
          return xm.getString(str,kind,type);        //������������ �������ݡ����͡�������ʽ
      }catch(UnsupportedEncodingException e){ }
	       return null;

    }
 
 /** 
  * <br>��������getPath
  * <br>��  �ã� Զ�̵��õ�ʵ�ַ�������ȡԶ�̷���������ʵĿ¼��Ϊ�˷�ֹ�������Ŀ¼�����Ҳ�����BUG
  * <br>��  ���� û��
  * <br>�������� String 
  *  
  */
 public String getPath() throws RemoteException {

    //���ط�������ʵվ���ַ
	return UtilClass.realPath.substring(UtilClass.realPath.lastIndexOf("\\",UtilClass.realPath.length()-2)+1,UtilClass.realPath.length()-1);
	
 }
 
}