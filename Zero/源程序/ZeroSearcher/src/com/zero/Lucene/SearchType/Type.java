package com.zero.Lucene.SearchType;

import java.util.ArrayList;

public class Type {

	public static boolean Analysis(String key,ArrayList<String> txt,String type){
		if(type.equals("every")){
               //循环对比查询关键字是否符合要求
			for(int index=0;index<txt.size();index++){
			  if (key.indexOf(txt.get(index).toString())!= -1){
				  return true;
			  }
			}
		}
		return false;
	}
}
//检索类型   Type.Analysis(keywords,searchContent,type);