package com.zero.Action;

import org.apache.struts.action.ActionForm;

/**
 * <p>������DeleteResourceForm
 * <p>���ã�ɾ����ԴAction��formbean���洢�ύ������Ҫɾ������Դ
 */
public class DeleteForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private String[] deleteName=new String [0];
	
	/**
	 * <br>��������getdeleteName
	 * <br>���ã���ȡҪɾ����Դ��Name�б�
	 */
	public String [] getdeleteName() {
		return deleteName;
	}
	
	/**
	 * <br>��������setdeleteName
	 * <br>���ã�����Ҫɾ����Դ��Name�б�
	 */
	public void setdeleteName(String [] deleteName) {
		this.deleteName = deleteName;
	}

}