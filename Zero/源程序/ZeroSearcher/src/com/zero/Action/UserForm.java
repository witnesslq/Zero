package com.zero.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * <p>��  ����UserForm (ActionForm)
 * <p>��  �ã���ȡ���ύ���ı���Ϣ
 */
public class UserForm extends ActionForm {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5527956570078669188L;
		String Manager;
	    String ID;
	    String username;
	    String password;
	    String command;
	    String confirm;
	    String[] check;
	    

		/** 
		* <br>��������getUsername
		* <br>��  �ã���ȡ�û���
		*/	   
	    public String getUsername() {
	        return username;
	    }
		/** 
		* <br>��������setUsername
		* <br>��  �ã������û���
		*/	 
	    public void setUsername(String param) {
	        this.username = param;
	    }
		/** 
		* <br>��������getPassword
		* <br>��  �ã���ȡ����
		*/	 
	    public String getPassword() {
	       return password;
	   }
		/** 
		* <br>��������setPassword
		* <br>��  �ã���������
		*/
	   public void setPassword(String param) {
	       this.password = param;
	   }
		/** 
		* <br>��������getCommand
		* <br>��  �ã���ȡ��ť��Ϣ
		*/
	   public String getCommand() {
	       return command;
	   }
		/** 
		* <br>��������setCommand
		* <br>��  �ã����ð�ť��Ϣ
		*/
	   public void setCommand(String param) {
	       this.command = param;
	   }
		/** 
		* <br>��������getConfirm
		* <br>��  �ã���ȡ�ύ����
		*/
	   public String getConfirm() {
	       return confirm;
	   }
		/** 
		* <br>��������setConfirm
		* <br>��  �ã������ύ����
		*/
	   public void setConfirm(String param) {
	       this.confirm = param;
	   }
		/** 
		* <br>��������getCheck
		* <br>��  �ã���ȡ�������Ϣ
		*/
	   public String[] getCheck(){
		   return check;
	   }
		/** 
		* <br>��������setCheck
		* <br>��  �ã����ñ������Ϣ
		*/
	   public void setCheck(String[] param) {
	       this.check = param;
	   }
		/** 
		* <br>��������validate
		* <br>��  �ã��޶���
		*/
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	/** 
	* <br>��������getID
	* <br>��  �ã���ȡID
	*/
	public String getID() {
		return ID;
	}
	/** 
	* <br>��������setID
	* <br>��  �ã�����ID
	*/
	public void setID(String id) {
		ID = id;
	}
	/** 
	* <br>��������getManager
	* <br>��  �ã���ȡȨ��
	*/
	public String getManager() {
		return Manager;
	}
	/** 
	* <br>��������setManager
	* <br>��  �ã�����Ȩ��
	*/
	public void setManager(String manager) {
		Manager = manager;
	}


}