package com.zero.Servers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.zero.domainModel.Result;

/** 
* <p>接口名：RmiServer
* <p>作  用：RMI 的接口类，实现分布式远程调用方法的接口 
*/
public interface RmiServer extends Remote { 

// 原  Server  方法
	/** 
	* <br>函数名：Loginin
	* <br>作  用：服务器登录 
	*/
	boolean Loginin(String ip)throws RemoteException ;    //服务器的登录
	
 /** 
	* <br>函数名：Loginout
	* <br>作  用：服务器退出 
	*/
	 boolean Loginout(String ip)throws RemoteException ;   //服务器的退出
 
	/** 
	* <br>函数名：getIPlist
	* <br>作  用：获取ip地址列表
	*/
	 ArrayList<String> getIPlist()throws RemoteException ;         //返回IP地址列表
 
 //整合进来的 Client 方法
 
	/** 
	* <br>函数名：addip
	* <br>作  用：添加新加入的主机地址 
	*/
	boolean addip(String ip) throws RemoteException ;     //添加IP地址
 
	/** 
	* <br>函数名：delip
	* <br>作  用：删除指定地址
	*/
	boolean delip(String ip) throws RemoteException ;     //删除IP地址
 
	/** 
	* <br>函数名：getPath
	* <br>作  用：获取远程站点的真实目录 
	*/
	String getPath()throws RemoteException ;
 
	/** 
	* <br>函数名：jiansuo
	* <br>作  用：执行资源的远程检索 
	*/
	ArrayList<Result> jiansuo(List<String> txt,String kind,String type) throws RemoteException;     //资源检索方法
}