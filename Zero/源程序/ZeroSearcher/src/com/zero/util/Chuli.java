package com.zero.util;
public class Chuli {

	public String chuli(String url) {
		String paths=url.substring(url.lastIndexOf("."));
		if(paths.equals(".doc")||paths.equals(".ppt")||paths.equals(".xls")){
			return url.substring(0, url.lastIndexOf("."))+".htm";
		}else
			if(paths.equals(".mp3")||paths.equals(".avi")||paths.equals(".flv")||paths.equals(".swf")){
				return "http://"+UtilClass.getHostip()+":3316"+"/play/index.asp?dizhi="+url;
//�˴���ַ 192.168.18.31��3316  ���÷�������ǰ��ַ����xml�����ȡ����	
	    	}else{
	    		return url;
	    	}
		}
}