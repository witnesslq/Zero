package com.zero.read;

import java.io.InputStream;

import org1.textmining.text.extraction.WordExtractor;


 public class readword2 {

	public static String getDocContent(String url) {
		String str = " ";
		InputStream in = null;
		in = GetRemoteResource.getInputStream(url);
		//���������������˵���ļ�������
		if(in==null) return "�ļ������ڣ�����";

		try {
			WordExtractor extractor = new WordExtractor();
			//��ȡword�ĵ��е�����
			str = extractor.extractText(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//���word�ĵ��е���������100����ȡ��100���������ȡ�����е�����
		if(str.trim().length()<100){
			return str.trim();	
		}
		return str.trim();
	}	

}