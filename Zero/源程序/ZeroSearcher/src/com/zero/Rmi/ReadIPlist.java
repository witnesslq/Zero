package com.zero.Rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.zero.util.UtilClass;

public class ReadIPlist { 
	
	public static void go(){
	
		BufferedReader bufread; 
        String read; 
//        String readStr = ""; 
        try { 
        	
            File file = new File(UtilClass.realPath+"SQL\\iplist.data"); 
            FileReader fileread = new FileReader(file); 
            bufread = new BufferedReader(fileread); 
            while ((read = bufread.readLine()) != null) { 
            	
                UtilClass.Select.add(read); 
            } 
           
        } catch (Exception d) { 
            System.out.println(d.getMessage()); 
        } 
    }
}