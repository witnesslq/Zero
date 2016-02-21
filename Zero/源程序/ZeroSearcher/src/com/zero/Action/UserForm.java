package com.zero.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * <p>类  名：UserForm (ActionForm)
 * <p>作  用：获取所提交表单的表单信息
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
		* <br>函数名：getUsername
		* <br>作  用：获取用户名
		*/	   
	    public String getUsername() {
	        return username;
	    }
		/** 
		* <br>函数名：setUsername
		* <br>作  用：设置用户名
		*/	 
	    public void setUsername(String param) {
	        this.username = param;
	    }
		/** 
		* <br>函数名：getPassword
		* <br>作  用：获取密码
		*/	 
	    public String getPassword() {
	       return password;
	   }
		/** 
		* <br>函数名：setPassword
		* <br>作  用：设置密码
		*/
	   public void setPassword(String param) {
	       this.password = param;
	   }
		/** 
		* <br>函数名：getCommand
		* <br>作  用：获取按钮信息
		*/
	   public String getCommand() {
	       return command;
	   }
		/** 
		* <br>函数名：setCommand
		* <br>作  用：设置按钮信息
		*/
	   public void setCommand(String param) {
	       this.command = param;
	   }
		/** 
		* <br>函数名：getConfirm
		* <br>作  用：获取提交类型
		*/
	   public String getConfirm() {
	       return confirm;
	   }
		/** 
		* <br>函数名：setConfirm
		* <br>作  用：设置提交类型
		*/
	   public void setConfirm(String param) {
	       this.confirm = param;
	   }
		/** 
		* <br>函数名：getCheck
		* <br>作  用：获取表单检查信息
		*/
	   public String[] getCheck(){
		   return check;
	   }
		/** 
		* <br>函数名：setCheck
		* <br>作  用：设置表单检查信息
		*/
	   public void setCheck(String[] param) {
	       this.check = param;
	   }
		/** 
		* <br>函数名：validate
		* <br>作  用：无动作
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
	* <br>函数名：getID
	* <br>作  用：获取ID
	*/
	public String getID() {
		return ID;
	}
	/** 
	* <br>函数名：setID
	* <br>作  用：设置ID
	*/
	public void setID(String id) {
		ID = id;
	}
	/** 
	* <br>函数名：getManager
	* <br>作  用：获取权限
	*/
	public String getManager() {
		return Manager;
	}
	/** 
	* <br>函数名：setManager
	* <br>作  用：设置权限
	*/
	public void setManager(String manager) {
		Manager = manager;
	}


}