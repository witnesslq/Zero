package com.zero.Rmi;

import java.util.ArrayList;

import com.zero.domainModel.Result;

/** 
* <p>������FinalResult
* <p>��  �ã���¼������� 
*/
public class FinalResult {
	/** 
	* <br>��������Fresult
	* <br>��  �ã���ż����Ľ�� 
	* <br>�������ͣ�ArrayList
	*/
	private static ArrayList<Result> Fresult=new ArrayList<Result>();      //��ż������
 
	/** 
	* <br>��������Computer
	* <br>��  �ã���¼�Ѿ��������ķ���������
	* <br>�������ͣ� ����
	*/
 	private static int Computer=0;                         //��¼�Ѿ������ķ���������
 
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