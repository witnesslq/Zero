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
          
          // 指示应用程序要从 URL 连接读取数据
          con.setDoOutput(true);  
          con.setDoInput(true);
          con.connect(); 
          
          InputStream is = con.getInputStream();         
           HSLFSlideShow hss = new HSLFSlideShow(is);
           //is 为文件的InputStream，建立SlideShow
           SlideShow ss = new SlideShow(hss); 
           //获得每一张幻灯片
           Slide[] slides = ss.getSlides();           
          //因为我只是 预览，所以我限定 最多 读前两张幻灯片
           for(int i=0;(i<slides.length)&&(i<2);i++){   
               //为了取得幻灯片的文字内容，建立TextRun。
               TextRun[] t = slides[i].getTextRuns();    
                   for(int j=0;j<t.length;j++){
                	      String pptext=null;
                	      try{ 
                	    	   pptext= t[j].getText();
                	            //这里会将文字内容加到content中去
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