package com.zero.Sql;

/** 
	* <p>类  名：UserBean
	* <p>作  用：javaBean 用于封装从数据库中获取到的用户信息
	*/
public class UserBean {
	private int id;
	private String username;
	private String password;
	private int Manager;
	/** 
	* <br>函数名：UserBean
	* <br>作  用： 构造函数
	* <br>参  数： 无
	*/
    public UserBean() {
    }
	/** 
	* <br>函数名：getUsername
	* <br>作  用：获取用户名
	* <br>参  数： 无
	* <br>返回类型：字符串
	*/
    public String getUsername() {
        return username;
    }
	/** 
	* <br>函数名：setUsername
	* <br>作  用：设置用户名
	* <br>参  数： param
	* <br>返回类型： 空 
	*/
    public void setUsername(String param) {
        this.username = param;
    }
	/** 
	* <br>函数名：getPassword
	* <br>作  用：获取密码
	* <br>参  数： 无
	* <br>返回类型：String
	*/
    public String getPassword() {
       return password;
   }
	/** 
	* <br>函数名：setPassword
	* <br>作  用：设置密码
	* <br>参  数： param
	* <br>返回类型： 空 
	*/
   public void setPassword(String param) {
       this.password = param;
   }
	/** 
	* <br>函数名：getId
	* <br>作  用：获取ID信息
	* <br>参  数： 无
	* <br>返回类型： int 
	*/
   public int getId() {
       return id;
   }
	/** 
	* <br>函数名：setId
	* <br>作  用：设置ID信息
	* <br>参  数： param
	* <br>返回类型： 空 
	*/
   public void setId(int param) {
       this.id = param;
   }
	/** 
	* <br>函数名：getManager
	* <br>作  用：获取用户权限等级
	* <br>参  数： 无
	* <br>返回类型：int 
	*/
public int getManager() {
	return Manager;
}
/** 
* <br>函数名：setManager
* <br>作  用：设置用户权限等级
* <br>参  数： manager
* <br>返回类型：空 
*/
public void setManager(int manager) {
	Manager = manager;
}

}