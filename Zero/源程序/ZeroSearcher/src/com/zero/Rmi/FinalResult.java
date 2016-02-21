package com.zero.Rmi;

import java.util.ArrayList;

import com.zero.domainModel.Result;

/** 
* <p>类名：FinalResult
* <p>作  用：记录检索结果 
*/
public class FinalResult {
	/** 
	* <br>函数名：Fresult
	* <br>作  用：存放检索的结果 
	* <br>数据类型：ArrayList
	*/
	private static ArrayList<Result> Fresult=new ArrayList<Result>();      //存放检索结果
 
	/** 
	* <br>函数名：Computer
	* <br>作  用：记录已经检索过的服务器数量
	* <br>数据类型： 整型
	*/
 	private static int Computer=0;                         //记录已经检索的服务器数量
 
 	public static void setFresult(Result r){
 		Fresult.add(r);
 	}
 
 	public static void addComputer(){
 		Computer++;
	}

 	public static void deleteComputer(){
 		Computer--;
 	}
 	
 	public static int getComputerContent(){
 		return Computer;
 	}

	public static int getFresultsize() {
		// TODO Auto-generated method stub
		return Fresult.size();
	}

	public static Result getFresult(int j) {
		// TODO Auto-generated method stub
		return Fresult.get(j);
	}

	public static void setFresult(int j, Result r) {
		// TODO Auto-generated method stub
		Fresult.set(j, r);
	}
	
	public static void setComputer(int i){
		Computer = i;
	}
	
	public static void clearFresult(){
		Fresult.clear();
	}
}