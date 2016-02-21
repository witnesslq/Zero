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
 * <p>类  名： xml
 * <p>作  用： 资源检索的执行模块 解析XML文档并能够根据不同的检索方式检索出需要的信息
 *  
 */
 public class Xml  {
//	 /** 
//	  * <br>函数名：getString
//	  * <br>作  用： 资源检索的主方法，能够对XML执行检索并根据需求生成结果记录集返回请求检索的主机
//	  * <br>参  数： ArrayList Txt,String searchKind,String type
//	  * <br>返回类型 ArrayList  结果记录集 
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
	  * <br>函数名：getString
	  * <br>作  用： 资源检索的主方法，能够对XML执行检索并根据需求生成结果记录集返回请求检索的主机
	  * <br>参  数： ArrayList Txt,String searchKind,String type
	  * <br>返回类型 ArrayList  结果记录集 
	  *  
	  */
	public ArrayList<Result> getString(List<String> Txt,String searchKind,String type)
			throws UnsupportedEncodingException{
		System.out.println("检索方式为：" + type);		
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
		//遍历检索XML文档内容
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
					  //循环对比查询关键字是否符合要求
				for(int index=0;index<searchContent.size();index++){
					
					
					
//		对检索类型的检索处理			
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
							 if(type.equals("same")){       //与关键字完全匹配 
								 //多关键字以逗号拆分
								    String[] chai;
				                    if(keywords.indexOf(",")!= -1){
				                  	  chai=keywords.split(",");
				                    }else{
				                  	  chai=keywords.split("，");
				                    }
				                    //多关键字以逗号拆分
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
	//检索类型处理完毕			
				
					
					  // 符合要求     
					if (ok){  // 符合要求
						
							
						  //判断 当前记录的 类别 是否和 搜索类别相同，
						  boolean KindCom=false;
						  if(kinds[0].equals("all")){
							  KindCom=true;       //如果类型为空 表示支持任何格式的类型
					       }
						  for(int j=0;j<kinds.length;j++){
						    if(kind.equals(kinds[j])){
						    	KindCom=true;                    //如果属于要搜索的类型 KindCom 为  true
						      break;
						    }
						  }
						  
					  if(KindCom){
							//判断关键字中使用英文 逗号还是中文逗号  
						    //本模块的目的是为了给数据打分 获取他的价值性
						  
					/*
					 * 此块为按照关键字进行数据排序  暂时禁用
					*	
					    String[] key;
	                    if(keywords.indexOf(",")!= -1){
	                  	  key=keywords.split(",");
	                    }else{
	                  	  key=keywords.split("，");
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
			 * 此块为按照title进行数据排序
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
			 * 此块为按照title进行数据排序
			 */	
						  
						  
	                  //设置关键字变红
                        String title2=Turnred.turn(title, searchContent);
	                    String describe2=Turnred.turn(describe, searchContent);
	                  //关键字变红处理完毕
	                    
	                    
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