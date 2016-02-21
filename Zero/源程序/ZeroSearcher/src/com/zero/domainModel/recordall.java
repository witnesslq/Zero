package com.zero.domainModel;
/** 
* <p>类  名：recordall
* <p>作  用：构建一个记录集
*/
public class recordall{
     String id;
	 String title;
	 String describe;
	 String date;

	
		/** 
		* <br>函数名：addjilu
		* <br>作  用：向记录集里面添加数据
		* <br>参  数：String a,String b,String d,String e
		* <br>返回类型： 空 
		*/
	public void addrecord(String a,String b,String d,String e){
		this.id=a;
		this.title=b;
		this.describe=d;
		this.date=e;
	}
}