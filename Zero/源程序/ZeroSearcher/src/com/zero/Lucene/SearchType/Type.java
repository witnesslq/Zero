package com.zero.Lucene.SearchType;

import java.util.ArrayList;

public class Type {

	public static boolean Analysis(String key,ArrayList<String> txt,String type){
		if(type.equals("every")){
               //ѭ���ԱȲ�ѯ�ؼ����Ƿ����Ҫ��
			for(int index=0;index<txt.size();index++){
			  if (key.indexOf(txt.get(index).toString())!= -1){
				  return true;
			  }
			}
		}
		return false;
	}
}
//��������   Type.Analysis(keywords,searchContent,type);