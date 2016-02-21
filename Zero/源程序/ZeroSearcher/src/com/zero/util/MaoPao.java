package com.zero.util;

import com.zero.Rmi.FinalResult;
import com.zero.domainModel.Result;

public class MaoPao {
	
	public  void Sort() { 
		 
        for (int i = FinalResult.getFresultsize() - 1; i > 0; i--) { 
    	
            for (int j = 0; j < i; j++) { 
            	Result xx1=(Result)FinalResult.getFresult(j);
            	Result xx2=(Result)FinalResult.getFresult(j+1);

                if ((int)xx1.getPrice() < (int)xx2.getPrice()) {
                     Result temp;
                   temp=(Result)FinalResult.getFresult(j);
                   FinalResult.setFresult(j, FinalResult.getFresult(j+1));
                   FinalResult.setFresult(j+1, temp);
                } 
            } 
        } 


} 
}