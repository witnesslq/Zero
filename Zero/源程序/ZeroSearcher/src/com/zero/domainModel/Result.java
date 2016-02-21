package com.zero.domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zero.util.UtilClass;

/** 
* <p>类名：result
* <p>作  用： 检索结果存储模型用以实现远程检索时结果的传递，每个类为一个单元
*  
*/
public class Result implements Serializable,Searchable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4917966228193074156L;
	/** 
	* <br>函数名：result
	* <br>作  用：构造方法
	*/
	public Result(){}
    private float boost = 1f;   
	/**
	 * 数据记录的id信息 
	 */
	private String id;     
	/**
 	 * 数据记录的title信息 
 	 */
	private String title;
    private String content;
 	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	/**
 	 * 数据记录的keywords信息 
 	 */
	private String keywords;
     
 	/**
 	 * 数据记录的kind信息 
 	 */
	private String kind;
     
 	/**
 	 * 数据记录的describe信息 
 	 */
	private String describe;
     
 	/**
 	 * 数据记录的date信息 
 	 */
	private String date;
     
 	/**
 	 * 数据记录的url信息 
 	 */
	private String url;
     
 	/**
 	 * 数据记录的author信息 
 	 */
	private String author;
     
 	/**
 	 * 数据记录的publisher信息 
 	 */
	private String publisher;
     
 	/**
 	 * 数据记录的Price信息， Price记录着数据的价值，后来的数据排序用
 	 */
	private double Price;
  	/**
  	 * 获取 数据的 价值
  	 */ 
	public double getPrice() {
	    return Price;
	}

	/**
	 * 设置 数据的 价值
	 */ 
	public void setPrice(double price) {
	    this.Price = price;
	}
	    
	  	/**
	  	 * 获取 数据的 作者
	  	 */ 
		public String getAuthor() {
			return author;
		}
		
	  	/**
	  	 * 设置 数据的 作者
	  	 */ 
		public void setAuthor(String author) {
			this.author = author;
		}
		
	  	/**
	  	 * 获取 数据的 发布日期
	  	 */ 
		public String getDate() {
			return date;
		}
		
	  	/**
	  	 * 设置 数据的 发布日期
	  	 */ 
		public void setDate(String date) {
			this.date = date;
		}
		
	  	/**
	  	 * 获取 数据的 描述
	  	 */ 
		public String getDescribe() {
			return describe;
		}
		
	  	/**
	  	 * 设置 数据的 描述
	  	 */ 
		public void setDescribe(String describe) {
			this.describe = describe;
		}
		
	  	/**
	  	 * 获取 数据的 ID
	  	 */ 
		public String getId() {
			return id;
		}
		
	  	/**
	  	 * 设置 数据的 ID
	  	 */ 
		public void setId(String id) {
			this.id = id;
		}
		
	  	/**
	  	 * 获取 数据的 关键字
	  	 */ 
		public String getKeywords() {
			return keywords;
		}
		
	  	/**
	  	 * 设置 数据的 关键字
	  	 */ 
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		
	  	/**
	  	 * 获取 数据的 类型
	  	 */ 
		public String getKind() {
			return kind;
		}
		
	  	/**
	  	 * 设置 数据的 类型
	  	 */ 
		public void setKind(String kind) {
			this.kind = kind;
		}
		
	  	/**
	  	 * 获取 数据的 发布单位
	  	 */ 
		public String getPublisher() {
			return publisher;
		}
		
	  	/**
	  	 * 设置 数据的 发布单位
	  	 */ 
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		
	  	/**
	  	 * 获取 数据的 标题
	  	 */ 
		public String getTitle() {
			return title;
		}
		
	  	/**
	  	 * 设置 数据的 标题
	  	 */ 
		public void setTitle(String title) {
			this.title = title;
		}
		
	  	/**
	  	 * 获取 数据的 地址
	  	 */ 
		public String getUrl() {
			return url;
		}
		
	  	/**
	  	 * 设置 数据的 地址
	  	 */ 
		public void setUrl(String url) {
			this.url = url;
		}
		
	  	/**
	  	 * <br>函数名：addjilu
	  	 * <br>从外部获取参数，并记录到当前类里面
	  	 */ 
          
		public void addinfo(String a,String b,String c,String d,String e,String f,String g,String h,double i){
			this.id=a;
			this.title=b;
			this.kind=c;
			this.describe=d;
			this.date=e;
			this.url=f;
			this.author=g;
			this.publisher=h;
			this.Price=i;
		}

		@Override
		public int compareTo(Searchable o) {
			// TODO Auto-generated method stub
			Result r = (Result) o; 
//			if(this.Price == r.getPrice()){
//				return 0;
//			}else if(this.Price > r.Price){
//				return 1;
//			}else{
//				return -1;
//			}
			
			if(this.boost == r.boost()){
				return 0;
			}else if(this.boost > r.boost){
				return 1;
			}else{
				return -1;
			}
			
		}

		@Override
		public long id() {
			// TODO Auto-generated method stub
			return Long.parseLong(id);
		}

		@Override
		public void setId(long id) {
			// TODO Auto-generated method stub
			this.id = Long.toString(id);
		}

		@Override
		public List<String> storeFields() {	
			List<String> list = new ArrayList<String>(50);
			list.add(FN_ID);
			list.add(FN_TITLE);
			list.add(FN_DESCRIBE);
			list.add(FN_KIND);
			list.add(FN_DATA);
			list.add(FN_URL);
			list.add(FN_AUTHOR);
			list.add(FN_PUBLISHER);
			list.add(FN_CONTENT);
			return list;
		}

		@Override
		public List<String> indexFields() {
			// TODO Auto-generated method stub
			List<String> list = new ArrayList<String>(50);
			list.add(FN_TITLE);
			list.add(FN_DESCRIBE);
			list.add(FN_AUTHOR);
			list.add(FN_PUBLISHER);
			list.add(FN_CONTENT);
			return list;
		}

		@Override
		public float boost() {
			// TODO Auto-generated method stub
			return boost;
		}
		
		/**
		 * 设置文档优先级
		 * @param boost
		 */
		public void setboost(float boost){
			this.boost = boost;
		}

		@Override
		public Map<String, String> extendStoreDatas() {
			// TODO Auto-generated method stub
			Map<String, String> map = new HashMap<String, String>();
			map.put(FN_CONTENT, content);
			return map;
		}

		@Override
		public Map<String, String> extendIndexDatas() {
			// TODO Auto-generated method stub
			Map<String, String> map = new HashMap<String, String>();
			map.put(FN_CONTENT, content);
			return map;
		}

		@Override
		public List<? extends Searchable> ListAfter(long id, int count) {
			// TODO Auto-generated method stub
			List<Result> list =  new ArrayList<Result>();
			for (Result result : UtilClass.result) {
				if(result.id()>id){
					list.add(result);
				}
			}
			return list;
		} 
}