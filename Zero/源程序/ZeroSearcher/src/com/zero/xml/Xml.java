package com.zero.xml;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zero.domainModel.Result;
import com.zero.util.Turnred;
import com.zero.util.UtilClass;

/** 
 * <p>��  ���� xml
 * <p>��  �ã� ��Դ������ִ��ģ�� ����XML�ĵ����ܹ����ݲ�ͬ�ļ�����ʽ��������Ҫ����Ϣ
 *  
 */
 public class Xml  {
//	 /** 
//	  * <br>��������getString
//	  * <br>��  �ã� ��Դ���������������ܹ���XMLִ�м����������������ɽ����¼�������������������
//	  * <br>��  ���� ArrayList Txt,String searchKind,String type
//	  * <br>�������� ArrayList  �����¼�� 
//	  *  
//	  */
//	 public ArrayList<Result> getString(List<String> Txt,String searchKind,String type)
//		throws UnsupportedEncodingException{
//		 IndexHolder in = null;
//		 try {
//			in = IndexHolder.init(UtilClass.getPath("webapps"+"\\index"));
//			in.find(Result.class, BooleanQuery, filter, sort, page, count);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 return null;
//	 }
   Result results;
   ArrayList<Result> info=new ArrayList<Result>();
   int ii=0;
   String staytime;
   String id;
   String title;
   String kind;
   String describe;
   String date;
   String url;
   String author;
   String publisher;
   List<String> searchContent;	
   private String[] kinds;	
//	List searchContentSplitList=null;

	
	 /** 
	  * <br>��������getString
	  * <br>��  �ã� ��Դ���������������ܹ���XMLִ�м����������������ɽ����¼�������������������
	  * <br>��  ���� ArrayList Txt,String searchKind,String type
	  * <br>�������� ArrayList  �����¼�� 
	  *  
	  */
	public ArrayList<Result> getString(List<String> Txt,String searchKind,String type)
			throws UnsupportedEncodingException{
		System.out.println("������ʽΪ��" + type);		
		String tomcat=UtilClass.getPath("webapps");       
        String filepath= tomcat+"\\"+"test.xml";
        this.searchContent=Txt;
		if(searchKind.equals("document")){
			kinds = new String[]{"doc","ppt"};
			}
		else if(searchKind.equals("mp3")){
			kinds = new String[]{"mp3","wma"};
			}
		else if(searchKind.equals("video")){
			kinds = new String[]{"asf","avi","rm","swf","wmv"};
			}
		else if(searchKind.equals("picture")){
			kinds = new String[]{"jpg","gif","bmp","jpeg","psd","png","pcx","tiff"};
			}
		else kinds=new String[]{"all"};	
    	SAXReader reader = new SAXReader(); 
		Document document = null;
		try {
			document = reader.read("file:\\"+filepath);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement(); 
		Element foo = null;
		Iterator<?>  it = root.elementIterator("resourceitem"); 
		//��������XML�ĵ�����
		while (it.hasNext()) { 	
			foo =  (Element) it.next(); 	
			String keywords= foo.elementText("keywords"); 
			 kind=foo.elementText("kind");
	    	 id=foo.elementText("id");
			 title=foo.elementText("title");
			  describe=foo.elementText("describe");
			  date=foo.elementText("date");
			  url=foo.elementText("url");
			  author=foo.elementText("author");
			 publisher=foo.elementText("publisher");
			if(keywords!=null ){	
					  //ѭ���ԱȲ�ѯ�ؼ����Ƿ����Ҫ��
				for(int index=0;index<searchContent.size();index++){
					
					
					
//		�Լ������͵ļ�������			
					boolean ok=false;
					if((type.equals("every"))&&(keywords.indexOf(searchContent.get(index).toString())!= -1)){
						ok=true;
						
					}else{
						 if(type.equals("all")){
							 ok=true;
						  for(int jj=0;jj<searchContent.size();jj++){
							 if(!keywords.equals(searchContent.get(jj).toString())){
								 ok=false;
								 break;
							 }
						  }    
						 }
					   else{
						 if(type.equals("complete")){
							 String ss="";
						  for(int jj=0;jj<searchContent.size();jj++){
							 ss+=searchContent.get(jj).toString();
							
							 }
						    if(keywords.indexOf(ss)!= -1){
							    ok=true;  
						     }else{ok=false;}
						  }else{
							 if(type.equals("same")){       //��ؼ�����ȫƥ�� 
								 //��ؼ����Զ��Ų��
								    String[] chai;
				                    if(keywords.indexOf(",")!= -1){
				                  	  chai=keywords.split(",");
				                    }else{
				                  	  chai=keywords.split("��");
				                    }
				                    //��ؼ����Զ��Ų��
								 String sss="";
								 for(int jj=0;jj<searchContent.size();jj++){
							          sss+=searchContent.get(jj).toString();
							         }    
								        ok=false;
								    for(int jj=0;jj<chai.length;jj++){
									    if(sss.equals(chai[jj])){ 
									       ok=true; 
									       break;
									     }
								     }
							    }      
						    }    
						 } 
					 }
	//�������ʹ������			
				
					
					  // ����Ҫ��     
					if (ok){  // ����Ҫ��
						
							
						  //�ж� ��ǰ��¼�� ��� �Ƿ�� ���������ͬ��
						  boolean KindCom=false;
						  if(kinds[0].equals("all")){
							  KindCom=true;       //�������Ϊ�� ��ʾ֧���κθ�ʽ������
					       }
						  for(int j=0;j<kinds.length;j++){
						    if(kind.equals(kinds[j])){
						    	KindCom=true;                    //�������Ҫ���������� KindCom Ϊ  true
						      break;
						    }
						  }
						  
					  if(KindCom){
							//�жϹؼ�����ʹ��Ӣ�� ���Ż������Ķ���  
						    //��ģ���Ŀ����Ϊ�˸����ݴ�� ��ȡ���ļ�ֵ��
						  
					/*
					 * �˿�Ϊ���չؼ��ֽ�����������  ��ʱ����
					*	
					    String[] key;
	                    if(keywords.indexOf(",")!= -1){
	                  	  key=keywords.split(",");
	                    }else{
	                  	  key=keywords.split("��");
	                    }
	                    double price = 0;
	                  for(int y=0;y<key.length;y++){
	                	  if(key[y].indexOf(searchContent.get(index).toString())!= -1){
	     					 price=((double)searchContent.get(index).toString().length()/(double)key[y].length());
	     				     break;
	                	  }
	                  }
	               */   
			/*
			 * �˿�Ϊ����title������������
			 */  
					
						  DecimalFormat   nf   =   new   DecimalFormat("##0.##");   
						   double price=0;
						  String key=title;

		                	  if(key.indexOf(searchContent.get(index).toString())!= -1){
		 						 price=((float)searchContent.get(index).toString().length()/(float)key.length()); 
							     price = Double.parseDouble(nf.format(price))*100;
		                	  }else{
		                		  
		                		  price=0;
		                	  }
      
	  
			/*
			 * �˿�Ϊ����title������������
			 */	
						  
						  
	                  //���ùؼ��ֱ��
                        String title2=Turnred.turn(title, searchContent);
	                    String describe2=Turnred.turn(describe, searchContent);
	                  //�ؼ��ֱ�촦�����
	                    
	                    
	                      results=new Result();
                           results.addinfo(id,title2,kind,describe2,date,url,author,publisher,price);
                           info.add(results);
                          
	    		           break;
					   }
					
					
				     }		      
				}  
			}
		}
		return info;
	}	
}