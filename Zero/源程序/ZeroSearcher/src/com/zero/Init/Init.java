package com.zero.Init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.zero.Rmi.Del;
import com.zero.Rmi.IPlist;
import com.zero.util.UtilClass;

/** 
* <p>��  ����Init (servlet)
* <p>��  �ã�RMIԶ�̵��õĳ�ʼ������
* <br>�� ServletΪ��ʼ������
* <br>��ʼ�������RMI ע�����Ŀ��� ������������ע��
*/
public class Init extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031931666738966175L;

	/** 
	* <br>��������Init
	* <br>��  �ã� ���캯��
	* <br>��  ���� ��
	*/
	public Init() {
		super();
	}

	/** 
	* <br>��������destroy
	* <br>��  �ã� ϵͳ�˳�����ע����Ϣ
	* <br>��  ���� ��
	* <br>�������ͣ� �� 
	*/
	public void destroy() {
		super.destroy(); 
		IPlist.iplist.remove(UtilClass.getHostip());
	      for(int y=0;y<IPlist.iplist.size();y++){
		      	if(!(IPlist.iplist.get(y).toString().equals(UtilClass.getHostip()))){
               Del del=new Del(IPlist.iplist.get(y).toString(),UtilClass.getHostip());
               del.start();

               }
	      }	
		
	}
	
	/** 
	* <br>��������init
	* <br>��  �ã�servlet�ĳ�ʼ������
	* <br>��  ���� ��
	* <br>�������ͣ� �� 
	*/
	public void init() throws ServletException {
		new RUN();
		System.out.println("��ʼ�����");
	}

}