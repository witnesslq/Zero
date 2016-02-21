package com.zero.Action;

import org.apache.struts.action.ActionForm;

/**
 * <p>类名：DeleteResourceForm
 * <p>作用：删除资源Action的formbean，存储提交上来的要删除的资源
 */
public class DeleteForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private String[] deleteName=new String [0];
	
	/**
	 * <br>函数名：getdeleteName
	 * <br>作用：获取要删除资源的Name列表
	 */
	public String [] getdeleteName() {
		return deleteName;
	}
	
	/**
	 * <br>函数名：setdeleteName
	 * <br>作用：设置要删除资源的Name列表
	 */
	public void setdeleteName(String [] deleteName) {
		this.deleteName = deleteName;
	}

}