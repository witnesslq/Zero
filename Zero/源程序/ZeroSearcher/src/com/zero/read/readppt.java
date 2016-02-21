package com.zero.read;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class readppt{

	public static String getPptStr(String fileName) throws UnsupportedEncodingException {
          
		String pathq=new String(fileName.getBytes("UTF-8"));

	//String pathq=fileName;
		
      StringBuffer content = new StringBuffer("");
      try{
    	  String file = pathq ;
    	  URL url = new URL(file);
    	  HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	 
    	  con.setDefaultUseCaches(false);   
          con.setUseCaches(false);   
          
          // ָʾӦ�ó���Ҫ�� URL ���Ӷ�ȡ����
          con.setDoOutput(true);  
          con.setDoInput(true);
          con.connect(); 
          
          InputStream is = con.getInputStream();         
           HSLFSlideShow hss = new HSLFSlideShow(is);
           //is Ϊ�ļ���InputStream������SlideShow
           SlideShow ss = new SlideShow(hss); 
           //���ÿһ�Żõ�Ƭ
           Slide[] slides = ss.getSlides();           
          //��Ϊ��ֻ�� Ԥ�����������޶� ��� ��ǰ���Żõ�Ƭ
           for(int i=0;(i<slides.length)&&(i<2);i++){   
               //Ϊ��ȡ�ûõ�Ƭ���������ݣ�����TextRun��
               TextRun[] t = slides[i].getTextRuns();    
                   for(int j=0;j<t.length;j++){
                	      String pptext=null;
                	      try{ 
                	    	   pptext= t[j].getText();
                	            //����Ὣ�������ݼӵ�content��ȥ
                	      }catch(Exception e){
                	    	   e.printStackTrace();
                	    	   continue;
                	      }
                	      content.append(pptext);         
                          }
                 }
       
           }catch(Exception ex){
                    System.out.println(ex.toString());
           }
           return content.toString().trim();
    }
    

}