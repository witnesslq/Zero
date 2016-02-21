package com.zero.domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zero.util.UtilClass;

/** 
* <p>������result
* <p>��  �ã� ��������洢ģ������ʵ��Զ�̼���ʱ����Ĵ��ݣ�ÿ����Ϊһ����Ԫ
*  
*/
public class Result implements Serializable,Searchable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4917966228193074156L;
	/** 
	* <br>��������result
	* <br>��  �ã����췽��
	*/
	public Result(){}
    private float boost = 1f;   
	/**
	 * ���ݼ�¼��id��Ϣ 
	 */
	private String id;     
	/**
 	 * ���ݼ�¼��title��Ϣ 
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
 	 * ���ݼ�¼��keywords��Ϣ 
 	 */
	private String keywords;
     
 	/**
 	 * ���ݼ�¼��kind��Ϣ 
 	 */
	private String kind;
     
 	/**
 	 * ���ݼ�¼��describe��Ϣ 
 	 */
	private String describe;
     
 	/**
 	 * ���ݼ�¼��date��Ϣ 
 	 */
	private String date;
     
 	/**
 	 * ���ݼ�¼��url��Ϣ 
 	 */
	private String url;
     
 	/**
 	 * ���ݼ�¼��author��Ϣ 
 	 */
	private String author;
     
 	/**
 	 * ���ݼ�¼��publisher��Ϣ 
 	 */
	private String publisher;
     
 	/**
 	 * ���ݼ�¼��Price��Ϣ�� Price��¼�����ݵļ�ֵ������������������
 	 */
	private double Price;
  	/**
  	 * ��ȡ ���ݵ� ��ֵ
  	 */ 
	public double getPrice() {
	    return Price;
	}

	/**
	 * ���� ���ݵ� ��ֵ
	 */ 
	public void setPrice(double price) {
	    this.Price = price;
	}
	    
	  	/**
	  	 * ��ȡ ���ݵ� ����
	  	 */ 
		public String getAuthor() {
			return author;
		}
		
	  	/**
	  	 * ���� ���ݵ� ����
	  	 */ 
		public void setAuthor(String author) {
			this.author = author;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ��������
	  	 */ 
		public String getDate() {
			return date;
		}
		
	  	/**
	  	 * ���� ���ݵ� ��������
	  	 */ 
		public void setDate(String date) {
			this.date = date;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ����
	  	 */ 
		public String getDescribe() {
			return describe;
		}
		
	  	/**
	  	 * ���� ���ݵ� ����
	  	 */ 
		public void setDescribe(String describe) {
			this.describe = describe;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ID
	  	 */ 
		public String getId() {
			return id;
		}
		
	  	/**
	  	 * ���� ���ݵ� ID
	  	 */ 
		public void setId(String id) {
			this.id = id;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� �ؼ���
	  	 */ 
		public String getKeywords() {
			return keywords;
		}
		
	  	/**
	  	 * ���� ���ݵ� �ؼ���
	  	 */ 
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ����
	  	 */ 
		public String getKind() {
			return kind;
		}
		
	  	/**
	  	 * ���� ���ݵ� ����
	  	 */ 
		public void setKind(String kind) {
			this.kind = kind;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ������λ
	  	 */ 
		public String getPublisher() {
			return publisher;
		}
		
	  	/**
	  	 * ���� ���ݵ� ������λ
	  	 */ 
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ����
	  	 */ 
		public String getTitle() {
			return title;
		}
		
	  	/**
	  	 * ���� ���ݵ� ����
	  	 */ 
		public void setTitle(String title) {
			this.title = title;
		}
		
	  	/**
	  	 * ��ȡ ���ݵ� ��ַ
	  	 */ 
		public String getUrl() {
			return url;
		}
		
	  	/**
	  	 * ���� ���ݵ� ��ַ
	  	 */ 
		public void setUrl(String url) {
			this.url = url;
		}
		
	  	/**
	  	 * <br>��������addjilu
	  	 * <br>���ⲿ��ȡ����������¼����ǰ������
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
		 * �����ĵ����ȼ�
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