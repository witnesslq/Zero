package com.zero.read;

import java.io.InputStream;

import org1.textmining.text.extraction.WordExtractor;


 public class readword2 {

	public static String getDocContent(String url) {
		String str = " ";
		InputStream in = null;
		in = GetRemoteResource.getInputStream(url);
		//如果无输入流，则说明文件不存在
		if(in==null) return "文件不存在！！！";

		try {
			WordExtractor extractor = new WordExtractor();
			//获取word文档中的内容
			str = extractor.extractText(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//如果word文档中的字数多余100，就取出100个，否则就取出所有的字数
		if(str.trim().length()<100){
			return str.trim();	
		}
		return str.trim();
	}	

}