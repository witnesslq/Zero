package com.zero.Sql;

/** 
	* <p>��  ����UserBean
	* <p>��  �ã�javaBean ���ڷ�װ�����ݿ��л�ȡ�����û���Ϣ
	*/
public class UserBean {
	private int id;
	private String username;
	private String password;
	private int Manager;
	/** 
	* <br>��������UserBean
	* <br>��  �ã� ���캯��
	* <br>��  ���� ��
	*/
    public UserBean() {
    }
	/** 
	* <br>��������getUsername
	* <br>��  �ã���ȡ�û���
	* <br>��  ���� ��
	* <br>�������ͣ��ַ���
	*/
    public String getUsername() {
        return username;
    }
	/** 
	* <br>��������setUsername
	* <br>��  �ã������û���
	* <br>��  ���� param
	* <br>�������ͣ� �� 
	*/
    public void setUsername(String param) {
        this.username = param;
    }
	/** 
	* <br>��������getPassword
	* <br>��  �ã���ȡ����
	* <br>��  ���� ��
	* <br>�������ͣ�String
	*/
    public String getPassword() {
       return password;
   }
	/** 
	* <br>��������setPassword
	* <br>��  �ã���������
	* <br>��  ���� param
	* <br>�������ͣ� �� 
	*/
   public void setPassword(String param) {
       this.password = param;
   }
	/** 
	* <br>��������getId
	* <br>��  �ã���ȡID��Ϣ
	* <br>��  ���� ��
	* <br>�������ͣ� int 
	*/
   public int getId() {
       return id;
   }
	/** 
	* <br>��������setId
	* <br>��  �ã�����ID��Ϣ
	* <br>��  ���� param
	* <br>�������ͣ� �� 
	*/
   public void setId(int param) {
       this.id = param;
   }
	/** 
	* <br>��������getManager
	* <br>��  �ã���ȡ�û�Ȩ�޵ȼ�
	* <br>��  ���� ��
	* <br>�������ͣ�int 
	*/
public int getManager() {
	return Manager;
}
/** 
* <br>��������setManager
* <br>��  �ã������û�Ȩ�޵ȼ�
* <br>��  ���� manager
* <br>�������ͣ��� 
*/
public void setManager(int manager) {
	Manager = manager;
}

}