package com.zero.Rmi;

import java.util.ArrayList;

import com.zero.domainModel.Result;

/** 
 * <p>������ShowSearch
 * <p>��  �ã� ����ʱ�����������ʾ
 *  
 */
public class ShowSearch{
	
    ShowSearch(ArrayList<Result> res){
		 
		Result result;
		for(int liang=0;liang<res.size();liang++){
			
             result = res.get(liang);
                System.out.println(result.getId()+"  "+result.getTitle());
              	
              	
               }
		
	}
}