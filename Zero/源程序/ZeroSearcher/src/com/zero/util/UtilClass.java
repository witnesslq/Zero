package com.zero.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.Filter;

import com.zero.domainModel.Result;

public class UtilClass {
	public static Filter filter1;
	public static Filter filter2;
	public static Filter filter3;
	public static List<Result> result ;
	/** 
	* <br>��������Path
	* <br>��  �ã���¼������վ��Ŀ¼����ʵ��ַ
	*/	
	public static String realPath="";

	public static ArrayList<String> Select= new ArrayList<String>();
	/** 
	* <br>��������Hostip
	* <br>��  �ã���¼����ip��ַ
	* <br>���ͣ� String 
	*/
     private static String Hostip;       //��¼���� IP ��ַ
 	/** 
 	* <br>��������Remoteip
 	* <br>��  �ã���¼������ip��ַ
 	* <br>���ͣ� String 
 	*/
     private static String Remoteip;     //��¼��Ҫ���ӵķ�������ַ
	/** 
	* <br>��������getHostip
	* <br>��  �ã� ��ȡ����ip��ַ
	* <br>��  ���� ��
	* <br>�������ͣ� String 
	*/
   public static String getHostip() {
		return Hostip;
	}
	/** 
	* <br>��������setHostip
	* <br>��  �ã� ���ñ���ip��ַ
	* <br>��  ���� hostip
	* <br>�������ͣ� �� 
	*/
	public static void setHostip(String hostip) {
		Hostip = hostip;
	}
	/** 
	* <br>��������getRemoteip
	* <br>��  �ã� ��ȡ������ip��ַ
	* <br>��  ���� ��
	* <br>�������ͣ� String 
	*/
	public static String getRemoteip() {
		return Remoteip;
	}
	/** 
	* <br>��������setRemoteip
	* <br>��  �ã� ��ȡ����ip��ַ
	* <br>��  ���� remoteip
	* <br>�������ͣ� �� 
	*/
	public static void setRemoteip(String remoteip) {
		Remoteip = remoteip;
	}
	
	/** 
	* <br>��������getPath 
	* <br>��  �ã��õ�tomcat��Ŀ¼����ĳ���ļ��е�·�� 
	* <br>��  ����tomcat��Ŀ¼�����ĳ���ļ��� 
	* <br>����ֵ���ַ��� 
	*/    
	public static String getPath(String Webapps){
		
		//�ڱ���Ŀ¼���½�һ���ļ���Ž�����ڲ��� �����Ƿ���ȷ
		String   path   =  System.getProperty("catalina.home");	
		
		/*��Ϊ��ͬ�Ļ����� user��dirָ����е���tomcat��Ŀ¼���е���binĿ¼��
		 * ���� ����� bin��λ�ý����жϣ����Ŀ¼�к���bin�򣬽��� ȥ��binĿ¼�Ĵ���
		 * ���� ���ܵõ� tomcat�ĸ�Ŀ¼�ˡ�
		 */
		int binindex=path.lastIndexOf("bin");
       if(binindex!=-1){
       	path=path.substring(0, binindex-1);
       }
		
		path=path+"\\"+Webapps;
		return path;
		
	}
}
