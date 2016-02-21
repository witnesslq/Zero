package com.zero.Rmi;

import java.io.Serializable;
import java.util.ArrayList;

/** 
* <p>类名：IPlist
* <p>作  用：结果记录单元 实现 检索结果远程的传递模型 
*/
 
public class IPlist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3109367989252595406L;
	
	/** 
	* <br>变量名：IPlist
	* <br>作  用：记录IP地址列表 
	*/
	public static ArrayList<String> iplist= new ArrayList<String>();     //记录IP地址列表
}