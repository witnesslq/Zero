package com.zero.Rmi;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.zero.util.UtilClass;

public class WriteIPlist {
  public static void go(){
	  
	  FileOutputStream out;   
	    PrintStream p;  
	try {   

	      out = new FileOutputStream(UtilClass.realPath+"SQL\\iplist.data");   
	 
	      p = new PrintStream( out );   
	      for(int hh=0;hh<IPlist.iplist.size();hh++){
	        p.println (IPlist.iplist.get(hh));   
	      }
	      p.close();   
	    } catch (Exception e) {   
	      System.err.println ("ipÁÐ±íÐ´ÈëÊ§°Ü");   
	    }   

	  
  }  
}