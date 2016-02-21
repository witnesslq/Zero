package com.zero.Rmi;

import java.util.ArrayList;

import com.zero.domainModel.Result;

/** 
 * <p>类名：ShowSearch
 * <p>作  用： 测试时检索结果的显示
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