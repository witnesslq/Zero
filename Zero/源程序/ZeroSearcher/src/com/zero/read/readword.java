package com.zero.read;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class readword {

  public  static String getWordStr(String file ) throws Exception{
	  
	 String pathw=new String(file.getBytes("UTF-8"),"gbk");

	    String result = null;
		WordExtractor wordExtractor = null;
		try {
			URL url = new URL(pathw);
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();


			wordExtractor = new WordExtractor(urlCon.getInputStream());
			
			result = wordExtractor.getText();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return(result); 
	    
	    
  }
}   
	    
	    
	/*    
	    
        try{
	         URL url = new URL(pathw);
		     HttpURLConnection connection = (HttpURLConnection) url.openConnection();	 		     		
		     doc = new HWPFDocument(connection.getInputStream());
		     
		     
        }catch(Exception  e){
        	return "有一个资源文件没有找到"+e.toString();
        }
        
        Range range = doc.getRange();
        int paragraphCount = range.numParagraphs();
        // 遍历段落读取数据
		for (int i = 0,j=0;i < paragraphCount&&j<7; i++) {			
			Paragraph pp = range.getParagraph(i);
			String pptext=null;
			try{
			       pptext=pp.text();
			}catch(Exception e){
				   continue;
			}
			content.append(pptext);
			j++;
		}		
		return content.toString().trim();	  
  }   
  
  */