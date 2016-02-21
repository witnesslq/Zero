package com.zero.util;

import java.util.ArrayList;

import com.zero.domainModel.Result;

public class QuickPaiXu {

	public Result resuj;

	public QuickPaiXu(){
		
	}

	  public void quickSort(ArrayList<Result> obj, int x, int y){
	       int i = x;
	       int j = y;
	       Result re= (Result)obj.get((x+y)/2);
	       double mid = re.getPrice();
		
	       while(i <= j){  
	    	   Result resui= (Result)obj.get(i);
	           while(resui.getPrice() < mid){
	               i ++;
	              resui= (Result)obj.get(i);
	           }
	           
	          resuj = obj.get(j);
	           while(resui.getPrice() > mid){
	               j --;
	               resuj= (Result)obj.get(j);
	           }
	           Result temp;
	           if(i <= j){
	               temp = (Result)obj.get(i);
	               obj.set(i, obj.get(j));
	               obj.set(j,temp);
	               i ++;
	               j --;
	           }            
	       }
	    
	       if(x < j){
	           quickSort(obj, x, j);
	       }
	       if(i < y){
	           
	           quickSort(obj, i, y);
	       }        
  }            
}